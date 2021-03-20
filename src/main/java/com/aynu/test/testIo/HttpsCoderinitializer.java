package com.aynu.test.testIo;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Auther: LC
 * @Date : 2021 02 01 13:09
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class HttpsCoderinitializer extends ChannelInitializer<Channel> {

    private boolean isClient;

    private SslContext sslContext;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        ByteBufAllocator alloc = ch.alloc();
        SSLEngine sslEngine = sslContext.newEngine(alloc);
        pipeline.addFirst(new SslHandler(sslEngine));
        if (isClient){
            pipeline.addLast(new HttpClientCodec());
        }else{
            pipeline.addLast(new HttpServerCodec());
        }

    }
}
