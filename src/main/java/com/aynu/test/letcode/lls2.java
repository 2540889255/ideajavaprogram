package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lls2 {


    public static void main(String[] args) {

    }

    @Test
    public void changeString1(){

        String s="abcdefghi5j213mk132132hdfsakjfda";
        //数字接受者   StringBuilder支持使用append动态增加字符
        StringBuilder digest = new StringBuilder();
        //字符字符接受者
        StringBuilder string = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char c:chars
             ) {
            //isDigit判断字符是否为数字，是的话则加入到数字专属StringBuilder中
            if (Character.isDigit(c)){
                digest.append(c);
            }else {
                string.append(c);
            }
        }
        digest.append(string);
        System.out.printf(digest.toString());
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



}
