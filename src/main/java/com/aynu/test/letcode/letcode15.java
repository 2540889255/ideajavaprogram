package com.aynu.test.letcode;


import java.lang.reflect.Field;

/**
 *
 */
public class letcode15 {


    public static void main(String[] args) throws NoSuchFieldException {


        String a="123";

        Field string = String.class.getDeclaredField("string");
        string.setAccessible(true);

        /*String b="123";
        String f="123123";
        String c="123"+"123";

        System.out.println(f==c);
        System.out.println(f.equals(c));

        String d=a+b;
        String e="123"+new String("123");
        String g="123"+a;
        System.out.println(e==g);
        System.out.println(e.equals(g));*/

        /*System.out.println(f==c);
        System.out.println(f==e);
        System.out.println(d==e);
        System.out.println(e==g);*/

        /*Object o=new Object();
        Integer integer=new Integer(2132);
        boolean equals = integer.equals("2132");
        System.out.println(equals);*/

       /* Integer a1=1;

        Integer a2=1;


        Integer a3=10000;

        Integer a4=10000;

        System.out.println(a1==a2);
        System.out.println(a3==a4);
*/

        /*System.out.println(c.equals(d));
        System.out.println(c==d);
        System.out.println(c.equals(e));
        System.out.println(c==e);
        System.out.println(d.equals(e));
        System.out.println(d==e);*/

    }
}
