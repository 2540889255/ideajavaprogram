package com.aynu.test.concurrent;

import java.util.concurrent.Semaphore;

public class UsualSemaphoreSample {



    public static void main(String[] args) {
        //完成一个释放一个
        /*System.out.println("the program is going");
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i < 10; i++) {

            Thread thread=new Thread(new SemaphoreSampleWorker(semaphore));
            thread.start();
        }*/
        //每隔五个都完成，然后释放
        System.out.println("the grogram is going");
        Semaphore semaphore=new Semaphore(0);

        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new SemaphoreSampleWorker(semaphore));
            thread.start();
        }
        System.out.println("the 5 size thread is doing something");
        semaphore.release(5);
        while (semaphore.availablePermits()!=0){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the 5 size thread is doing something again");
        semaphore.release(5);
        
    }

    static class SemaphoreSampleWorker implements Runnable{

        private String name;

        private Semaphore semaphore;

        public SemaphoreSampleWorker(Semaphore semaphore){
            this.semaphore=semaphore;
        }
        @Override
        public void run() {

/*
            log("the thread need a sign");
*/
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                semaphore.acquire();
                log("the thread is working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

                log("the working is done");
            }
        }


        void log(String msg){
            if (name==null){
                System.out.println(Thread.currentThread().getName()+" "+msg);
            }
        }
    }

}
