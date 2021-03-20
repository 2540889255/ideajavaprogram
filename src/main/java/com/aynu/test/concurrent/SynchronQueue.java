package com.aynu.test.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 17 16:09
 * @Description : com.aynu.test.concurrent
 * @Version 1.0
 */
public class SynchronQueue {


    public static void main(String[] args) {
        /*
        * 新建同步队列，
        * */
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue();

        Thread thread=new Thread(
                () -> {
                    try {
                        synchronousQueue.offer(1);
                        System.out.println("同步容器添加了1");
                        synchronousQueue.offer(2);
                        System.out.println("同步容器添加了2");
                        synchronousQueue.offer(3);
                        System.out.println("同步容器添加了3");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        );
        /*Thread thread=new Thread(
                () -> {
                    try {
                        synchronousQueue.put(1);
                        System.out.println("同步容器添加了1");
                        synchronousQueue.offer(2);
                        System.out.println("同步容器添加了2");
                        synchronousQueue.put(3);
                        System.out.println("同步容器添加了3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
        );*/


        Thread thread1=new Thread(() ->{
            try {
                Thread.sleep(1000);
                System.out.println(synchronousQueue.poll());
                System.out.println(synchronousQueue.poll());
                System.out.println(synchronousQueue.poll());
                /*Object take = synchronousQueue.poll();
                System.out.println("1thread take "+(Integer)take);
                TimeUnit.SECONDS.sleep(2);
                Object take1 = synchronousQueue.poll();
                System.out.println("2thread take "+(Integer)take1);
                TimeUnit.SECONDS.sleep(2);
                Object take2 = synchronousQueue.poll();
                System.out.println("3thread take "+(Integer)take2);
                TimeUnit.SECONDS.sleep(2);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();
    }



}
