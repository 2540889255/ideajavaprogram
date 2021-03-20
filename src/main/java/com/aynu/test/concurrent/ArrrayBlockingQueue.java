package com.aynu.test.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author admin
 */
public class ArrrayBlockingQueue {



    public static void main(String[] args) {

        BlockingQueue<String> queue=new ArrayBlockingQueue<String>(3);

        Thread product=new Thread(new Product(queue));
        product.start();
        Thread consumer=new Thread(new Consumer(queue));
        consumer.start();
    }



}

class Product implements  Runnable{

    BlockingQueue queue;


    public Product(BlockingQueue<String> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        int a=0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.size()<3){
                try {
                    queue.put(""+a++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Product creat a message"+a);
            }
        }


    }
}

class Consumer implements  Runnable{

    BlockingQueue queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.size()>0){
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer consumer a message");

        }
    }
}