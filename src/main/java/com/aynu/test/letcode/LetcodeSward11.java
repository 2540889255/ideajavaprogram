package com.aynu.test.letcode;

/**
 * @Auther: LC
 * @Date : 2021 02 27 22:05
 * @Description : com.aynu.test.letcode
 * 剑指 Offer 10- I. 斐波那契数列
 * @Version 1.0
 */
public class LetcodeSward11 {


    public static void main(String[] args) {
        System.out.println(fib3(11));//933882264
    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static int fib2(int n) {
        if (n==1){
            return 1;
        }
        if (n==0){
            return 0;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fib3(int n) {

        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int sum=1;
        int yest=1;
        for (int i = 2; i < n; i++) {
            int last=sum;
            sum=(sum+yest)%1000000007;
            yest=last;
        }
        return sum;
    }
    /*public static int fib(int n) {
        int sum=0;
        return sum(n,sum);
    }
    public static int sum(int n,int sum){
        if (n==0){
            return 0;
        }
        return sum=n+sum(n-1,sum);
    }*/
}
