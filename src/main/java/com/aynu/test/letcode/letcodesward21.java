package com.aynu.test.letcode;

import com.aynu.test.Until.LuchenArraysUntil;
import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 07 14:29
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class letcodesward21 {

    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {

        int length=nums.length;

        int right=length-1;

        for (int i = 0; i < length; i++) {
            if ((nums[i]%2==0||nums[i]==0)&&right>i){
                while (nums[right]%2==0&&right>i){
                    System.out.println(right);
                    right--;
                }
                swap(nums,i,right);
            }
        }
        return nums;
    }

    public void swap (int[] nums,int left,int right){
        int template=nums[left];
        nums[left]=nums[right];
        nums[right]=template;
    }

    /**
     *
     **/
    @Test
    public void test() {

        //LuchenArraysUntil.creatArrays(5,0,20);
        int[] nums = {1,2,5};
        int[] exchange = exchange24(nums);
        LuchenArraysUntil.printArrays(exchange);
    }


    /*
    方法一
    * 首尾指针不断移动
    * */
    public int[] exchange2(int[] nums) {
        int length=nums.length;

        int left=0;

        int right=length-1;

        while (left<right){
            if (nums[left]%2==0 || nums[left]==0){

                while (right>left&&nums[right]%2==0){
                    right--;
                }
                swap(nums,left,right);
            }
            left++;
        }
        return nums;
    }

    /*方法二
    * 首部两个快慢指针不断往前
    *
    * 以后判断是否是奇数和偶数使用&1，但是对负数不准如此使用
    * */
    public int[] exchange23(int[] nums) {

        int left=0;
        int right=1;
        int length=nums.length;
        while (right<length){

            while ((nums[left]&1)!=0) {
                left++;
            }
            while ((nums[right]&1)!=1&&right<length-1){
                right++;
            }
            if (right>=length){
                return nums;
            }
            swap(nums,left,right);
            left++;
            right++;
        }
        return nums;
    }

    /*简化版本*/
    public int[] exchange24(int[] nums) {

        int left=0;

        int right=1;

        int length=nums.length-1;

        while (right<=length){

            if ((nums[right]&1)==1){
                while (left<right&&(nums[left]&1)!=0){
                    left++;
                }
                swap(nums,left,right);
            }
            right++;
        }
        return nums;
    }
}
