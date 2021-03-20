package com.aynu.test.testIo;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;
import java.net.http.WebSocket;
import java.util.concurrent.Callable;

/**
 * @Auther: LC
 * @Date : 2021 02 01 14:30
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class WebsocketHandlerInitializer extends ChannelInitializer<Channel> {

    private boolean isClient;

    private SslContext sslContext;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        ByteBufAllocator alloc = ch.alloc();

        SSLEngine sslEngine = sslContext.newEngine(alloc);

        pipeline.addFirst("ssl",new SslHandler(sslEngine))
                .addLast(new HttpObjectAggregator(65536))//为握手提供聚合的httprequest，将最大消息为65536的HttpObjectAggregator添加到channepipeline
                .addLast(new WebSocketServerProtocolHandler("/websocket"))
                .addLast(new TextFrameHandler())
                .addLast(new BinaryFrameHandler())
                .addLast(new ContinuationFrameHandler());
    }



    public static final class TextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
            System.out.println("i am TextFrameHandler i received the message");
        }


    }

    public static final class BinaryFrameHandler extends SimpleChannelInboundHandler<BinaryWebSocketFrame>{

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) throws Exception {
            System.out.println("i am BinaryFrameHandler i received the message");
        }
    }

    public static final class ContinuationFrameHandler extends SimpleChannelInboundHandler<ContinuationWebSocketFrame>{

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, ContinuationWebSocketFrame msg) throws Exception {
            System.out.println("i am continuationFrameHandler i received the message");
        }
    }
}
