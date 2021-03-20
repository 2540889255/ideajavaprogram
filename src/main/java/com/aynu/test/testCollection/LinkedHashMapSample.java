package com.aynu.test.testCollection;



import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author admin
 */
public class LinkedHashMapSample {

    int a = 1;


    public static void main(String[] args) {


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() >= 3;
            }
        };

        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "2");
        linkedHashMap.put("3", "3");
        linkedHashMap.forEach((k, v) -> {
            System.out.println("the key is " + k + " the value is " + v);
        });
        //模拟访问
        linkedHashMap.get("2");
        linkedHashMap.get("2");
        linkedHashMap.get("3");
        linkedHashMap.get("2");

        //添加新元素，测试linkhashmap删除策略
        linkedHashMap.put("4", "4");
        System.out.println("the oldest project is remove");
        linkedHashMap.forEach((k, v) -> {
            System.out.println("the key is " + k + "the value is " + v);
        });


    }


    @Test
    public void show() throws NoSuchFieldException, NoSuchMethodException {
        TreeMap treeMap = new TreeMap();
        Method[] compare = TreeMap.class.getDeclaredMethods();

        for (int i = 0; i < compare.length; i++) {
            System.out.println(compare[i]);
        }
    }

     static Object k1;
     static Object k2;
     static int compare(Object k1, Object k2) {
         Comparator<Object> comparator = null;
         return comparator==null ? ((Comparable)k1).compareTo((Object) k2)
                 : comparator.compare((Object) k1, (Object) k2);
     }

     @Test
    public void show2(){
         int compare = compare(k1, k2);
         System.out.println(compare);
     }

     @Test
    public void show3(){
         /*TreeMap treeMap=new TreeMap();
         treeMap.put("3","3");
         treeMap.put("1","1");
         treeMap.put("2","2");
         treeMap.forEach((x,y) -> {
             System.out.println("the" + x+" "+y);
         });*/

         HashMap hashMap=new HashMap();
         hashMap.put(1,1);
         int hash=643868214;
         int n=32;
         System.out.println((n - 1) & hash);

     }

     @Test
    public void show8(){
        Object o=new Object();

         System.out.println(o.hashCode());
     }

}