package com.aynu.test.testIo;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.*;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 模拟Socket进行测试
 * @author admin
 */
public class DemoServer1 extends Thread{

    ServerSocket serverSocket;

    Logger logger=LoggerFactory.getLogger(DemoServer1.class);
    public int getPort(){
        int port = serverSocket.getLocalPort();

        logger.info(() -> {
            return "port is "+port;
        });

        return port;
    }

    @Override
    public void run() {
        try {
            //使用线程池对于监听进行升级
            serverSocket=new ServerSocket(0);
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            while (true){
                Socket accept = serverSocket.accept();
                RequestHandler requestHandler=new RequestHandler(accept);
                executorService.execute(requestHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                };
            }
        }

        /*while (true){

        }*/
    }

    public static void main(String[] args) throws UnknownHostException {

        DemoServer1 demoServer=new DemoServer1();
        demoServer.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(),demoServer.getPort())) {
            InputStream inputStream = client.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            reader.lines().forEach( s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



class RequestHandler extends Thread{

    Socket socket;

    public RequestHandler(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.println("hello  i am server");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}