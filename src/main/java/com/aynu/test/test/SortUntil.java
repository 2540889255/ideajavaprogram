package com.aynu.test.test;

import java.util.Arrays;
import java.util.Comparator;

/**插入排序
 * @author admin
 */

public  class SortUntil<T> {

    public static void insertSort(int[] list) {


        /*for (int i = 1; i < list.length; i++) {
                swap(i,list);
        }
        Arrays.stream(list).forEach(System.out::print);*/
    }

    public static void swap(int i,Comparable[] list){
        int star = i-1;
        if (star>=0){
            if (list[i].compareTo(list[i-1])==-1){
                Comparable template=list[i-1];
                list[i-1]=list[i];
                list[i]=template;
                swap(i-1,list);
            }

        }
    }


    public static void compares(Comparable[] list){

        for (int i = 1; i < list.length; i++) {
            swap(i,list);
        }

    }
}
