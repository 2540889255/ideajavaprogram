package com.aynu.test.letcode;

/**
 * @author admin
 */
public class letcode41 {

    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(1 / 3);
        System.out.println(powerOfThree);
    }


    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
