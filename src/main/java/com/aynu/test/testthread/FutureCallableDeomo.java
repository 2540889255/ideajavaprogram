package com.aynu.test.testthread;

import java.util.concurrent.*;

/**
 * @Auther: LC
 * @Date : 2021 01 29 15:17
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class FutureCallableDeomo {


    public static void main(String[] args) {

        Callable callable=()->{

            System.out.println("分线程开始运行");

            Thread.sleep(1000*10);
            System.out.println("分线程运行结束");
            return "分线程结束";
        };


        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<String> submit = executorService.submit(callable);
        executorService.shutdown();
        System.out.println("主线程的工作正在进行中");
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程工作结束");
        try {
            String s = submit.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}
