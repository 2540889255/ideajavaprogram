package com.aynu.test.exam;

import java.util.Scanner;

/**
 * @Auther: LC
 * @Date : 2021 03 04 18:43
 * @Description : com.aynu.test.exam
 * @Version 1.0
 */
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a = 0, b = 0;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            run(a,b);
        }

    }


    public static void run(int a,int b){
        System.out.println(a+b);
    }

}
