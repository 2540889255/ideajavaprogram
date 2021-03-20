package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 01 15:06
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class IdleStateHandlerInitializer extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(0,0,60, TimeUnit.SECONDS));
        pipeline.addLast(new HeartBeatHandler());
    }


    public static final class HeartBeatHandler extends SimpleChannelInboundHandler {


        private ByteBuf HEART_BEAT= Unpooled.copiedBuffer("HEARTBEAT", CharsetUtil.UTF_8);


        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            if (evt instanceof IdleStateHandler){
                ctx.writeAndFlush(HEART_BEAT.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }else{
                super.userEventTriggered(ctx,evt);
            }
        }

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof IdleStateHandler){

            }
        }
    }
}
