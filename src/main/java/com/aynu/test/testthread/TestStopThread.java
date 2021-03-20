package com.aynu.test.testthread;

import com.aynu.test.concurrent.TestThread;

/**
 * @Auther: LC
 * @Date : 2021 02 10 11:25
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class TestStopThread implements Runnable{


    volatile boolean  stop=false;
    @Override
    public void run() {

        while (!stop){
            System.out.println("我是子线程我正在运行"+Thread.currentThread());
        }

        System.out.println(Thread.currentThread()+"已经收到了消息并结束了自己");
    }

    public void stop(){
        stop=true;
    }

    public static void main(String[] args) throws InterruptedException {
        TestStopThread thread=new TestStopThread();
        //另一个线程，和第一个线程一样都传入了相同的对象，测试第二个线程改变某个具体的值，第一个线程是否会进行改变


        for (int i = 0; i < 20; i++) {

            Thread threads=new Thread(thread,""+i);
            threads.start();
        }

        Thread.sleep(1000);


        for (int i = 0; i < 100; i++) {
            System.out.println("main方法正在运行"+i);
            if (i==50){

                thread.stop();
            }


        }
    }
}
