package com.aynu.test.sort;

import com.aynu.test.Until.LuchenArraysUntil;
import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 02 26 16:15
 * @Description : com.aynu.test.sort
 * @Version 1.0
 */
public class Mergesort {

    public static void main(String[] args) {
        LuchenArraysUntil.creatArrays(5,0,9);
    }

    @Test
    public void test(){
        int[] nums = {1,4,0,2,7};


        //int[] sort = merge(nums,0,2,4);
        sort(nums,0,4);
        LuchenArraysUntil.printArrays(nums);


    }

    public void sort(int[] nums,int left,int right){
        if (left==right){
            return;
        }
        int middle=left+(right-left)/2;
        sort(nums,left,middle);

        sort(nums,middle+1,right);

        merge(nums,left,middle,right);
    }

    /*merge操作
    *
    *
    * */
    public static int[]  merge(int[] nums,int left,int middlePosition,int right){


        int i = left;

        int j=middlePosition+1;

        int tposition=0;
        int[] template=new int[right-left+1];
        while (i <= middlePosition&& j <= right){
                template[tposition++]=nums[i]<=nums[j] ? nums[i++]:nums[j++];
        }

        while (i<=middlePosition) {
            template[tposition]=nums[i++];
        }
        while (j<=right) {
            template[tposition]=nums[j++];
        }

        for (int i1 = 0; i1 < template.length; i1++) {
            nums[left++]=template[i1];
        }


        return template;
    }








}
