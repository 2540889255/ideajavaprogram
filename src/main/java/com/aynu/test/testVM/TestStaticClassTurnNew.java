package com.aynu.test.testVM;

import java.util.*;

public class TestStaticClassTurnNew {

    public static int a=1;

    public static Integer b=2;

    public static void main(String[] args) {
        System.out.println(100/0.0);
        /*TestStaticClassTurnNew testStaticClassTurnNew=null;

        *//*System.out.println(testStaticClassTurnNew.a);
        System.out.println(testStaticClassTurnNew.b);*//*

        System.out.println(TestStaticClassTurnNew.a);

        float a=1.0f-0.9f;
        float b=0.9f-0.8f;
        Float c=0.9f-0.8f;
        Float d=0.9f-0.8f;


        System.out.println(a);
        System.out.println(b);
        System.out.println(a=b);
        if (a-b<=0){
            System.out.println(true);
        }

        System.out.println(c);
        System.out.println(d);
        System.out.println(c.equals(d)
        );

        Map map=new HashMap();
        map.put("1",1);
        map.put("2",2);
        Set set = map.keySet();
        set.add(new Object());
        Object[] objects = set.toArray();

        Iterator iterator = set.iterator();*/
    }
}
