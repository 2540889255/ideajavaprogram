package com.aynu.test.exam;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Auther: LC
 * @Date : 2021 03 04 19:50
 * @Description : com.aynu.test.exam
 * @Version 1.0
 */
public class Main3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());
        
        int res = sum(packets, n,n+1);
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
        String s=new String("(+ 3 4)");
        char[] chars = s.toCharArray();
        System.out.println(1);

    }



    public static int sum3(int[] packets,int left,int right) {

        return 1;
    }

    public static int sum(int[] packets,int left,int right){
        int operator=1;
        return 1;
    }

}
