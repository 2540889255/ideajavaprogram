package com.aynu.test.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author admin
 */
public class Counter {

    private final AtomicInteger atomicInteger=new AtomicInteger();

    public void increase(){
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }
    public static void main(String[] args) {
        Counter counter=new Counter();
        counter.increase();
    }
}

class CompactCounter{
    private volatile long counter;

    private static final AtomicLongFieldUpdater<CompactCounter>  updater=AtomicLongFieldUpdater.newUpdater(CompactCounter.class,"counter");
    public void increase(){
        updater.incrementAndGet(this);
        long l = updater.incrementAndGet(this);
        System.out.println(l);
    }

    public static void main(String[] args) {
        CompactCounter counter=new CompactCounter();
        counter.increase();


        /*AtomicStampedReference atomicStampedReference=new AtomicStampedReference();*/
    }
}