package com.aynu.test.concurrent;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class TestThread implements Runnable{

    Random random=new Random(66);


    @Override
    public void run() {
        int i = random.nextInt(10);
        System.out.println(i);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            Thread thread=new Thread(new TestThread());
            thread.start();
        }
        /*Thread thread=new Thread(new TestThread());
        thread.start();
        Thread thread1=new Thread(new TestThread());
        thread1.start();*/


    }
}
