package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Auther: LC
 * @Date : 2021 01 27 23:01
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
@ChannelHandler.Sharable //表示一个channel-handler可以被多个channel安全的共享
public class EchoServerHandler extends ChannelHandlerAdapter {
//这是服务端的事件处理器

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印异常的堆栈
        ctx.close();//关闭该channel
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf=(ByteBuf) msg;
        System.out.println("server received "+byteBuf.toString(CharsetUtil.UTF_8));
        ctx.write(byteBuf);//将接收到的消息写发送者，但是不使用flush冲刷出站信息
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("the server has sent the last message");
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);//将未决消息冲刷到远程节点，并且关闭该channel

    }

    @Test
    public void show(){
        ByteBuf byteBuf=Unpooled.copiedBuffer("hell\ro",CharsetUtil.UTF_8);
        int i = byteBuf.forEachByte(ByteBufProcessor.FIND_CR);
        System.out.println(i);
        System.out.println("test2");
        ByteBuf byteBuf2=Unpooled.copiedBuffer("he\rllo",CharsetUtil.UTF_8);
        System.out.println(byteBuf2.capacity());
        for (int j = 0; j < byteBuf2.capacity(); j++) {

            System.out.println((char) byteBuf2.getByte(j));
        }
    }

    @Test
    public void test(){
        ByteBuf byteBuf = Unpooled.copiedBuffer("123456788890", CharsetUtil.UTF_8);
        ByteBuf slice = byteBuf.slice();
        ByteBuf slice1 = slice.slice(0, 3);
        byteBuf.setByte(0,(byte)'j');
        for (int j = 0; j < slice1.capacity(); j++) {

            System.out.println((char) slice1.getByte(j));
        }
//        ByteBuf copy = byteBuf.copy(0, 3);
    }

    @Test
    public void test2(){
        //测试bytebuf的get和set和read和write
        ByteBuf byteBuf = Unpooled.copiedBuffer("123456788890", CharsetUtil.UTF_8);

        while (true){
            byte aByte = byteBuf.getByte(1);
            System.out.println((char) aByte);
        }
    }

    @Test
    public void test3(){
        //测试bytebuf的get和set和read和write
        ByteBuf byteBuf = Unpooled.copiedBuffer("123456788890", CharsetUtil.UTF_8);
        int a=0;
        for (int i = 0; i < 100; i++) {
            if (a==0){
                ByteBuf byteBuf1 = byteBuf.writeByte(0);
                System.out.println("this is write "+(char)byteBuf1.getByte(0));
                a=1;
            }

            byte aByte = byteBuf.readByte();
            System.out.println((char) aByte);
        }
    }

    @Test
    public void test4(){
        //测试bytebuf的get和set和read和write
        ByteBuf byteBuf = Unpooled.copiedBuffer("123456788890", CharsetUtil.UTF_8);


        for (int j = 0; j < 3; j++) {

        System.out.println((char) byteBuf.readByte());
        }
        ByteBuf byteBuf1 = byteBuf.writeByte(0);
        System.out.println("this is write "+(char)byteBuf1.getByte(0));
        for (int j = 0; j < 3; j++) {

            System.out.println((char) byteBuf.readByte());
        }
    }

}
