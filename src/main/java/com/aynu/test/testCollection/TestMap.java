package com.aynu.test.testCollection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * 使用案例测试Map的结构
 * @author admin
 */
public class TestMap {


    public static void main(String[] args) {
        /*HashMap hashMap=new HashMap();
        Collections.synchronizedMap(hashMap);*/

        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,1);
        concurrentHashMap.get(1);
        CopyOnWriteArrayList arrayList=new CopyOnWriteArrayList();



    }
}
