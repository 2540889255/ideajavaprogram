package com.aynu.test.testvminfomation;

public class TestVMinterface {

    interface Interface{
        int A=0;
    }

    interface Interface1 extends Interface{
        int A=0;
    }

    interface Interface2 extends Interface1{
        int A=0;
    }
    static  class Parent implements Interface1{
        public static int A=2;
    }
    static  class Son extends Parent implements Interface2{

        public static int A = 3;
    }

    public static void main(String[] args) {
        System.out.println(Interface1.A);
        System.out.println(Interface2.A);
        System.out.println(Son.A);
    }
}
