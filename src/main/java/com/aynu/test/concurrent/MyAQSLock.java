package com.aynu.test.concurrent;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyAQSLock implements Lock, Serializable {

    private Syn syn=new Syn();


    private static class Syn extends AbstractQueuedSynchronizer{
        protected Syn() {
            super();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            if (isHeldExclusively()){
                if (this.compareAndSetState(0,1)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            };
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg==1;
            if (getState()==0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
    }



    @Override
    public void lock() {
        syn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return this.syn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        this.syn.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {
        MyAQSLock myAQSLock=new MyAQSLock();
        myAQSLock.newCondition();

        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new MyAqsConsumer());
            thread.start();
        }

    }
}

class MyAqsConsumer implements Runnable{

    MyAQSLock myAQSLock;
    @Override
    public void run() {

        myAQSLock.tryLock();


    }
}