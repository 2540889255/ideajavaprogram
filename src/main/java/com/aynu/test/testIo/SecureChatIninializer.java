package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Auther: LC
 * @Date : 2021 02 02 17:07
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class SecureChatIninializer extends ChatServerInitializer{

    private SslContext sslContext;

    public SecureChatIninializer(ChannelGroup group,SslContext sslContext) {
        super(group);
        this.sslContext=sslContext;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        SSLEngine sslEngine = sslContext.newEngine(ch.alloc());
        SslHandler sslHandler=new SslHandler(sslEngine);
        ch.pipeline().addFirst(sslHandler);
    }
}
