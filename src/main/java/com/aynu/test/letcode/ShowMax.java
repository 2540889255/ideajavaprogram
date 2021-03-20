package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 * @author admin
 */
public class ShowMax {


    public static void main(String[] args) {

        int [] numbers={1,2,3,6,8,9,5};
        int legth=numbers.length-1;
        int max = max(numbers, legth);
        System.out.println(max);
    }


    public static int max(int [] numbers,int length){


        if (length==0){
            return numbers[0];
        }else {
            return Math.max(numbers[length],max(numbers,length-1));
        }
    }

    public static int sum(int  number){
        System.out.println(number);

        if (number==0){
            return 0;
        }else {
            return  number+sum(number-1)+sum(number-1);
        }

    }

    @Test
    public void count(){
        int sum = sum(2);
        System.out.println(sum);
    }
}
