package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 *给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class LetCodeSix {

    @Test
    public void test(){
        int[] num1={1,2,3,4,5,6,7};
        int[] num2={2,3,5,7,8};
        int a=0;
        //int length=num1.length>num2.length ? num1.length:num2.length;
        //int [] num3=new int[length];
        for (int i = 0; i <num2.length ; i++) {
            for (int j = 0; j <num1.length ; j++) {
                if (num2[i]==num1[j]){
                    //num3[a]=num2[i];
                    num2[a]=num1[j];
                    a++;
                    break;
                }
            }
        }

        //这里测试一下是直接在那个原数组后面截取完 还是产生新的好  截取不了 数组不能置空
        int [] nums3=new int[a];
        for (int i = 0; i <a ; i++) {
            nums3[i]=num2[i];
            System.out.print(nums3[i]);
        }
    }
    @Test
    public void test2(){
        int[] nums1={1,2};
        int[] nums2={1,3};
        int [] num1=nums1.length>=nums2.length ? nums1: nums2;
        int [] num2=nums1.length<nums2.length ? nums1: nums2;
        int a=0;
        for (int i = 0; i <num2.length ; i++) {
            for (int j = 0; j <num1.length ; j++) {
                if (num2[i]==num1[j]){
                    //num3[a]=num1[i];
                    int b=num1[j];
                    num2[a]=b;
                    //num2[a]=num1[i];
                    num1[j]=-9;
                    a++;
                    break;
                }
            }
        }
        int [] nums3=new int[a];
        for (int i = 0; i <a ; i++) {
            nums3[i]=num2[i];
            System.out.print(nums3[i]);
        }


    }

    @Test
    public void test3(){
        int[] nums1={1,1,2};
        int[] nums2={1,1,3};
        int [] num1=nums1.length>=nums2.length ? nums1: nums2;
        int [] num2=nums1.length<nums2.length ? nums1: nums2;
        int a=0;
        for (int i = 0; i <num2.length ; i++) {
            for (int j = 0; j <num1.length ; j++) {
                if (num2[i]==num1[j]){
                    //num3[a]=num1[i];

                    num2[a]= num1[j];
                    //num2[a]=num1[i];
                    //num1[j]=-9;
                    a++;
                    break;
                }
            }
        }
        int [] nums3=new int[a];
        for (int i = 0; i <a ; i++) {
            nums3[i]=num2[i];
            System.out.print(nums3[i]);
        }
    }

    @Test
    public void test4(){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int [] num1=nums1.length>=nums2.length ? nums1: nums2;
        int [] num2=nums1.length<nums2.length ? nums1: nums2;
        //确保num2是短的
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for (int n:num1
             ) {
            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
        }
        int k=0;



        for (int m:num2
             ) {
            Integer integer = hashMap.getOrDefault(m,0);
            if (integer!=0){
                num1[k++]=m;
                hashMap.put(m,hashMap.getOrDefault(m,integer)-1);
            }
        }
        int[] ints = Arrays.copyOfRange(num1, 0, k);
        Arrays.stream(ints).forEach(System.out::print);

    }
}
