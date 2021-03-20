package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Auther: LC
 * @Date : 2021 02 01 11:32
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class HttpFIxedHandlerInitlazer extends ChannelInitializer<Channel> {

    boolean isClient;

    public HttpFIxedHandlerInitlazer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (isClient){
            pipeline.addLast(new HttpClientCodec());//添加聚合的httpClient编解码器
        }else{
            pipeline.addLast(new HttpServerCodec());//添加聚合的httpserver编解码器
        }
    }
}
