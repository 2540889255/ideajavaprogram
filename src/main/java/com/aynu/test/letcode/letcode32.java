package com.aynu.test.letcode;

import java.util.Arrays;

/**
 *
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode32 {


    public static void main(String[] args) {
        /*int [] nums1=new int[6];
        nums1[0]=1;
        nums1[1]=2;
        nums1[2]=3;
        int [] nums2={2,5,6};
        merge(nums1,3,nums2,nums2.length);
        System.out.println("hello");*/
        int [] nums1=new int[6];
        nums1[0]=1;
        nums1[1]=2;
        nums1[2]=3;
        nums1[3]=0;
        nums1[4]=0;
        nums1[5]=0;
        int [] nums2={2,5,6};
        merge2(nums1,3,nums2,nums2.length);
        System.out.println("hello");
    }

    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }*/

    /*
    三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
    // 1.当，p1>=0时，nums[p1],nums[p2]对比
    // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
    // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
    // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
    // 循环结束条件：p2<0

    int p1=m-1,p2=n-1,p3=m+n-1;
        while(p2 >= 0){
        if(p1 >= 0 && nums1[p1] > nums2[p2]){
            nums1[p3--] = nums1[p1--];
        } else {
            nums1[p3--] = nums2[p2--];
        }
    }
    * */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {



    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int template;
        int min = Math.min(nums1[0], nums2[0]);
        if (m==0){
            System.arraycopy(nums2,0,nums1,m,n);
            return;
        }
        if (n==0){
            return;
        }
        int position=m+n-1;
        n--;
        m--;

        int length=nums1.length;

        for (int i = length-1; i >=0; i--) {
            if (nums2[n]>=nums1[m]){
                nums1[i]=nums2[n];
                if (n==0){
                    nums2[0]=min-1;
                    continue;
                }
                if (n>0){
                    n--;
                }
            }else {
                nums1[i]=nums1[m];
                if (i!=m) {
                    nums1[m] = min - 1;
                }
                if (m==0){
                    continue;
                }
                m--;
            }
        }

    }

}
