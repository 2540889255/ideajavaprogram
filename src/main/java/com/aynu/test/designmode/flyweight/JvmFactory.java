package com.aynu.test.designmode.flyweight;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @Auther: LC
 * @Date : 2021 03 15 9:35
 * @Description : com.aynu.test.designmode.flyweight
 * @Version 1.0
 * 享元模式的静态构造工厂
 */
public class JvmFactory {

    private static HashMap<String,Share> hashMap=new HashMap();

    /**
     * 创建heap公共类的静态工厂方法
     * @param name
     * @return
     */
    public static Share getHeapByName(String name){
        Heap heap = (Heap)hashMap.get(name);

        if (heap==null){
            heap=new Heap(name);
            hashMap.put("heap",heap);
        }
        return heap;
    }

    /**
     * 创建方法区的静态共享工厂
     * @param name
     * @return
     */
    public static Methed getMethodByName(String name){
        Methed methed = (Methed) hashMap.get(name);

        if (methed==null){
            methed=new Methed(name);
            hashMap.put("method",methed);
        }
        return methed;
    }



    public static void main(String[] args) {

        JvmFactory jvmFactory=new JvmFactory();


    }


    /**
     *
     **/
    @Test
    public void test() {

    }
}
