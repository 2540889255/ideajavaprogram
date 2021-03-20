package com.aynu.test.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 18 18:13
 * @Description : com.aynu.test.concurrent
 * @Version 1.0
 * 创建线程池，使用threadPool
 */

public class ExecutorDemo {


    public static void main(String[] args) {
        /*创建自定义线程池*/
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                12,
                3,
                TimeUnit.DAYS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());//Abort,当队列满的时候，抛出异常

        System.out.println(1);
    }
}
