package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 03 04 17:14
 * @Description : com.aynu.test.exam
 * @Version 1.0
 * 多以笔试题
 */
public class DuoyiExam {

    public static void main(String[] args) {

        int a=0;
        int b=0;
        for (int i = 0; i < 5; i++) {
            if (++a>2||++b>2){
                a++;
            }
            System.out.println(a);
        }
        System.out.println(a);
        System.out.println(b);

    }
}
