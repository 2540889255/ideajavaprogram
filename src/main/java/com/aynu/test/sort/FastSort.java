package com.aynu.test.sort;

import com.aynu.test.Until.LuchenArraysUntil;
import org.junit.jupiter.api.Test;

import java.nio.charset.MalformedInputException;

/**
 * @Auther: LC
 * @Date : 2021 02 26 23:15
 * @Description : com.aynu.test.sort
 * @Version 1.0
 * 快速排序
 */

public class FastSort {


    public static void main(String[] args) {
        LuchenArraysUntil.creatArrays(6,0,10);
    }


    @Test
    public void test(){
        int[] nums = {4,6};

        int length=nums.length;

        //int fast = fast(nums, 0, nums.length-1);
        sort(nums,0,nums.length-1);
        //System.out.println(fast);
        LuchenArraysUntil.printArrays(nums);

    }


    public static void sort(int[] nums,int left,int right){

        if (left>=right){
            return;
        }

        int middle = fast(nums, left, right);
        sort(nums,left, middle);
        sort(nums,middle+1, right);
        //sort(nums,);
    }

    public static int fast(int[] nums,int leftBound,int rightBound){
        int middle=nums[rightBound];

        int left=leftBound;

        int right=rightBound-1;

        while (left<right){

            while (left<right&&nums[left]<=middle){
                left++;
            }
            while (left<right&&nums[right]>middle){
                right--;
            }
            if (left<right) {
                swep(nums,left,right);
            }

        }
        //在循环结束之后，将临界点和对比的值进行交换，产生界限
        if (middle<nums[left]){
            swep(nums,left,rightBound);

        }



        return left;
    }

    public static void swep(int[] nums,int left,int right){
        int template=nums[left];

        nums[left]=nums[right];

        nums[right]=template;
    }



    /*有问题，当把大的值换过来，然后后面还有小的将产生大的在前的错误，解决方案，不加position再加一次循环，增大了消耗，
        public static int fast(int[] nums,int left,int right){
        int middle=nums[right];

        int position=left;

        int maxlength=right;

        while (position<maxlength){
            if (nums[position]>middle){
                swep(nums,position,maxlength);
                maxlength--;
            }

            position++;
            System.out.println("我循环了一次");
        }
        System.out.println(position);
        return position-1;
    }*/
}
