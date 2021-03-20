package com.aynu.test.sort;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 02 16 15:09
 * @Description : com.aynu.test.sort
 * @Version 1.0
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] nums={1,4,0,2,7};

        int min=nums[0];

        int minPosition=0;

        int length=nums.length;

        int template;
        for (int i = 0; i < length; i++) {

            min=nums[i];
            minPosition=i;
            for (int j = i+1; j < length; j++) {
                if (min>nums[j]){
                    min=nums[j];
                    minPosition=j;
                }
            }

            template=nums[i];
            nums[i]=nums[minPosition];
            nums[minPosition]=template;
            for (int s = 0; s < length; s++) {
                System.out.print(nums[s]);
            }
            System.out.println();
        }


    }

    /*选择排序*/
    @Test
    public void test(){
        int[] nums={1,7,3,6,5,6};

        int min=nums[0];

        int minPosition=0;

        int length=nums.length;

        int template;
        for (int i = 0; i < length; i++) {

            minPosition=i;
            for (int j = i+1; j < length; j++) {
                if (nums[minPosition]>nums[j]){
                    minPosition=j;
                }
            }

            if (minPosition!=i){
                template=nums[i];
                nums[i]=nums[minPosition];
                nums[minPosition]=template;
                for (int s = 0; s < length; s++) {
                    System.out.print(nums[s]);
                }
                System.out.println();
            }


        }

    }


    /*冒泡排序*/
    @Test
    public void test1(){
        int[] nums={7,4,5,6};

        int length=nums.length;

        int position=0;
        for (int i = 0; i < length; i++) {

            position=i;
            for (int j = i+1; j < length; j++) {
                if (nums[position]>nums[j]){
                    swap(nums,position,j);
                    position=j;
                }
            }

            for (int s = 0; s < length; s++) {
                System.out.print(nums[s]);
            }
            System.out.println();
        }

    }

    /*冒泡排序从后向前*/

    @Test
    public void test3(){

        int[] nums={7,4,5,6,1,5};

        int length=nums.length;

        for (int i = length-1; i >0 ; i--) {

            for (int j = 0; j < i; j++) {

                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
            print(nums,length);
        }


    }

    /*插入排序*/
    @Test
    public void test4(){
        int[] nums={7,4,5,6,1,5};

        int length=nums.length;

        for (int i = 1; i < length; i++) {

            if (nums[i]<nums[i-1]) {
                for (int j = i; j > 0; j--) {
                    if (nums[j]<nums[j-1]){
                        swap(nums,j,j-1);
                    }
                }
            }
            print(nums,length);
        }
    }


    public void swap(int [] nums,int x,int y){
        int template;

        template=nums[x];
        nums[x]=nums[y];
        nums[y]=template;
    }

    public void print(int[] nums,int length){
        for (int s = 0; s < length; s++) {
            System.out.print(nums[s]);
        }
        System.out.println();
    }
}
