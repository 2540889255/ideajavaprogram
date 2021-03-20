package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 05 14:51
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 */
public class Letcodesward14 {

    /*解题思路
    *
    *
    * */

    @Test
    public void test(){
        System.out.println(cuttingRope3(127));
    }
    public static int cuttingRope(int n) {
        int sum=1;
        if (n<=3){
            return n-1;
        }
        double a=n/3;
        double b=n%3;

        if (b==1){
            return ((int) Math.pow(3,a-1)*4)%1000000007;
        }
        if (b==2){
            return ((int) Math.pow(3,a)*2)%1000000007;
        }
        return  ((int)Math.pow(3,a))%1000000007;
    }


    /*中间有一段问题，思考后可以将取余操作往前一步，判断余数为4，5，6，来避免回退
    *
    * */
    public static int cuttingRope2(int n) {
        long sum=1;

        if (n<=3){
            return n-1;
        }
        while (n!=0){

            if (n/3!=0){
                sum*=3;
                sum=sum%1000000007;
                n=n-3;
            }else {
                if (n%3==2){
                    sum*=2;
                    sum=sum%1000000007;
                    n=0;
                }else {
                    sum=(sum/3)*4;//我的代码，想想这里可能有问题，比如当sum被%之后，可能被刚取完余数，
                    sum=sum%1000000007;
                    n=0;
                }

            }
        }
        return  (int) sum;
    }

    public int cuttingRope3(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            System.out.println(a);
            if(a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
            System.out.println(x);
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    /*使用看到的快速幂求余数
    * 针对于大的数字，x的n次方再求大的余数，等于x的2次方，的二分之n次方，再求大余数
    * 原理为
    *
    * */
    public int cuttingRope4(int n) {
        if (n<=3){
            return n-1;
        }
        long sum=1;

        int b= n%3;
        long x= 3;
        int p= 1000000007;
        for (int a = n / 3 - 1; a > 0 ; a /= 2) {
            System.out.println(a);
            if (a %2 == 1) sum =(sum * x)%p;
            x= (x * x ) % p;
            System.out.println(x);
        }
        if (b==0){
            return (int) (sum * 3 % p);
        }
        if (b==1){
            return (int) (sum * 4 % p);
        }
        return (int) (sum*6%p);
    }
}
