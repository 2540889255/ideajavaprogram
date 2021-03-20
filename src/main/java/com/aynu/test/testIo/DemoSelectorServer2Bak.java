package com.aynu.test.testIo;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

/**
 * @author admin
 */
public class DemoSelectorServer2Bak extends Thread{

    Logger logger= LoggerFactory.getLogger(DemoSelectorServer2.class);
    @Override
    public void run() {
        try (
                AsynchronousServerSocketChannel serverSocketChannel=AsynchronousServerSocketChannel.open();

        ){

            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(),666));
            while (true){

                serverSocketChannel.accept(serverSocketChannel, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                    @Override
                    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                        result.write(Charset.defaultCharset().encode("hello i am server"));
                        try {
                            result.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        DemoSelectorServer2 demoSelectorServer2=new DemoSelectorServer2();
        demoSelectorServer2.start();
        try (
                Socket socket=new Socket(InetAddress.getLocalHost(),666);
        ){
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.lines().forEach((s) -> System.out.println(s));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
