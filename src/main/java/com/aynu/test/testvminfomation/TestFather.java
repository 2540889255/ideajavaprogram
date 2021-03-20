package com.aynu.test.testvminfomation;

public class TestFather {

    public static int a=1;

    static {
        c=3;
    }

    public static int c=1;



    public int b=1;

    public TestFather(){
        say();
    }

    public void say() {
        System.out.println("father a:"+a);
        System.out.println("father b:"+b);
    }


}
