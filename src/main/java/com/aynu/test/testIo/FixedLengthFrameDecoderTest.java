package com.aynu.test.testIo;

import com.sun.source.tree.AssertTree;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 01 31 18:21
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 * 测试自定义的编解码工具
 */
public class FixedLengthFrameDecoderTest {



    @Test
    public void test(){//第一个测试方法

        ByteBuf byteBuf= Unpooled.copiedBuffer("123456789", CharsetUtil.UTF_8);
        System.out.println("the first"+byteBuf.capacity());
        /*ByteBuf byteBuf=Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            byteBuf.writeByte(i);
        }*/
        //创建一个Embeddedcoder，并添加一个fixedLengthFrameDecoderTest，其将以三个字节进行测试
        ByteBuf input = byteBuf.duplicate();
        System.out.println(input.capacity());
        EmbeddedChannel embeddedChannel=new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        assert embeddedChannel.writeInbound(input,CharsetUtil.UTF_8);
        assert embeddedChannel.finish();


        ByteBuf o = (ByteBuf)embeddedChannel.readInbound();
        System.out.println(o.toString(CharsetUtil.UTF_8));
        o.release();
        System.out.println("------------------");
        ByteBuf byteBuf1 = byteBuf.readBytes(3);
        System.out.println(byteBuf1.toString(CharsetUtil.UTF_8));

        /*o = (ByteBuf)embeddedChannel.readInbound();
        System.out.println(o.toString(CharsetUtil.UTF_8));
        o.release();
        System.out.println("------------------");
        byteBuf1 = byteBuf.readBytes(3);
        System.out.println(byteBuf1.toString(CharsetUtil.UTF_8));*/

        System.out.println("the input capacity"+input.capacity());
        System.out.println("the last "+byteBuf.capacity());
    }


    @Test
    public void test1(){
        int tem=0;
        ByteBuf byteBuf=Unpooled.copiedBuffer("12345",CharsetUtil.UTF_8);
        ByteBuf byteBuf1 = byteBuf.readBytes(3);
        System.out.println(byteBuf1.toString(CharsetUtil.UTF_8));
    }


}
