package com.aynu.test.letcode;

/**
 *
 *搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode51 {


    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int i = searchInsert(nums, 2);
        System.out.println(i);
    }


    public static int searchInsert(int[] nums, int target) {
        if (target<nums[0]){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (target<nums[i]){
                return i;
            }
        }
        return 0;
    }

    public static int searchInsert1(int[] nums, int target){

        int n=nums.length;
        int left=0;
        int right=n-1;
        int middle=0;
        int ans=n;
        while (left<=right){

            middle=((right-left)>>1)+left;

            if (target<=nums[middle]){
                ans=middle;
                right=middle-1;

            }else {
                left=middle+1;
            }

        }
        return ans;

    }
}
