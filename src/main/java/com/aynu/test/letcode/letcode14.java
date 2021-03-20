package com.aynu.test.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class letcode14 {

    public static void main(String[] args) {

        boolean anagram = isAnagram("ab", "a");
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        boolean equals = Arrays.equals(schars, tchars);
        return equals;

    }
    public static boolean isAnagram1(String s, String t) {

        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        if (s.length()>t.length()){
            String template=s;
            s=t;
            t=template;
        }
        int slength=s.length();
        int tlength=t.length();

        boolean result=true;
        for (int i = 0; i < slength; i++) {
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        int size=hashMap.size();
        for (int i = 0; i < tlength; i++) {
                hashMap.put(t.charAt(i),hashMap.getOrDefault(t.charAt(i),0)-1);
            Integer integer = hashMap.get(t.charAt(i));
            if (integer<0){
                result=false;
                break;
            }
        }



        return result;
    }
}
