package com.aynu.test.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 */
public class LatchSample {



    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(new FirstBatchWorker(countDownLatch));
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(new SecondBatchWorker(countDownLatch));
            thread.start();
        }

        while (countDownLatch.getCount()!=1){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("waiting for first done");
        countDownLatch.countDown();
    }



    private void log(String msg){

    }

}
class  FirstBatchWorker implements Runnable{
    private CountDownLatch countDownLatch;

    public FirstBatchWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("the program is going ");
        countDownLatch.countDown();
    }
}

class SecondBatchWorker implements Runnable{
    private CountDownLatch countDownLatch;

    public SecondBatchWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the program is going again");
    }
}