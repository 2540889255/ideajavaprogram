package com.aynu.test.testthread;

/**
 * @Auther: LC
 * @Date : 2021 02 10 15:37
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class ThreadJoin implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("i am vip"+i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin=new ThreadJoin();

        Thread thread=new Thread(threadJoin);

        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i==480){
                thread.join();
            }

            System.out.println("main is runing"+i);
        }

    }
}
