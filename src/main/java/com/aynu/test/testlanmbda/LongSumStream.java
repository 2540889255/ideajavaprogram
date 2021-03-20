package com.aynu.test.testlanmbda;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * @Auther: LC
 * @Date : 2021 02 18 21:33
 * @Description : com.aynu.test.testlanmbda
 * @Version 1.0
 * 使用流对于数据进行计算
 */
public class LongSumStream {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0, 100000000L).parallel().reduce(0, Long::sum);
        System.out.println(reduce);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


    @Test
    public void test(){
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 0L; i <=100000000L; i++) {
            sum=sum+i;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
