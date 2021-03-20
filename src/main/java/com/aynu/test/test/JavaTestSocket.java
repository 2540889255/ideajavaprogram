package com.aynu.test.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author admin
 */
public class JavaTestSocket {


    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket=new Socket("182.92.86.253",22);
        InputStream stream=socket.getInputStream();
        while (true){
            Thread.sleep(2000);
        }
    }
}
