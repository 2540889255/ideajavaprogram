package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Auther: LC
 * @Date : 2021 02 01 10:06
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class SslContextHandler extends ChannelInitializer <Channel>{

    private SslContext context;

    private boolean isOn;

    public SslContextHandler(SslContext context, boolean isOn) {//传入要使用的context
        this.context = context;
        this.isOn = isOn;//如果设置为true，第一个写入的消息不会被加密，客户端应该设置为true,否则无法进行ssl连接
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {

        SSLEngine sslEngine = context.newEngine(ch.alloc());
        //每一个SSL实例，都使用channel的bytebuf-allocator从sslcontext获取新的SSLEngine
        ch.pipeline().addFirst("ssl",new SslHandler(sslEngine,true));

    }
}
