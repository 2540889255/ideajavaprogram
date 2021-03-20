package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 *
 */
public class letcode13 {

    public static void main(String[] args) {
        int i = firstUniqChar("leetcode");



        System.out.println(i);
    }

    public static int firstUniqChar(String s) {

        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();

        int length=s.length();
        for (int i = 0; i < length; i++) {
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0));
        }

        for (int i = 0; i < length; i++) {
            if (hashMap.get(s.charAt(i))==1){
                return i;
            }


        }
        return -1;

    }
    public static int firstUniqChar2(String s) {
        int index=0;
        int a=-1;
        String after = s;
        int length=s.length();
        for (char c : s.toCharArray()) {
            length=after.length();
            after = after.replaceAll(String.valueOf(c), "");
            if (length-after.length()==1){
                a= index;
                break;
            }
            index++;
        };

        return a;

    }
    public static int firstUniqChar1(String s) {
        int index=0;
        int a=-1;
        boolean contains=false;
        String after="";
        for (char c : s.toCharArray()) {
            after = s.replaceFirst(String.valueOf(c), "");
            contains= after.contains(String.valueOf(c));
            if (!contains){
                a=index;
                break;
            }
            index++;
        };
        return a;
    }

    @Test
    public void show(){
        String a="1231";

        String s = a.replaceFirst("1", "");
        System.out.println(s);
    }

    @Test
    public void show1(){
        HashMap hashMap=new HashMap();


        hashMap.put("1",1);
        hashMap.put("2",1);
        hashMap.put("3",1);
        hashMap.put("4",1);
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println();
        }
    }
}
