package com.aynu.test.testIo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Auther: LC
 * @Date : 2021 01 29 14:49
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class EchoClient {

    private int port;

    private String addr;

    public EchoClient(int port, String addr) {
        this.port = port;
        this.addr = addr;
    }

    public void start() throws InterruptedException {

        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();

        Bootstrap clientBootstrap=new Bootstrap();

        ChannelFuture sync=null;

        clientBootstrap.group(eventLoopGroup)
                        .channel(NioSocketChannel.class)
                        .remoteAddress(new InetSocketAddress(addr,port))
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new EchoClientHandler());
                            }
                        });

        try {
             sync = clientBootstrap.connect().sync();

                sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                eventLoopGroup.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        /*if (args.length!=2){
            System.out.println("please usage addr and port");
        }

        String host=args[0];
        int port=Integer.valueOf(args[1]);
        new EchoClient(port,host).start();*/
        new EchoClient(1000,"127.0.0.1").start();
   }
}
