package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class LetCodeThree {
    int[] nums={2,1};
    @Test
    public void test(){
        int [] nums={2,1};
        int [] num1=new int[nums.length];
        int number=2;
        int a=0;
        int b=0;
        int d=nums[0];
        //List<Integer> list=new ArrayList();
        //数量为奇数情况
        if(nums.length%2>0){

            for (int i = 0; i <nums.length ; i++) {
                //a 是左边的移动
                //b 是做中间的值
                if (a+number>nums.length-1){
                    a=a-nums.length;
                }
                b=nums[a+number];
                nums[a+number]=d;
                d=b;
                a=a+number;
            }
        }else {
            int r=nums.length-number;
            for (int i = 0; i <nums.length ; i++) {

                if (r>nums.length-1){
                    r=0;
                }
                //list.add(nums[r]);
                num1[i]=nums[r];
                r++;

            }
            nums=num1;
        }
        for (int w:nums
             ) {
            System.out.print(w);
        }
        System.out.println(1%2);
        System.out.println(1%nums.length);
        //nums =list.toArray();

        //Arrays.stream(nums).forEach(System.out::print);
        //数量为偶数情况

        /*for (int i = number; i >0 ; i--) {
            int a=nums[nums.length-1];
            nums[i]=nums[i-1];
            nums[0]=a;
        }

        Arrays.stream(nums).forEach(System.out::print);*/
    }
    @Test
    public void test1(){
        int [] nums={1,2,3,4,5,6};
        List<Integer> list=new ArrayList();
        for (int i = 0; i <nums.length ; i++) {
            list.add(nums[i]);
        };
        Collections.reverse(list);
        int a =(int)list.get(0);
        list.add(a);
        list.remove(0);

        for (int b:list
             ) {

        }
    }
    @Test
    public void test2(){
        int [] nums={1,2,3,4,5,6};

    }
    @Test
    public void rotate(int[] nums) {
        //int [] nums={1,2};
        int k=1;
        int [] num1=new int[nums.length];
        int number=k%nums.length;
        int a=0;
        int b=0;
        int d=nums[0];

        //数量为奇数情况
        if(nums.length%2>0){

            for (int i = 0; i <nums.length ; i++) {
                //a 是左边的移动
                //b 是做中间的值
                if (a+number>nums.length-1){
                    a=a-nums.length;
                }
                b=nums[a+number];
                nums[a+number]=d;
                d=b;
                a=a+number;
            }
        }else {
            num1=nums.clone();
            int r=num1.length-number;
            for (int i = 0; i <num1.length ; i++) {

                if (r>num1.length-1){
                    r=0;
                }
                //list.add(nums[r]);
                nums[i]=num1[r];
                r++;

            }
        }
        System.out.println("这是幻术内部的输出");

        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        LetCodeThree letCodeThree=new LetCodeThree();
        int[] nums={2,1};
        letCodeThree.rotate(nums);
        System.out.println("这是main函数的输出");
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }

    }
}
