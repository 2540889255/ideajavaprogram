package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode50 {


    public static void main(String[] args) {
        /*int[] nums={-1,-1,-1,-1,-1,-1};*/
        int[] nums={1,7,3,6,5,6};
        int i = pivotIndex(nums);
        System.out.println(i);
    }

    public static int pivotIndex(int[] nums) {

        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int left=0;
        int right=0;
        for (int i = 0; i < nums.length; i++) {
            if ((sum-nums[i])%2==1){
                left+=nums[i];
                continue;
                /*right=(sum-nums[i])/2+1;*/
            }
            if ((sum-nums[i])%2==-1){
                left+=nums[i];
                continue;
                /*right=(sum-nums[i])/2+1;*/
            }
            if ((sum-nums[i])%2==0){
                right=(sum-nums[i])/2;
            }
            if (left==right){
                return i;
            }
            left+=nums[i];
        }

        return -1;
    }

    @Test
    public void show(){
        System.out.println(-19%2);
    }
}
