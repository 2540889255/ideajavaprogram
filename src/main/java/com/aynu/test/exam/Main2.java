package com.aynu.test.exam;

/**
 * @Auther: LC
 * @Date : 2021 03 04 19:16
 * @Description : com.aynu.test.exam
 * @Version 1.0
 */
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {




    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());

        int res = maxAmount(packets, n);
        System.out.println(res);
    }

    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }


    @Test
    public void test(){
        int[] packets={1,2,3,4,5,6,7,8,9};
        int length=packets.length;
        int n=6;
        int average = average(packets, n);
        System.out.println(average);
        int remove = remove(packets, n, average);
        System.out.println(remove);
        length=length-remove;
        int[] nowpackets = copyArray(packets, length);
        int last = last(nowpackets, average);
        System.out.println(last);

    }
    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {

        return 1;
    }

    public static int average(int[] packets,int n){
        int sum=0;
        for (int i = 0; i < packets.length; i++) {
            sum+=packets[i];
        }
        System.out.println(sum);
        return sum/n;
    }

    public static int remove(int[] packets,int n,int average){

        for (int i = 0; i < packets.length; i++) {
            if (packets[i]>=average){
                n--;
            }

        }
        return n;
    }

    public static int[] copyArray(int[] packets,int n){
        int[] packetsbak=new int[n];
        for (int i = 0; i < n; i++) {
            packetsbak[i]=packets[i];
        }
        return packetsbak;
    }

    public static int last(int[] packets,int average){
        int max=0;

        int last=0;
        for (int i = 0; i < packets.length; i++) {
            max+=packets[i];
            if (max>average){
                return last;
            }
            last=max;
        }
        /*int[][] nums=new int[n][n];
        int xsize=0;
        int ysize=0;

        int position=0;


        for (int i = 0; i < packets.length; i++) {
            max+=packets[i];
            n--;
            if (n!=0){
                for (int j = i+1; j < packets.length; j++) {
                    if (max>packets[j]){

                    }
                }
            }

        }*/
        return max;
    }

    @Test
     void maxAmount1() {

        int[] packets={1,2,3,4,5,6,7,8,9};
        int n=6;
        int length=packets.length;
        int average = average(packets, n);
        System.out.println(average);
        int remove = remove(packets, n, average);
        System.out.println(remove);
        length=length-remove;
        int[] nowpackets = copyArray(packets, length);
        int last = last(nowpackets, average);
        System.out.println(last);
    }
}
