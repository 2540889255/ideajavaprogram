package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class LetCodeFour {

    @Test
    public void test() {
        int[] nums = {1, 2,5,5, 8, 7, 6, 4, 3};
        int a=nums.length;
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
        }
        int b=map.size();
        if (a==b){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
    @Test
    public void test2(){
        int [] nums={1,2,3,4,8,4};
        Arrays.asList(nums)
                .stream()
                .collect(Collectors.toSet());

    }
}
