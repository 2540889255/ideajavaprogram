package com.aynu.test.testCollection;

import com.aynu.test.designmode.ListenerDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @Auther: LC
 * @Date : 2021 02 04 10:27
 * @Description : com.aynu.test.testCollection
 * @Version 1.0
 */
public class HashMapSpliterator {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        List list=new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add("number"+i);
        }

        Spliterator spliterator = list.spliterator();
        Spliterator spliterator1 = spliterator.trySplit();
        Spliterator spliterator2 = spliterator1.trySplit();

        spliteratorThread spliteratorThread=new spliteratorThread(spliterator);
        spliteratorThread spliteratorThread1=new spliteratorThread(spliterator1);
        spliteratorThread spliteratorThread2=new spliteratorThread(spliterator2);

        Thread thread=new Thread(spliteratorThread);
        Thread thread1=new Thread(spliteratorThread1);
        Thread thread2=new Thread(spliteratorThread2);

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }




}
class spliteratorThread implements Runnable{

    Spliterator spliterator;

    public spliteratorThread(Spliterator spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public void run() {

        spliterator.forEachRemaining(s -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+s);
        });

    }
}