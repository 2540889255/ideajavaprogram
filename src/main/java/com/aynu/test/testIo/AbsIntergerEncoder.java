package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 01 31 21:24
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class AbsIntergerEncoder extends MessageToMessageEncoder<ByteBuf> {




    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        ByteBuf buf=(ByteBuf) msg;

        while (buf.readableBytes()>=4){
            int i = Math.abs(buf.readInt());
            out.add(String.valueOf(i));
        }
    }
}








