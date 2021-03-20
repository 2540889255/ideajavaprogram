package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 01 31 19:14
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {


    int length=0;

    public FixedLengthFrameDecoder(int length) {
        if (length<=0){
            throw new IllegalArgumentException();
        }
        this.length = length;
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        while (in.readableBytes()>= length) {//检查是否有足够的的字节可以读取
            ByteBuf slice = in.readBytes(length);
            slice.writeByte(0);
            out.add(slice);
        }
    }




}
