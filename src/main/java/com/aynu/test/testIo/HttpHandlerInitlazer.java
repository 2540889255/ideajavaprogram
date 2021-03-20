package com.aynu.test.testIo;

import com.sun.net.httpserver.HttpHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @Auther: LC
 * @Date : 2021 02 01 11:17
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class HttpHandlerInitlazer extends ChannelInitializer<Channel> {

    private boolean isClient;

    public HttpHandlerInitlazer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (isClient){
            pipeline.addLast("decode",new HttpResponseDecoder());
            pipeline.addLast("encode",new HttpRequestEncoder());
        }else{
            pipeline.addLast("decode",new HttpRequestDecoder());
            pipeline.addLast("encode",new HttpResponseEncoder());
        }


    }
}
