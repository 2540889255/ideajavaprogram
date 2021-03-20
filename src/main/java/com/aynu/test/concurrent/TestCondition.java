package com.aynu.test.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 */
public class TestCondition{

    private Lock lock=new ReentrantLock();
    private Condition notEmpty=lock.newCondition();

    private Condition notFull=lock.newCondition();

    static Object[] objects=new Object[30];

    static int size=0;


    public static void main(String[] args) throws InterruptedException {

        TestCondition testCondition=new TestCondition();
        Consumer consumer=testCondition.new Consumer();
        Provider provider=testCondition.new Provider();
        consumer.start();
        provider.start();
    }


     public class Provider extends Thread{
        @Override
        public void run() {
            while (true){

                lock.lock();
                while (size==10){

                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notEmpty.signal();
                objects[size]=new Object();
                System.out.println("生成了一个对象"+size);
                size++;
                lock.unlock();

            }
        }
    }

     public  class Consumer extends Thread{

        @Override
        public void run() {
            while (true){
                lock.lock();
                while (size==0){
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notFull.signal();
                objects[size]=null;
                System.out.println("消费了一个对象"+size);
                size--;
                lock.unlock();
            }
        }
    }
}
