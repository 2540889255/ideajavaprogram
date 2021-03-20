package com.aynu.test.sort;

import com.aynu.test.Until.LuchenArraysUntil;

/**
 * @Auther: LC
 * @Date : 2021 02 26 22:50
 * @Description : com.aynu.test.sort
 * @Version 1.0
 */
public class MergeSortTeacher {


    public static void main(String[] args) {
        int[] arr = {1,4,0,2,7};

        sort(arr,0,arr.length-1);

        LuchenArraysUntil.printArrays(arr);
    }


    public static void sort(int[] arr,int left,int right){

        if (left==right){
            return;
        }
        int mid=left+(right-left)/2;
        sort(arr,left,mid);

        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);
    }

    public static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){

        int mid=rightPtr-1;

        int[] temp=new int[rightBound-leftPtr+1];

        int i=leftPtr;

        int j=rightPtr;

        int k=0;
        while (i <= mid&& j <= rightBound){
            temp[k++]=arr[i]<=arr[j] ? arr[i++]:arr[j++];
        }

        while (i<=mid) {
            temp[k]=arr[i++];
        }
        while (j<=rightBound) {
            temp[k]=arr[j++];
        }

        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[leftPtr++]=temp[i1];
        }


    }

}
