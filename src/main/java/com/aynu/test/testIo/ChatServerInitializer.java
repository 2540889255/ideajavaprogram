package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Auther: LC
 * @Date : 2021 02 02 10:25
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class ChatServerInitializer extends ChannelInitializer<Channel> {

    ChannelGroup group;
    public ChatServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //对于传入传出的编解码器进行一致性操作，将字节码解析为httprequest，httpcontent，lastHttpcontent
        //并将gttprequest，httpcontent，和lasthttpcontent编码为字节
        pipeline.addLast(new HttpServerCodec());
        //chunkwritehandler，这个是使用chunk块，对于传输的数据进行发送动作，如果是使用零拷贝，应该使用defaultregaion，
        pipeline.addLast(new ChunkedWriteHandler());
        //可以设置一次性交付的数据量，在进行完第一层过滤之后，传给后一个handler的数据量的大小，可以有效地解决分片问题
        //将一个httpmessage和跟随他的多个httpcontent聚合为单个的fullhttprequest或者fullhttpresponse
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        //处理那些不发送到/ws的请求
        pipeline.addLast(new HttpRequestHandler("/ws"));
        //按照websocket规范要求，处理websocket升级握手，pingwebsocketframe，pongwebsocketframe
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //处理websocketframe和握手事件
        pipeline.addLast(new TextWebSocketHandler(group));


    }



}
