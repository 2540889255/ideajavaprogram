package com.aynu.test.test;


import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 测试Integer 的自动拆箱装箱
 */
public class TestInteger {

    int  number=11;

    public static int num=22;

    public static void main(String[] args) {

        Field[] fields = TestInteger.class.getDeclaredFields();
        for (Field field : fields) {
              System.out.println(field.getName() + "---offSet:" + UNSAFE.objectFieldOffset(field));
        }
        /*int a=1;
        int b=1;

        Integer e=1;
        Integer f=1;

        Integer c=new Integer(1);
        Integer d=new Integer(1);
        System.out.println(a==b);
        System.out.println(c==a);
        System.out.println(d==a);
        System.out.println(c==d);
        System.out.println(a==e);
        System.out.println("---------------------");
        System.out.println(e==f);
        System.out.println(e==c);
        System.out.println(e==d);
        System.out.println(c==d);*/

    }

    @Test
    public void showIntergers(){
        boolean isOpen =1 < 2;

        assert isOpen;
        System.out.println("程序正常");

    }

    @Test
    public void shows(){

    }

    /**
     * 断言的第一个例子
     */
    @Test
    public  void useAssertExt2() {
        boolean isOk = 1 > 2;
        try {

            System.out.println("程序正常");
            assert isOk : "程序错误";
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }


        private final static Unsafe UNSAFE;
        // 只能通过反射获取Unsafe对象的实例
        static {
            try {
                UNSAFE = (Unsafe) Unsafe.class.getDeclaredField("theUnsafe").get(null);
            } catch (Exception e) {
                throw new Error();
            }
        }

    @Test
    public  void useAssertExt3() {
        HashMap hashMap=new HashMap();
        for (int i = 0; i < 18; i++) {
            if (i==12){

            }
            hashMap.put(i,i);
        }
    }


}
