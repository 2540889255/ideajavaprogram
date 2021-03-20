package com.aynu.test.test;


import com.aynu.test.testreflect.Reflect;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 进行测试
 * 测试引用队列
 */
public class CleaningExample implements AutoCloseable {


    public static void main(String[] args) {
        String s="";
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        /*Reference.reachabilityFence(counter);*/
        System.gc();
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);

            if (ref != null) {
                // do something
                System.out.printf("对象到达了这");
            }
        } catch (InterruptedException e) {
            // Handle it
        }
    }

    @Override
    public void close() throws Exception {
        String s=new String();


    }
    @Test
    public void show(){

        short i=1;
        System.out.println(--i+0);
    }
}
