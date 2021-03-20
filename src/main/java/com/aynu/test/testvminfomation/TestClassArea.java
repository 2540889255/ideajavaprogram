package com.aynu.test.testvminfomation;

public class TestClassArea {

    private  static  ObjectHoder object1;

    private ObjectHoder object2;

    void  foo(){
        ObjectHoder object3= new ObjectHoder();
        System.out.println("1");
    }

    public static class ObjectHoder{}
    public static void main(String[] args) {
        TestClassArea testClassArea=new TestClassArea();
        testClassArea.foo();
    }
}
