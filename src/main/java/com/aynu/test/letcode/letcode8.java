package com.aynu.test.letcode;


import java.util.Arrays;
import java.util.HashMap;

/**
 *两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class letcode8 {

    public static void main(String[] args) {
        int[] nums={0,4,3,0};

        int target=0;

        HashMap map=new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){

            }

            map.put(nums[i],nums[i]);
        }

    }

    public int[] show(){
        return new int[]{1,2};
    }

    public void mendth(){
        int[] nums={0,4,3,0};

        int target=0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {

                int number=target-nums[i];
                if (number==nums[j]){
                    int [] list={i,j};
                    Arrays.stream(list).forEach(System.out::print);
                }


            }

        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();


        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }

            map.put(nums[i],i);
        }
        return nums;
    }
}
