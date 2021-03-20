package com.aynu.test.test;

/**
 * @author admin
 */
public class Teacher extends Person{


    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.showName();


        Person[] persons=new Person[3];

        persons[0]=new Teacher();
        persons[1]=new Student();
        System.out.println(persons[0].say());

    }

    @Override
    public boolean say() {
        System.out.println("老师向你打招呼");
        return false;
    }
}
