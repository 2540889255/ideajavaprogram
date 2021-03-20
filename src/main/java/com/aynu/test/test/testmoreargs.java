package com.aynu.test.test;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class testmoreargs {

    int b=2;

    public  void  testmore(int... number){
        int length =number.length;
        for (int i=0;i<length;i++){
            System.out.println(number[i]);

        }
        //System.out.println(b);
    }

    public  void  testeverything(Object... objects){
        System.out.println("这是Object的输出");
        System.out.println(objects.length);
    }
    public  static void  test(){
        //System.out.println(b);
    }

    public static void main(String[] args) {
        /*testmoreargs testmoreargs=new testmoreargs();
        testmoreargs.testmore(1,2,3,4,5,6);
        String a="123456";
        testmoreargs.testeverything(a,2,34,6);*/




        int x;

        for (int i=1;i<100000;i++){
            if ((i+5)%9==0){
                if ((i+6)%10==0){
                    if ((i+7)%11==0){
                        if ((i+8)%12==0){
                            System.out.println(i);
                        }
                    }
                }
            }
        }

    }
    @Test
    public void testGC(){
        List list=new ArrayList();
        for (int i = 0; i <10 ; i++) {
            list.add(new father());
        }
        //-Xlog:gc
        //-Xlog:gc*
        System.out.println(1);

        System.gc();
    }
}
