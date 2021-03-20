package com.aynu.test.test;

public class NewTest {

    public static void main(String[] args) {
        TestJavaPrivateField testJavaPrivateField=new TestJavaPrivateField("小黑");
        TestJavaPrivateField testJavaPrivateFieldOther=new TestJavaPrivateField("小蓝");

        boolean equal = testJavaPrivateField.equal(testJavaPrivateFieldOther);
        System.out.println(equal);

/*
        System.out.println(testJavaPrivateField.name);
*/
    }
}
