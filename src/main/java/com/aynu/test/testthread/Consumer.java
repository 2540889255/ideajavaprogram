package com.aynu.test.testthread;

import java.util.Random;

public class Consumer implements Runnable {
    public  Drop drop;

    public Consumer(Drop drop) {
        this.drop=drop;
    }



    @Override
    public void run() {
        String message=drop.teke();
        Random random=new Random();
        while (message!="over"){
            System.out.println(message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message=drop.teke();
        }



    }
}
