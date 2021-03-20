package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 02 28 11:28
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 */
public class LetcodeSward10 {

    public static   int sum=0;
    public int numWays(int n) throws InterruptedException {
        return numWay2(n+1);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println(numWay2(100));
    }




    public  static int numWay2(int n) throws InterruptedException {
        if (n==1){
            return 1;
        }
        if (n==0){
            return 1;
        }
        sum=(numWay2(n-1)+numWay2(n-2));

        System.out.println("sum is "+sum);
/*
        Thread.sleep(1000);
*/
        return sum%1000000007;
    }

}
