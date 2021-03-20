package com.aynu.test.letcode;

/**
 * 缺失数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode48 {

    public static void main(String[] args){
        int [] nums={0};
        int i = missingNumber(nums);
        System.out.println(i);
    }
    public  static int missingNumber(int[] nums) {
        Long sum=Long.valueOf(nums.length)*(nums.length+1)/2;
        Long result=0L;
        for (int i = 0; i < nums.length; i++) {
            sum=sum-nums[i];
        }
        return sum.intValue();
    }
}
