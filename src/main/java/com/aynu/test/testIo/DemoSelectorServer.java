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
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author admin
 */
public class DemoSelectorServer extends Thread {

    //生成日志打印
    Logger logger= LoggerFactory.getLogger(DemoSelectorServer.class);

    public int  getPort(){
        return 1;
    }
    @Override
    public void run() {
        try (   //创建一个selector，作为一个类似调度员的角色
                Selector selector=Selector.open();
             //
             ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        ){
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            //注册到selector，并说明关注点
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println(SelectionKey.OP_ACCEPT);
            while (true){
                //selector阻塞在select方法下
                int select = selector.select();
                System.out.println("i am server i cycle");
                System.out.println("the select is "+select);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                Thread.sleep(1000);
                logger.info( () ->String.valueOf("the SelectionKey is "+selectionKeys.size()));
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    SelectableChannel channel = next.channel();
                    sayHello((ServerSocketChannel)channel);
                }
                System.out.println("the program is run ");;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sayHello(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept();
        ){
            client.write(Charset.defaultCharset().encode("hello i am server"));
        }

    }

    public static void main(String[] args) {
        DemoSelectorServer selectorServer=new DemoSelectorServer();
        selectorServer.start();
        try {
            Socket client=new Socket(InetAddress.getLocalHost(),8888);
            InputStream inputStream = client.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.lines().forEach( x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Socket client2=new Socket(InetAddress.getLocalHost(),8888);
            InputStream inputStream = client2.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.lines().forEach( x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Socket client3=new Socket(InetAddress.getLocalHost(),8888);
            InputStream inputStream = client3.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.lines().forEach( x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Socket client4=new Socket(InetAddress.getLocalHost(),8888);
            InputStream inputStream = client4.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            bufferedReader.lines().forEach( x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){

        }

    }


}
