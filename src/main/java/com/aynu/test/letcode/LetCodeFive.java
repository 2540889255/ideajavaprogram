package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class LetCodeFive {

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        int [] nums={1,2,5,1,2,4,6,4,6};

        for (int i = 0; i <nums.length ; i++) {
            boolean a=true;
            if (nums[i]==-1){
                continue;
            }
            for (int j = i+1; j <nums.length ; j++) {

                if (nums[i]==nums[j]){
                    nums[j]=-1;
                    a=false;
                    break;
                }
            }
            if (a){
                System.out.println(nums[i]);
                //return nums[i];
            }
        }
        long end=System.currentTimeMillis();
        System.out.println(start=end);
    }

    @Test
    public void test2(){
        int [] nums={1,2,5,1,2,4,6,4,6};

        Map map=new HashMap();

        for (int i = 0; i <nums.length ; i++) {
            int a=map.size();
            map.put(nums[i],"1");
            int b=map.size();
            if (a == b) {
                System.out.println(nums[i]);
            }
        }
    }
    @Test
    public void test3(){
        int [] nums={1,2,5,1,2,4,6,4,6};

        List list=new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])){
                list.remove(nums[i]);
            }else {
                list.add(nums[i]);
                //System.out.println(nums[i]);
            }

        }
        System.out.println(list);
    }
    @Test
    public void test5(){
        int [] nums={1,2,5,1,2,4,6,4,6};

        Map map=new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])!=null){
                map.remove(nums[i]);
            }else {
                map.put(nums[i],nums[i]);
                //System.out.println(nums[i]);
            }

        }

        String string=map.toString();
        char[] chars = string.toCharArray();
        int s=(int) chars[1];
        System.out.println(s);
        /*Collection values = map.values();
        Iterator iterator = values.iterator();
        int s = (int)iterator.next();
        System.out.println(s);*/
    }
}
