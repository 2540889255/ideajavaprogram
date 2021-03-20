package com.aynu.test.testIo;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author admin
 * @Auther: LC
 * @Date : 2021 01 28 12:55
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class EchoServer {

    private  int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {

        /*if (args.length!=1){
            System.out.println("please enter the right number");
        }
        new EchoServer(Integer.valueOf(args[0])).start();*/
        new EchoServer(1000).start();
    }

    public void start() throws InterruptedException {
        EchoServerHandler echoServerHandler=new EchoServerHandler();
         EventLoopGroup group=new NioEventLoopGroup();//创建server-eventloop对象

        try {
            final AttributeKey id=AttributeKey.newInstance("id");
            ServerBootstrap bootstrap=new ServerBootstrap();//创建server-bootstrap
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class) //使用指定的nio的channel进行传送
                    .localAddress(new InetSocketAddress(port))//使用指定端口的套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {//添加一个echoserver,个人理解创建socket服务器连接之后，
                        // 在bootstrap之中childhandler中，当有新的channel进行连接的时候，会创建一个对应的handler添加到
                        // 该channel中的pipel中，在这之中创建的的是我们自定义的echoserverhandler，对于
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);//echoServerHandler注解被标注为@share
                        }
                    });
            bootstrap.attr(id,12345);
            bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000);
            ChannelFuture sync = bootstrap.bind().sync();//异步绑定服务器；调用sync()方法阻塞直到绑定完成
            sync.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("the response is end ");
                }

            });
            sync.channel().closeFuture().sync();//获取channel的closefuture，并且阻塞当前线程直到线程完成

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync();
        }

    }

    @Test
    public void show(){


    }

}
