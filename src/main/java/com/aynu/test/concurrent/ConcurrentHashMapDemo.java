package com.aynu.test.concurrent;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: LC
 * @Date : 2021 02 20 14:16
 * @Description : com.aynu.test.concurrent
 * @Version 1.0
 * 对于并发容器hashMap进行操作
 */
public class ConcurrentHashMapDemo {


    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,1);
    }

    @Test
    public void test(){
        HashMap hashMap=new HashMap();
        hashMap.put(1,1);
    }
}
