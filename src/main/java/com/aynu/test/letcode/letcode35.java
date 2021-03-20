package com.aynu.test.letcode;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode35 {

    public static void main(String[] args) {
        int [] prices={3,3,5,0,0,3,1,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static int maxProfit2(int[] prices) {
        int sum=0;

        int max=0;
        int min=0;
        sum=max-min;
        for (int i = prices.length-1; i >=0 ; i--) {
            if (prices[i]>max){
                max=prices[i];
                min=max;
            }
            if (prices[i]<min){
                min=prices[i];
                sum=sum>max-min?sum:max-min;
            }
        }

        return sum;
    }

    public static int maxProfit1(int[] prices) {
        int max=prices[0];

        int min=prices[1];

        int position=0;
        int money=max-min>0?max-min:0;
        for (int i = 3; i < prices.length-1; i++) {
            if (prices[i]<min){
                position=i;
                min=prices[i];
                money=money+min-prices[i]-max+prices[i]>0?money+min-prices[i]:max-prices[i];            }
            if (prices[i]>max){
                max=prices[i];
            }

        }
        return money;

    }
}
