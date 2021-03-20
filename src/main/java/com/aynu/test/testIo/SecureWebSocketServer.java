package com.aynu.test.testIo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

/**
 * @Auther: LC
 * @Date : 2021 02 02 17:12
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class SecureWebSocketServer extends WebSocketServer{

    SslContext sslContext;

    public SecureWebSocketServer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    public ChannelFuture start() {
        ChannelFuture channelFuture = super.start();
        return channelFuture;
    }


    @Override
    public ChannelInitializer<Channel> creathandler(ChannelGroup channelGroup) {
        return new SecureChatIninializer(channelGroup,sslContext);
    }


    public static void main(String[] args) {
        SelfSignedCertificate selfSignedCertificate = null;

        SslContext sslContext=null;
        try {
            selfSignedCertificate =new SelfSignedCertificate();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        try {
            sslContext = SslContext.newServerContext(selfSignedCertificate.certificate(),selfSignedCertificate.privateKey());
        } catch (SSLException e) {
            e.printStackTrace();
        }

        SecureWebSocketServer server=new SecureWebSocketServer(sslContext);

        ChannelFuture future = server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(
                ()->{
                    server.destory();
                }
        ));
        future.channel().closeFuture().syncUninterruptibly();
    }
}
