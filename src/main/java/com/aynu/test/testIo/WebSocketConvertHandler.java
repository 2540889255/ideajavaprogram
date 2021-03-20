package com.aynu.test.testIo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.*;

import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 01 31 23:04
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class WebSocketConvertHandler extends MessageToMessageCodec<WebSocketFrame,WebSocketConvertHandler.MyWebSocketFrame> {


    @Override
    protected void encode(ChannelHandlerContext ctx, MyWebSocketFrame msg, List<Object> out) throws Exception {
        ByteBuf duplicate = msg.getBuf().duplicate();
        switch (msg.getType()){
            case BINARY:
                out.add(new BinaryWebSocketFrame(duplicate));
            case PING:
                out.add(new PingWebSocketFrame(duplicate));
            case PONG:
                out.add(new PongWebSocketFrame(duplicate));
            case TEXT:
                out.add(new TextWebSocketFrame(duplicate));
            case CLOSE:
                out.add(new CloseWebSocketFrame(true,0,duplicate));
            case CONTINUATION:
                out.add(new ContinuationWebSocketFrame(duplicate));
            default:
                throw new IllegalArgumentException();
        }

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, WebSocketFrame msg, List<Object> out) throws Exception {

        ByteBuf duplicate = msg.content().duplicate();

        if (msg instanceof BinaryWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.BINARY,duplicate));
        }
        if (msg instanceof CloseWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.CLOSE,duplicate));
        }
        if (msg instanceof PingWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.PING,duplicate));
        }
        if (msg instanceof PongWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.PONG,duplicate));
        }
        if (msg instanceof TextWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.TEXT,duplicate));
        }
        if (msg instanceof ContinuationWebSocketFrame){
            out.add(new MyWebSocketFrame(MyWebSocketFrame.FrameType.CONTINUATION,duplicate));
        }


    }

    public static final class MyWebSocketFrame{


        public MyWebSocketFrame(FrameType type, ByteBuf buf) {
            this.type = type;
            this.buf = buf;
        }

        public enum FrameType{
            BINARY,
            CLOSE,
            PING,
            PONG,
            TEXT,
            CONTINUATION
        }
        private final FrameType type;
        private final ByteBuf buf;

        public FrameType getType() {
            return type;
        }

        public ByteBuf getBuf() {
            return buf;
        }
    }
}
