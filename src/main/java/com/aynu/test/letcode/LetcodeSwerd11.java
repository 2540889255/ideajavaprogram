package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 02 28 12:28
 * @Description : com.aynu.test.letcode
 * 剑指 Offer 11. 旋转数组的最小数字
 * @Version 1.0
 */
public class LetcodeSwerd11 {



    public int minArray(int[] numbers) {

        int max=numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i]<max){
                return i;
            }
        }

        return 0;
    }


    @Test
    public void test(){
        int[] nums={3,4,5,1,2};
    }
}
