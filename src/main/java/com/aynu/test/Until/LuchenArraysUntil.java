package com.aynu.test.Until;

import java.util.Random;

/**
 * @Auther: LC
 * @Date : 2021 02 26 16:38
 * @Description : com.aynu.test.Until
 * @Version 1.0
 */
/*编写关于数组的工具类包*/
public class LuchenArraysUntil {



    public static int[] creatArrays(int length,int start,int end){

        int[] nums =new int[length];

        /*生成随机int值传入数组中*/
        Random random=new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] =random.nextInt(end);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                System.out.print("int[] nums = {");
            }
            if (i < nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print(nums[i]+"};");
            }
        }
        return nums;
    }

    public static void printArrays(int[] nums){


        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                System.out.print("int[] nums = {");
            }
            if (i < nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print(nums[i]+"};");
            }

        }
    }

    public static void printCharArrays(char[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                System.out.print("char[] nums = {");
            }
            if (i < nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print(nums[i]+"};");
            }

        }
    }

    public static void main(String[] args) {
        int[] ints = LuchenArraysUntil.creatArrays(5, 0, 20);
        LuchenArraysUntil.printArrays(ints);
    }

    public static void PrintArraysTwo(int[][] nums){

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}
