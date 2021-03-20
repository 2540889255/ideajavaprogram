package com.aynu.test.testthread;

import sun.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

/**
 * @author admin
 */
public class TestCAS {

    private volatile int state=0;

    private final static Unsafe unsafe=UnsafeInstance.reflectGetUnsafe();

    private Thread localThread;
    private final static long offset;
    static {
        try {
            offset = unsafe.objectFieldOffset(TestCAS.class.getDeclaredField("state"));
        }catch (Exception e){
            throw new Error(e);
        }
    }

    public int getState(){
        return this.state;
    }
    /**
     * 测试较少库存
     */
    public String descStockNoLock(){

        for (;;){
            int state=getState();

            if (state==0){
                if (compareAndSwapState(0,1)){
                    localThread=Thread.currentThread();
                    break;
                }

            }
            LockSupport.park();
        }
        return null;
    }

    public  boolean compareAndSwapState(int expect,int update){
        return unsafe.compareAndSwapInt(this,offset,expect,update);
    }
}
