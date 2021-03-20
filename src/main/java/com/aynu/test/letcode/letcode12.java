package com.aynu.test.letcode;

import java.io.CharArrayReader;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *
 */
public class letcode12 {

    public static void main(String[] args) {
        long reverse = reverse(164632465);
        int a=2147483647;
        int b=a+3;
        boolean d=b>a;
        System.out.println(d);
    }

    public static int reverse3(int x){
        int res = 0;
        while(x!=0) {
            int tmp = x % 10;
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return x;

    }

    public static int reverse(int x) {
        int last;
        int result=0;
        int ten=1;

        int a=956423646;
        int b=a*100;
        System.out.println(b);

        try {
            while (x>0){
                last=x%10;
                x=x/10;

                result=result*10+last;

                System.out.println(result);
            }

        }catch (Exception e){
            return 0;
        }

        return result;
    }

    public static int reverse1(int x) {


        Integer number=x;
        String s = "";
        String[] split = new String[1];
        int result;
        int index=0;
        s = String.valueOf(number);
        if (x<0){
             split = s.split("-");
             index=1;
        }
        split[0]=s;
        char[] chars = split[index].toCharArray();
        char template;
        int length=chars.length;
        for (int i = 0; i < length/2; i++) {
            template=chars[i];
            chars[i]=chars[length-i-1];
            chars[length-i-1]=template;
        }



        String s1 =String.valueOf(chars);
        Integer integer;
        try {
             integer = Integer.valueOf(s1);
        }catch (Exception e){
            return 0;
        }

        if (x<0){
            result=integer-integer-integer;
        }else {
            result=integer;
        }

        return result;
    }



}
