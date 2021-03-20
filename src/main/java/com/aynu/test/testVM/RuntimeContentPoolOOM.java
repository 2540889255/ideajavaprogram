package com.aynu.test.testVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试常量池导致的内存溢出异常
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class RuntimeContentPoolOOM {


    public static void main(String[] args) {

        /*List<String> list=new ArrayList<>();
        short i=0;
        while (true){
            list.add(String.valueOf(i++).trim());
        }*/
        String string=new StringBuilder("计算机").append("软件").toString();
        System.out.println(string.intern().equals(string));
        System.out.println(string.intern()==string);


        String string2=new StringBuilder("ja").append("va").toString();
        System.out.println(string2.intern().equals(string2));
        System.out.println(string2.intern()==string2);


    }
}
