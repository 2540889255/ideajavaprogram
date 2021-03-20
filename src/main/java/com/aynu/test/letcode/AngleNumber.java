package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 03 02 19:07
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 */
public class AngleNumber {


    public static void main(String[] args) {
        judge(17);
    }


    public static boolean judge(int number) {

        List list=new ArrayList();
        while (true){
            int sum = sum(judges(number));
            if (sum==1){
                return true;
            }
            System.out.println(sum);
            if (list.contains(sum)){
                return false;
            }else {
                list.add(sum);
            }

            number=sum;
        }


    }
    public static int sum(int[] numbers){
        int sum=0;
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i]*numbers[i];
        }
        return sum;
    }

    public static int[]  judges(int number){
        int position=0;
        int[] numbers=new int[number];
        while (number>0){
            numbers[position]=number%10;
            number=number/10;
            position++;
        }
        return numbers;
    }

    /*public static boolean judge(int number){

        int position=0;
        int[] numbers=new int[number];

        while (number!=1){
            while (number/10!=0&&number%10!=0){
                numbers[position]=number%10;
                position++;
                number=number/10;
                System.out.println(number);
            }

            for (int i = 0; i < numbers.length; i++) {
                number+=numbers[i]*numbers[i];
            }
            System.out.println(number);
            position=0;
            numbers=new int[number];
        }

        return true;
    }*/




}
