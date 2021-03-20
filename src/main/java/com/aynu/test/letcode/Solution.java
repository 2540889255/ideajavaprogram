package com.aynu.test.letcode;

import java.util.Random;

/**
 *
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 *  
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn6gq1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class Solution {

    int [] nums;

    int [] template;

    Random random=new Random();
    public Solution(int[] nums) {
        this.nums=nums;
        this.template=nums.clone();
    }


    public static void main(String[] args) {
        int [] nums={1};
        Solution solution=new Solution(nums);
        int[] shuffle = solution.shuffle();
        for (int num:shuffle
             ) {
            System.out.print(num);
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums=template;
        template=template.clone();
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length=nums.length;
        int i=0;
        int template=0;
        while (length!=0){
            i = random.nextInt(length);
            template=nums[i];
            nums[i]=nums[length-1];
            nums[length-1]=template;
            length--;
        }
        return nums;
    }

}
