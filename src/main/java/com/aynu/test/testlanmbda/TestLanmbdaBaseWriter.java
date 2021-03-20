package com.aynu.test.testlanmbda;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author admin
 */
public class TestLanmbdaBaseWriter {


    public static void main(String[] args) {
        String[] string={"1","2","3"};
        Arrays.sort(string,(x,y) ->{
            System.out.println();
            return 1;
        });
    }


    @Test
    public void show(){

        System.out.println(100/0.0);
        System.out.println(2.0-1.1);
        System.out.println(3.00-1-1.12);
        System.out.println(1/10);
        System.out.println(0.9);
    }


    @Test
    public void showString(){
        String hello="hi!";
        System.out.println(hello.length());
        String hello1 = "hi𝕆";
        System.out.println(hello1.length());

        /*实际码点的数量*/
        int i = hello.codePointCount(0, hello.length());
        int i1 = hello1.codePointCount(0, hello1.length());
        System.out.println("this is hello 码点 length"+i);
        System.out.println("this is hello1 码点 length"+i1);

        int length=hello1.length();

        for (int j = 0; j < length; j++) {
            System.out.println("当前"+j+"的代码单元为"+ Integer.toHexString(hello1.charAt(j)));
        }

        for (int j = 0; j < i1; j++) {
            System.out.println("当前"+j+"码点为"+hello1.codePointAt(j));
        }
    }
}
