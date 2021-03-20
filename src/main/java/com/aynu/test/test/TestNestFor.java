package com.aynu.test.test;


/**
 * 测试双层for循环,
 * 测试计算机执行指令分支预测功能
 */
public class TestNestFor {


    public static void main(String[] args) {


                long start = System.currentTimeMillis();
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <1000; j ++) {
                        for (int k = 0; k < 10000; k++) {
                        }
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("Time spent is " + (end - start));

                start = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                    for (int j = 0; j <1000; j ++) {
                        for (int k = 0; k < 100; k++) {
                        }
                    }
                }
                end = System.currentTimeMillis();
                System.out.println("Time spent is " + (end - start) + "ms");
    }


}

