package com.aynu.test.testthread;

public class Do {
    public static void main(String[] args ) {
        /*MyThread thread=new MyThread();
        thread.start();
        thread.interrupt();
        System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted());
        System.out.println("thread是否存活："+thread.isAlive());*/
        test test=new test();

        test.start();
        test.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}