package com.aynu.test.testIo;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

/**
 * @Auther: LC
 * @Date : 2021 02 02 11:52
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class WebSocketServer {

    ChannelGroup channelGroup=new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    EventLoopGroup group=new NioEventLoopGroup();

    Channel channel;
    public static void main(String[] args) {
        WebSocketServer server=new WebSocketServer();

        ChannelFuture future = server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    server.destory();
                }
        ));

        future.channel().closeFuture().syncUninterruptibly();

    }


    public ChannelFuture start(){

        ServerBootstrap server=new ServerBootstrap();

        ChannelFuture channelFuture = null;
        server.group(group)
                .channel(NioServerSocketChannel.class)
                //设置为自定义的初始化
                .childHandler(creathandler(channelGroup));

            channelFuture= server.bind(1000);
            channelFuture.addListener((x)->{
                System.out.println("the server is start");
            });
            channelFuture.syncUninterruptibly();
            channel = channelFuture.channel();
            return channelFuture;
    }

    public ChannelInitializer<Channel> creathandler(ChannelGroup channelGroup) {
        return new ChatServerInitializer(channelGroup);
    }

    public void destory(){
        if (channel!=null){
            channel.close();
        }
        channelGroup.close();
        group.shutdownGracefully();

    }





}
