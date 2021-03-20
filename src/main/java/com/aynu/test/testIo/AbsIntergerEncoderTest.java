package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

/**
 * @Auther: LC
 * @Date : 2021 01 31 21:29
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class AbsIntergerEncoderTest {




    @Test
    public void Test(){

        ByteBuf buffer = Unpooled.buffer();

        for (int i = 1; i < 10; i++) {
            buffer.writeInt(i*-1);
        }

        ByteBuf input = buffer.duplicate();
        EmbeddedChannel embeddedChannel=new EmbeddedChannel(new AbsIntergerEncoder());

        embeddedChannel.writeOutbound(buffer);
        embeddedChannel.finish();
        /*Object o = embeddedChannel.readOutbound();
        ByteBuf buf=(ByteBuf) o;
        System.out.println(buf.toString(CharsetUtil.UTF_8));*/
        Object o = embeddedChannel.readOutbound();
        System.out.println((String) o);

        /*Integer a=(Integer)o;
        System.out.println((int)a);*/
    }

    @Test
    public void test(){
        ByteBuf byteBuf = Unpooled.copiedBuffer("123456", CharsetUtil.UTF_8);

        while (byteBuf.readableBytes()>=4){
            int i = byteBuf.readInt();
            System.out.println((char) i);
        }


    }
}
