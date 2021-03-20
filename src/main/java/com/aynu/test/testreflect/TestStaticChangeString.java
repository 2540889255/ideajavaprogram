package com.aynu.test.testreflect;


import java.lang.reflect.Field;

/**
 * 测试是否能修改finnal的值
 */
public class TestStaticChangeString {

    public static final int a=1;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final String a="abc";
        final String b="def";

        Field value = String.class.getDeclaredField("value");
        /*System.out.printf(value.getName());*/
        value.setAccessible(true);
        value.set(a,new char[]{'1','2','3'});
        System.out.printf(a);
        System.out.printf(a+b);
    }
}
