package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.util.ReadOnlyStringMap;


import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 02 02 21:31
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {

    InetSocketAddress socketAddress;

    public LogEventEncoder(InetSocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    //对于广播的消息进行加密
    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent msg, List<Object> out) throws Exception {


        byte[] message = msg.getMessage().getFormat().getBytes(StandardCharsets.UTF_8);

        byte[] loggerName = msg.getLoggerName().getBytes(StandardCharsets.UTF_8);

        ByteBuf buffer = ctx.alloc().buffer(message.length + loggerName.length + 1);

        buffer.writeBytes(message);

        buffer.writeBytes(loggerName);

        out.add(new DatagramPacket(buffer,socketAddress));



    }
}
