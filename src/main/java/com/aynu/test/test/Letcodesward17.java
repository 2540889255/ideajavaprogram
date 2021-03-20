package com.aynu.test.test;

import com.aynu.test.Until.LuchenArraysUntil;
import org.apache.commons.math3.analysis.function.Pow;

/**
 * @Auther: LC
 * @Date : 2021 03 06 16:49
 * @Description : com.aynu.test.test
 * @Version 1.0
 *
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Letcodesward17 {


    public static void main(String[] args) {

        int[] ints = printNumbers(1);
        LuchenArraysUntil.printArrays(ints);
    }
    public static int[] printNumbers(int n) {


        double pow = Math.pow(10, n)-1;
        int [] numbers=new int[(int) pow];
        System.out.println(pow);
        for (int i = 0; i < pow; i++) {
            numbers[i]=i+1;
        }

        return numbers;
    }

    /*需要考虑大数的情况*/
    public static int[] printNumber2(int n){
        double pow = Math.pow(10, n)-1;
        String [] numbers=new String[(int) pow];

        String [] number={"0","1","2","3","4","5","6","7","8","9"};

        for (double i = pow; i >0 ; i--) {

        }
        return null;
    }


}
