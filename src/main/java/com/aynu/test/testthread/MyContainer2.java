package com.aynu.test.testthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 测试ReentrainLock里面的condition类型
 * @author admin
 */
public class MyContainer2 {

    ReentrantLock lock=new ReentrantLock();

    Condition provide=lock.newCondition();

    Condition consumer=lock.newCondition();

    public void get(){

        try {
            lock.lock();
            for (int i = 0; i < 2; i++) {

            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {

        MyContainer2 myContainer2=new MyContainer2();
        myContainer2.get();


    }
}
