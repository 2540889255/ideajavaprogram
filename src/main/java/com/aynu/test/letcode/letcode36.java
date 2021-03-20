package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 * @author admin
 */
public class letcode36 {


    public static void main(String[] args) {
        int [] nums={-2,-3};

        int i = maxSubArray2(nums);
        System.out.println(i);
    }

    public  static int maxSubArray2(int[] nums) {

        int sum=0;
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i]<nums[i]?nums[i]:sum+nums[i];
            /*int result=sum+nums[i];
            sum=sum>result?sum:result;*/

            max=sum>max?sum:max;
        }
        System.out.println("this"+max);
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public  static int maxSubArray(int[] nums) {

        int sum=0;
        /*int d=0;
        while (nums[d]<0){
            sum=sum>nums[d]?sum:nums[d];
            d++;
        }
        System.out.println("this is start sum"+sum);*/
        int max=0;
        int fig=0;
        int maxmin=nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxmin=maxmin>nums[i]?maxmin:nums[i];
            int result=sum+nums[i];
            if (result<0){
                sum=0;
            }else {
                fig=1;
                sum=sum+nums[i];
            }
            System.out.println(sum);
            max=sum>max?sum:max;
        }
        if (fig==0){
            return maxmin;
        }
        System.out.println("this"+max);
        return max;
    }

    @Test
    public void show(){
        System.out.println(1>Integer.MAX_VALUE);
    }
}
