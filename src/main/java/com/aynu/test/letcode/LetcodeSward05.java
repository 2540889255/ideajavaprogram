package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: LC
 * @Date : 2021 02 27 15:35
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class LetcodeSward05 {


    public static void main(String[] args) {
        String str="\"We are happy.\"";
        System.out.println(str.length());
    }

    @Test
    public void test(){
        replaceSpace("\"We are happy.\"");
    }
    public static String replaceSpace(String s) {
        //Pattern中使用的是匹配规则
        String rule="\\s";

        Pattern pattern=Pattern.compile(rule);

        Matcher matcher=pattern.matcher(s);

        String trim = matcher.replaceAll("%20").trim();
        System.out.println(trim);
        return trim;
    }
}
