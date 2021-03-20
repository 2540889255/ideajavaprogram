package com.aynu.test.test;

/**
 * @author admin
 */
public class Student extends Person {


    @Override
    public boolean say() {
        System.out.println("学生向你打招呼");
        return false;
    }
}
