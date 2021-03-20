package com.aynu.test.testthread;

import sun.misc.Unsafe;

import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 测试lock上锁
 * @author admin
 */
public class TestLock {

    public static class PrintQueue{

        private Lock queueLock;

        public PrintQueue(Boolean fairMode) {
            this.queueLock = new ReentrantLock(fairMode);
        }

        public void printJob(Object document){
            queueLock.lock();
            try {
                Long duration =(long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()+"printQueue print job during"+duration/1000+"seconds");
                Thread.sleep(duration);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                queueLock.unlock();
            }

            queueLock.lock();
            try {
                Long duration =(long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()+"printQueue print job during"+duration/1000+"seconds");
                Thread.sleep(duration);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                queueLock.unlock();
            }
        }
    }

    public static class Job implements Runnable{

        PrintQueue printQueue;
        public Job(PrintQueue printQueue) {
            this.printQueue=printQueue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"is going to job");
            printQueue.printJob(new Object());
            System.out.println(Thread.currentThread().getName()+"the document is having done");
        }
    }

    public static void main(String[] args) {
        System.out.println("Runing job is going :false");
        testPrintQueue(false);
        System.out.println("Runing job is going :true");
        testPrintQueue(true);
    }


    public static void testPrintQueue(Boolean fairMode){
        PrintQueue printQueue=new PrintQueue(fairMode);
        Thread[] threads=new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new Job(printQueue));
            threads[i]=thread;
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

/*
        Unsafe unsafe=new Unsafe();
*/
    }
}
