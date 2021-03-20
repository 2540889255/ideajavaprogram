package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 05 20:18
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 */
public class Letcodesward16 {


    public static void main(String[] args) {
        //System.out.println(Math.pow(3, 156));
        System.out.println(myPow2(2, 15));
    }

    public static double myPow(double x, int n) {
        if (x==0){
            return 0;
        }
        if (x==1||x==-1){
            return 1;
        }
        long s=(long)n;
        if (s<0){
            s*=-1;
        }
        if (n>0){
            double y=x;
            for (int i = 1; i < s; i++) {
                x*=y;
            }
            return x;
        }
        if (n==0){
            return 1;
        }
        if (n<0){
            double y=x;
            for (int i = 1; i < s; i++) {
                x*=y;
            }
            System.out.println(x);
            return 1/x;
        }
        return 0;

    }

    public static double myPow2(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //b是倍数
            if((b & 1) == 1) res *= x;

            x *= x;
            b >>= 1;
            System.out.println("x="+x);
            System.out.println("res="+res);
        }
        return res;
    }

    /*现在有两种方式
    * 一种为使用二进制方法，将头部的平方变为二进制数字，然后，再把他们约分为 x(位数*2) x(位数*4) 以此类推
    * 第二种为： 将外面的数字不断变小，里面数字不断变大
    * */

    /*第一种方法*/
    public static double myPow3(double x, int n){
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        int  s= 1 ;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b>0){

            if ((b&1)==1){
                res *= x ;
            }else {

            }
            b >>= 1;
            x=x*x;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println("最终结果为"+myPow5(2, 9));
    }

    /*第二种*/
    public static double myPow5(double x,int n){

        long b= n ;

        double res= 1 ;
        if (x==0){
            return 0;
        }


        if (b<0){

            x = 1 / x;

            b = -b;
        }

        if (b>0){
            double d=x;
            for (long i = b; i > 0 ; i /= 2) {

                if ( i % 2 == 1) {
                    res *= x;
                };

                x = x*x;

                System.out.println("x="+x+"res="+res);
            }
            return res;
        }
        return res;
    }
}
