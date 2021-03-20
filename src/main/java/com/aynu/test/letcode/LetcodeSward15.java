package com.aynu.test.letcode;

import java.util.HashMap;

/**
 * @Auther: LC
 * @Date : 2021 03 05 17:46
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class LetcodeSward15 {


    public static void main(String[] args) {
        System.out.println(hammingWeight(1101L));
    }


    public static int hammingWeight(Long n) {
        long number=0;
        while (n!=0){
            number+=n&1;
            n>>>=1;
        }
        return (int) number;
    }
}
