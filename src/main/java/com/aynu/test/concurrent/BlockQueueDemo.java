package com.aynu.test.concurrent;

import com.aynu.test.teststream.TestStreamApi;
import org.apache.ignite.internal.util.typedef.internal.A;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: LC
 * @Date : 2021 02 17 10:38
 * @Description : com.aynu.test.concurrent
 * @Version 1.0
 */
public class BlockQueueDemo {


    public static void main(String[] args) {

    }


    /*测试阻塞队列
    抛出异常
       * */
    @Test
    public void test() throws InterruptedException {

        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3);

        System.out.println(arrayBlockingQueue.add(1));
        System.out.println(arrayBlockingQueue.add(2));
        System.out.println(arrayBlockingQueue.add(3));





    }

    /*测试阻塞队列
    不抛出异常
       * */
    @Test
    public void test2() throws InterruptedException {
        //创建一个阻塞队列
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.offer(1));
        System.out.println(arrayBlockingQueue.offer(2));
        System.out.println(arrayBlockingQueue.offer(3));
        System.out.println(arrayBlockingQueue.offer(4));//offer超出之后返回false不报错

        System.out.println("--------------------------");
        /*展示头部元素*/
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.peek());
        System.out.println("--------------------------");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());//poll，阻塞队列为空不抛出异常，返回值为空

    }


    /*堵塞直到有对象*/
    @Test
    public void test3() throws InterruptedException {


        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3);

        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        arrayBlockingQueue.put(4);

    }

}
