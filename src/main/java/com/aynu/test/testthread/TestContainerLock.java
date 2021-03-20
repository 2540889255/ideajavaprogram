package com.aynu.test.testthread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class TestContainerLock {

    public List list=new ArrayList();

    public void add(Object object){
        list.add(object);
    }

    public int getSize(){
        return list.size();
    }


    public static void main(String[] args) {

        TestContainerLock testContainerLock=new TestContainerLock();


        Object lock=new Object();
        Thread thread=new Thread(() -> {
            System.out.println("T1 start");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    testContainerLock.add(new Object());
                    System.out.println(i);
                    if (testContainerLock.getSize()==5){
                        lock.notify();
                        //Thread.currentThread().notify();
                        try {
                            //Thread.currentThread().wait();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

            System.out.println("T1 end");
        });

        Thread thread1=new Thread(() -> {
            System.out.println("T2 start ");
            synchronized (lock){
                if (testContainerLock.getSize()!=5){
                    try {
                        lock.wait();
                        //Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hello 你已经输出到5");
                }
                lock.notify();
                //Thread.currentThread().notify();
            }
            System.out.println("T2 end");
        });

        thread.start();
        thread1.start();
    }
}
