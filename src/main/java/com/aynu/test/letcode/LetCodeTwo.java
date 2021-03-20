package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/comments/
 */
public class LetCodeTwo {

    @Test
    public  void test(){
        int [] price={};
        int sum=0;
        for (int i = price.length-1; i > 0; i--) {
            int add=price[i]-price[i-1];
            if (add>0){
                sum+=add;
            }

        }
        System.out.println(sum);
    }
}
