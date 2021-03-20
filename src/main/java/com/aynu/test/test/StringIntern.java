package com.aynu.test.test;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 06 16:09
 * @Description : com.aynu.test.test
 * @Version 1.0
 *
 * 测试String.intern()
 */
public class StringIntern {


    public static void main(String[] args) {

        String s=new StringBuilder("计算机").append("xue").toString();

        System.out.println(s==s.intern());

        //第二个还是false，因为java，字符串常量池已经不需要拷贝到方法区了。所以计算机是第一次创建，会加载到，常量池，加入进去了所以返回的是同一个对象，
        //第二个已经有了，所以是新建了一个，所以不是同一个对象
        String s1=new StringBuilder("ja").append("va").toString();

        System.out.println(s1==s1.intern());




    }

    @Test
    public void test(){
        String s="hello";
        String s1="hello";

        StringBuilder stringBuilder = new StringBuilder("hello");
        String s2 = stringBuilder.toString();
        System.out.println(1);
    }
}
