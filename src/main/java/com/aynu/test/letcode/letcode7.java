package com.aynu.test.letcode;


import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class letcode7 {

    public static void main(String[] args) {

        int [] nums ={0,1,0,3,12};
        int position0=0;
        int template=0;
        for (int i = 0; i < nums.length; i++) {

                if (nums[i]!=0){
                    template= nums[i];
                    nums[i]=0;
                    nums[position0]=template;
                    position0++;
                }

        }

        Arrays.stream(nums).forEach(System.out::print);


        //判断为零 有重复情况
        /*for (int i = 0; i < nums.length; i++) {
            if (i<nums.length-number){
                if (nums[i]==0){
                    int template= nums[i+1];
                    nums[i+1]=0;
                    nums[i]=template;
                    number++;
                }
            }

        }*/
    }
}
