package com.aynu.test.testthread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: LC
 * @Date : 2021 03 19 10:56
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class Reentranlock {

    public static void main(String[] args) {

        ReentrantLock lock=new ReentrantLock();

        lock.newCondition();
        RunThread thread=new RunThread(lock);
        ConsumerLock thread2=new ConsumerLock(lock);

        Thread threads1=new Thread(thread);
        Thread threads2=new Thread(thread2);

        threads1.start();
        threads2.start();
    }

    /**
     *
     **/
    @Test
    public void test() {

    }



}

class RunThread implements Runnable{

    ReentrantLock reentrantLock;


    public RunThread(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {

        reentrantLock.lock();


        try{
            System.out.println("生产者我到了"+Thread.currentThread().getName());
            //Condition condition = reentrantLock.newCondition();
            //condition.await();
            System.out.println("我到了"+Thread.currentThread().getName());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reentrantLock.unlock();
        }



    }
}


class ConsumerLock implements Runnable{

    ReentrantLock reentrantLock;

    public ConsumerLock(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {

        reentrantLock.lock();

        try{
            System.out.println("消费者到达了这");
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reentrantLock.unlock();
        }
    }
}
