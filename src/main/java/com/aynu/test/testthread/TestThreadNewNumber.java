package com.aynu.test.testthread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class TestThreadNewNumber implements Runnable{

    private volatile int number=100;

    static Map map=new HashMap();;


    public static void main(String[] args) throws InterruptedException {
        TestThreadNewNumber testThreadNewNumber = new TestThreadNewNumber();
        Thread[] threads=new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread=new Thread(testThreadNewNumber);
            threads[i]=thread;

        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }
        System.out.println(TestThreadNewNumber.map.size());


    }

    @Override
    public /*synchronized*/ void run() {
        number--;

        map.put(number,number);
        System.out.println("the number is "+number);
    }
}
