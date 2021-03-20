package com.aynu.test.testIo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * @Auther: LC
 * @Date : 2021 02 02 9:38
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
//拓展simplechannelinboundhandler，并处理textwebsocketframe请求
public class TextWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private ChannelGroup group;

    public TextWebSocketHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        ctx.writeAndFlush(msg.retain());
    }

    //心跳触发时间
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //判断是否为心跳，如果是的话，则从请求处理中删除ssl请求连接处理器，否则的话，就是对于textwebsocketframe信息的处理
        if (evt== WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE){
            //从channelpiple中移除httprequesthandler，因为连接成功之后，就不会发送http建立连接的请求了
            ctx.pipeline().remove(HttpRequestHandler.class);
            //通知所有的已经连接的websocket客户端，新的客户端已经连接上
            group.writeAndFlush(new TextWebSocketFrame("Client"+ctx.channel()+"is connect"));

        }else {

            super.userEventTriggered(ctx,evt);
        }
    }


}
