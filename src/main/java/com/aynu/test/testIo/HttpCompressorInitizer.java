package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Auther: LC
 * @Date : 2021 02 01 12:58
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class HttpCompressorInitizer extends ChannelInitializer<Channel> {

    private boolean isClient;

    public HttpCompressorInitizer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        if (isClient){
            ch.pipeline().addLast(new HttpClientCodec());//如果是客户端，则添加httpclientcodec
            //如果是客户端，则添加httpcontentdecompressor，处理来自服务端的压缩的内容
            ch.pipeline().addLast(new HttpContentDecompressor());
        }else{
            ch.pipeline().addLast(new HttpServerCodec());
            ch.pipeline().addLast(new HttpContentCompressor());//如果是服务端，则添加，对于客户端支持的压缩类型进行消息的压缩
        }

    }



}
