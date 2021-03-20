package com.aynu.test.test;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 10 20:03
 * @Description : com.aynu.test.test
 * @Version 1.0
 */
public class SynchronizedDemo {

    public synchronized void method1() {
        // code

    }

    // 关键字在代码块上，锁为括号里面的对象
    public void method2() {
        Object o = new Object();
        synchronized (o) {
            // code
        }
    }

    public static synchronized void show(){
        //System.out.println("这是类的静态方法");
    }
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo=new SynchronizedDemo();
    }
}
