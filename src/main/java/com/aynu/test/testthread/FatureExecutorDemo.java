package com.aynu.test.testthread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: LC
 * @Date : 2021 01 29 16:52
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class FatureExecutorDemo {


    public static void main(String[] args) throws InterruptedException {
        Callable callable=() ->{
            Random random=new Random();
            System.out.println("the runable is running ");
            Thread.sleep(1000);
            return random.nextInt(100);
        };

        FutureTask task=new FutureTask(callable);
        Thread thread=new Thread(task);
        System.out.println("the main thread is going");
        try {
            thread.start();
            Object o = task.get();
            System.out.println(((Integer) o).intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("the main thread is done");

    }
}
