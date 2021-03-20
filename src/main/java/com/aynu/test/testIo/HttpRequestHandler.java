package com.aynu.test.testIo;

import com.aynu.test.testthread.test;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;
import joptsimple.internal.Strings;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Auther: LC
 * @Date : 2021 02 01 16:48
 * @Description : com.aynu.test.testIo
 * @Version 1.0
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    Logger logger=LoggerFactory.getLogger(HttpRequestHandler.class);
    private static final File INDEX;

    private String wsUri;
    static {

        URL location = HttpRequestHandler.class.getProtectionDomain().getCodeSource().getLocation();


        try {
            URI uri=location.toURI();
            /*String s = uri.toString()+"index.html";
            String result=!s.contains("file:")?s:s.substring(0,5);*/

            INDEX=new File("E:\\ideajavaprogram\\target\\classes\\index.html");
        } catch (URISyntaxException e) {

            throw new IllegalStateException("the request for local is filed");
        }

    }

    public HttpRequestHandler(String wsUri) {
        this.wsUri = wsUri;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest o) throws Exception {
        FullHttpRequest msg = o.retain();
        if (wsUri.equalsIgnoreCase(msg.uri())){
            ctx.fireChannelRead(msg.retain());//如果请求了websocket协议的升级版本，则增加引用计数器，将它传递给下一个channelinbound
        }else {
            RandomAccessFile file =new RandomAccessFile(INDEX,"rw");//读取index.html
            HttpResponse response=new DefaultHttpResponse(msg.protocolVersion(), HttpResponseStatus.OK);
            response.headers().set("text/html");
            ctx.write(msg);//将httpresponse加载到客户端里
            if (ctx.pipeline().get(SslHandler.class)==null){
                ctx.write(new DefaultFileRegion(file.getChannel(),0,file.length()));
            }else{
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }
            //最后发送一个空的然后告诉客户端流已经结束了

            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);

            /*ByteBuf byteBuf = ctx.alloc().directBuffer();
            byteBuf.refCnt();*/
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
