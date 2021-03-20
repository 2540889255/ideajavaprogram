package com.aynu.test.testthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: LC
 * @Date : 2021 02 16 23:21
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class TestCallable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Show show=new Show();

        FutureTask futureTask=new FutureTask(show);

        Thread thread=new Thread(futureTask,"A");
        Thread thread2=new Thread(futureTask,"B");

        thread.start();
        thread2.start();

        Integer o = (Integer) futureTask.get();

        System.out.println(o);
    }
}


class Show implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
