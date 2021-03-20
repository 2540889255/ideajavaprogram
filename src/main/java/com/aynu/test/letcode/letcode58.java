package com.aynu.test.letcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode58 {

    public static void main(String[] args) {
        int val=3;
        int[] nums={3};
        int i = removeElement2(nums, val);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int size=0;
        int length=nums.length;
        int last=length-1;
        if (length==1){
            if (nums[0]==val){
                nums=new int[1];
                return 1;
            }else {
                return 0;
            }
        }
        for (int i = 0; i < length; i++) {

            if (nums[i]==val){

                while (nums[last]==val){
                    last--;
                }
                if (last<i){
                    continue;
                }
                nums[i]=nums[last];
                nums[last]=val;
                last--;
                size++;
                length--;
            }
        }
        return size;

    }


    public static int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
