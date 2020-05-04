package main.com.aynu.test.letcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 */
public class Letcodeone {
    public static void main(String[] args) {
        int a=0;
        int b=0;
        int c=1;
        int [] nums={1,1,1};
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                b++;
                if (nums[i]==nums[j]){
                    a++;
                }
                if (nums[i]!=nums[j]){
                    nums[c]=nums[j];
                    c++;
                    i=b;

                }
            }
        }
        IntStream stream = Arrays.stream(nums);
        stream.forEach(System.out::println);
        System.out.println(nums.length-a);
    }
    @Test
    public void test(){
        int [] nums={1,1};
        int a=0;
        int b=a+1;
        int c=1;
        int e=1;
        boolean d=true;

        while (d){
            if (nums[a]!=nums[b]){
                c++;
                nums[e]=nums[b];
                e++;
            }
            a++;
            b++;
            if (b == nums.length){
                d=false;
            }

        }
        IntStream stream = Arrays.stream(nums);
        stream.forEach(System.out::println);
    }
}
