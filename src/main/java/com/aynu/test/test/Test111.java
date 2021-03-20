package com.aynu.test.test;


import org.junit.jupiter.api.Test;

/**
 * @author admin
 */
public class Test111 {


    public static void main(String[] args) {



    }

    public void show(){
        InnerClass innerClass=this.new InnerClass();
    }

    class InnerClass{
        int a=0;

    }

    @Test
    public void shows(){
        int a=50;
        /*int num=0;*/
        a++;
        /*a=a++;
        System.out.println(a);
        int b=1;*/
        /*num=a++*2;
        System.out.println(num);
        num=a*2;

        System.out.println(num);*/
    }
}
