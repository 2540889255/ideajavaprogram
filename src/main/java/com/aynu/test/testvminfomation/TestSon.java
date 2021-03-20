package com.aynu.test.testvminfomation;

public class TestSon extends TestFather {

    public static int a=2;

    public int b=2;

    public static int e=c;

    public TestSon(){
        say();
    }

    public void  say(){
        System.out.println("son a:"+a);
        System.out.println("son b:"+b);
    }

    public static void main(String[] args) {

        TestFather father=new TestSon();

        father.say();
        System.out.println(father.b);
        //father.
        /*System.out.println(father.a);
        System.out.println(father.b);*/
        System.out.println("--------");
        System.out.println(TestSon.e);

    }
}
