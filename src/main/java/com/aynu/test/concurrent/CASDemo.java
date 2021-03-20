package com.aynu.test.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: LC
 * @Date : 2021 02 19 15:57
 * @Description : com.aynu.test.concurrent
 * @Version 1.0
 */
public class CASDemo {


    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(2020);

        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }

    @Test
    public void test(){
        /*测试atomicsamplereference*/

        AtomicStampedReference<Integer> stampedReference=new AtomicStampedReference<>(1,1);

        int stamp = stampedReference.getStamp();
        System.out.println(stampedReference.compareAndSet(1, 2021, stamp, stamp + 1));

        System.out.println(stampedReference.getStamp());

    }

    /*测试integercache缓存问题*/
    @Test
    public void test3(){

        Integer x = 1;
        Integer y = 1;
        System.out.println(String.format("1:%s",x == y));// 1
        x = 127;
        y = 127;
        System.out.println(String.format("2:%s",x == y));// 2
        x = 128;
        y = 128;
        System.out.println(String.format("3:%s",x == y));// 3
        x = new Integer(1);
        y = new Integer(1);
        System.out.println(String.format("4:%s",x == y));// 4
        x = Integer.parseInt("127");
        y = Integer.parseInt("127");
        System.out.println(String.format("5:%s",x == y));// 5
        x = Integer.parseInt("128");
        y = Integer.parseInt("128");
        System.out.println(String.format("6:%s",x == y));// 6
        x = new Integer(1);
        System.out.println(String.format("7:%s",x == y));// 7
        x = new Integer(128);
        System.out.println(String.format("8:%s",x == y));// 8
    }

    @Test
    public void test4() {

        Integer x = 1;
        Integer y = 1;
        System.out.println(String.format("1:%s", x == y));// 1
        x = 127;
        y = 126;
        System.out.println(String.format("1:%s", x == y));
    }


    @Test
    public void test5(){

        /*int a =1;
        int b =1;
        System.out.println(a==b);
        a=128;
        b=128;
        System.out.println(a==b);

        Integer c=null;
        int d=1;*/
        String e=null;
        if ("1".equals(e)){
            System.out.println(1);
        }

        if (e.equals("1")){
            System.out.println(1);
        }
    }
}
