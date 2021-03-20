package com.aynu.test.testthread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * increment 增量
 */
public class AtomicCounter {

    AtomicInteger a=new AtomicInteger(0);

    public  void increment(){
        a.incrementAndGet();
    }

    public void decrement(){
        a.decrementAndGet();
    }

    public Integer getvalue(){
        return a.get();
    }


    public static void main(String[] args) {
        AtomicCounter atomicCounter=new AtomicCounter();
        atomicCounter.increment();
        System.out.println(atomicCounter.getvalue());
        atomicCounter.decrement();
        System.out.println(atomicCounter.getvalue());
    }
}
