package com.aynu.test.testIo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.apache.logging.log4j.core.LogEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

/**
 * @Auther: LC
 * @Date : 2021 02 02 21:59
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class LogEventBoradCaster {

    private EventLoopGroup eventLoopGroup;

    private Bootstrap bootstrap;

    private File file;

    public LogEventBoradCaster(InetSocketAddress socketAddress,File file) {
        eventLoopGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();

        bootstrap.group(eventLoopGroup)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(new LogEventEncoder(socketAddress));
        this.file = file;
    }

    public void run() throws IOException {
        Channel channel;
        try {
             channel = bootstrap.bind(0).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long pointer=0;

        for (;;) {
            long length=file.length();
            if (length<pointer){
                pointer=length;
            }
            else if (length>pointer){
                RandomAccessFile accessFile = null;
                try {
                    accessFile=new RandomAccessFile(file,"r");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                accessFile.seek(pointer);
                String line;
                while ((line=accessFile.readLine())!=null){
                    /*channel.writeAndFlush();*/

                }



            }
        }

    }

    public void stop() throws Exception {
        eventLoopGroup.close();
    }
    public static void main(String[] args) throws Exception {
        //创建并启动一个新的logeventbroadcase实例,使用logeventboradcaster进行创建的时候，
        LogEventBoradCaster boradCaster= new LogEventBoradCaster(new InetSocketAddress("255.255.255.255",Integer.parseInt("0")),new File(""));

        try {
            boradCaster.run();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            boradCaster.stop();
        }

    }
}
