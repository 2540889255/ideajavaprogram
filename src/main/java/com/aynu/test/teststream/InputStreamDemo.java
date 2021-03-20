package com.aynu.test.teststream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Auther: LC
 * @Date : 2021 03 19 14:00
 * @Description : com.aynu.test.teststream
 * @Version 1.0
 */
public class InputStreamDemo {

    public static void main(String[] args) {

        byte [] bytes=new byte[9];
        PipedInputStream inputStream=new PipedInputStream();

        PipedOutputStream outputStream=new PipedOutputStream();

        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     *
     **/
    @Test
    public void test() {

    }
}
