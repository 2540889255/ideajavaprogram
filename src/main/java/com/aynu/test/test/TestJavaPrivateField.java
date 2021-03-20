package com.aynu.test.test;

/**
 * @author admin
 */
public class TestJavaPrivateField {

    private String name;

    public TestJavaPrivateField(String name){
        this.name=name;
    }
    public boolean equal(TestJavaPrivateField others){

        boolean equals = name.equals(others.name);
        return equals;
    }
    public static void main(String[] args) {

        TestJavaPrivateField testJavaPrivateField=new TestJavaPrivateField("小黑");
        TestJavaPrivateField testJavaPrivateFieldOther=new TestJavaPrivateField("小蓝");

        boolean equal = testJavaPrivateField.equal(testJavaPrivateFieldOther);
        System.out.println(equal);

        System.out.println(testJavaPrivateField.name);
    }
}
