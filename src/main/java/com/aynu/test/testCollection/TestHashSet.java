package com.aynu.test.testCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试hashset的作用，通过重写类hash和equal方法
 */
public class TestHashSet {


    public static void main(String[] args) {

        Man man=new Man();
        Man man1=new Man();

        Boolean equals = man.equals(man1);
        System.out.println(equals.toString());
        System.out.println("man hashcode is "+man.hashCode());
        System.out.println("man1 hashcode is "+man1.hashCode());


        HashSet set=new HashSet();

        set.add(man);
        set.add(man1);
        System.out.println(set.size());

    }


}
