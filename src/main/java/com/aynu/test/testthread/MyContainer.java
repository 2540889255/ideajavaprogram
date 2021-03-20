package com.aynu.test.testthread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 */
public class MyContainer<T> {

    LinkedList<T> list=new LinkedList<>();

    int Max=9;

    int count=0;
    public synchronized void add(T object){

        while (list.size()==Max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(object);
        System.out.println(Thread.currentThread().getName()+"线程已经生产了一个对象");
        count++;
        this.notifyAll();

    }

    public synchronized T get() throws InterruptedException {
        while (list.size()==0){
            this.wait();
        }
        T first = list.removeFirst();
        System.out.println(Thread.currentThread().getName()+"消费者已经消费了一个对象");
        count--;
        this.notifyAll();
        return first;
    }



    public static void main(String[] args) {

        MyContainer my=new MyContainer();

        for (int i = 0; i < 2; i++) {
            Thread thread=new Thread(() -> {
                for (int j = 0; j < 10 ; j++) {
                    Object object=new Object();
                    my.add(object);
/*
                    System.out.println(Thread.currentThread().getName()+" "+j);
*/
                }
            });
            thread.start();
        }


        for (int i = 0; i < 5; i++) {
            Thread thread1=new Thread(()-> {
                for (int j = 0; j < 4; j++) {
                    try {
                        Object o = my.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

            thread1.start();
        }


    }
}
