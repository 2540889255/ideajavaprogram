package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

/**
 * @Auther: LC
 * @Date : 2021 01 29 11:14
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
@ChannelHandler.Sharable//标记该类的实例可以被多个channel共享
public class EchoClientHandler extends SimpleChannelInboundHandler {
//这是客户端的事件处理器

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("the client has some error");
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("hello client you have connect to me");
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));//当被通知channel是活跃的时候，发送一条短信
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        //当服务端接收到一套消息时被调用
        System.out.println("the server has receive "+((ByteBuf)msg).toString(CharsetUtil.UTF_8));
    }


}
