package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode52 {

    public static void main(String[] args) {
/*
        int [][] intervals={{1,4}};
*/
        int [][] intervals={{1,6},{2,10},{15,18}};

        int[][] merge = merge(intervals);
        System.out.println("hello");
    }
    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int min=intervals[0][0];
        int max=intervals[0][1];

        int [][] interval=new int[intervals.length][2];
        int intervalPosition=0;
        interval[intervalPosition][0]=min;
        interval[intervalPosition][1]=max;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=interval[intervalPosition][1]){
                interval[intervalPosition][1]=Math.max(intervals[i][1],interval[intervalPosition][1]);
            }else {
                intervalPosition+=1;
                interval[intervalPosition][0]=intervals[i][0];
                interval[intervalPosition][1]=intervals[i][1];
            }
        }

        int[][] ints = Arrays.copyOf(interval, intervalPosition+1);
        return ints;
    }


    @Test
    public void show(){

        int [] nums={1,2,3,4,5};
        System.out.println(nums.length);
        nums[2]= Integer.parseInt(null);
        System.out.println(nums.length);

    }
}
