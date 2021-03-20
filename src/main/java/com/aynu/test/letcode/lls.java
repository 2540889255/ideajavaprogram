package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lls {


    public static void main(String[] args) {
        int[] nums=new int[10];

        Random random=new Random();

        for (int i = 0; i < nums.length; i++) {

            int number = random.nextInt(20);
            //标志位，1代表有重复，0代表无重复值
            int sign=1;

            while (sign==1){
                sign=0;
                for (int j = 0; j < nums.length; j++) {
                    if (number==nums[j]){
                        sign=1;
                    }
                }
                nums[i]=number;
                number=random.nextInt(20);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void show1(){
        String strInput = "3a7s10@5d2a6s17s56;33";
        String regEx = "[^0-9]";//匹配指定范围内的数字

        //Pattern是一个正则表达式经编译后的表现模式
        Pattern p = Pattern.compile(regEx);

        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
        Matcher m = p.matcher(strInput);

        //将输入的字符串中非数字部分用空格取代并存入一个字符串
        String string = m.replaceAll("").trim();

        System.out.printf(string);
        /*//以空格为分割符在讲数字存入一个字符串数组中
        String[] strArr = string.split(" ");

        //遍历数组转换数据类型输出
        for(String s:strArr){
            System.out.print(Integer.parseInt(s));
        }*/
    }

    @Test
    public void changeString(){
        String s="abcdefghi5j213mk132132hdfsakjfda";

        Pattern patternDigest=Pattern.compile("[^0-9]");
        Pattern patternString=Pattern.compile("[^a-z]");

        Matcher matcherDigest = patternDigest.matcher(s);
        Matcher matcherString = patternString.matcher(s);
        //数字字符串
        String digest = matcherDigest.replaceAll("").trim();
        //英文字符串
        String string = matcherString.replaceAll("").trim();

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(digest);
        stringBuilder.append(string);

        System.out.printf(stringBuilder.toString());

    }

    @Test
    public void methed2(){
        //这是图片里的方法，当发现重复的进行回退，对应i--,这样最外层就多了一次循环
        int[] nums=new int[10];

        Random random=new Random();

        for (int i = 0; i < 10; i++) {

            int number=random.nextInt(20);
            nums[i]=number;
            for (int j = 0; j < i; j++) {
                if (number==nums[j]){
                    nums[i]=0;
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    @Test
    public void methed1(){

        //利用hashmap重复的值会被覆盖，放入10个不同的值
        int[] nums=new int[10];

        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();

        Random random=new Random();
        while (hashMap.size()!=10){
            int i = random.nextInt(20);
            hashMap.put(i,i);
        }
        //数组位置
        int position=0;
        Set<Integer> numbers = hashMap.keySet();
        for (Integer number:numbers
             ) {
            nums[position]=number;
            position++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void methed3(){
        //这是我的方法。随机下标
        int[] nums=new int[10];

        int[] nums2=new int[20];

        Random random=new Random();
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=i;
        }
        //size代表数组nums含有元素的长度
        int size=0;
        while (size<10){
            int number=random.nextInt(20);

            if (nums2[number]!=-1){
                nums[size]=nums2[number];
                nums2[number]=-1;
                size++;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
