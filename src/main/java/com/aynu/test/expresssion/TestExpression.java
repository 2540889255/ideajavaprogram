package com.aynu.test.expresssion;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author admin
 */
public class TestExpression {



    /**
     * .匹配所有的字段  .*字符串*.  字符串两边的值全部被匹配走了   .*字符串，可以替换字符串左边所有的值，以此类推
     *
     *^匹配必须以^后内容开头的字符串   类似于  ^1以1开头的字符串的1的部分会被匹配上
     *
     * 字符*匹配零次次或者多次， a*   清除掉所有的a的字符
     *
     * +匹配一次或者多次
     *
     * ？零次或者一次匹配      aa* aa+ aa?  一般配合两个字符用有筛选   一个的话，就是简单地删除含有筛选字符的值  两个的话
     */
    @Test
    public void test1() {
        /*String s="123hello    "+"orld123:;";

        String pattern=".";
        Pattern compile = Pattern.compile(pattern);

        Matcher matcher = compile.matcher(s);//macher   maches方法返回true or false 表示是否含有这个值
        String trim = matcher.replaceAll("").trim();
        System.out.printf(trim);*/

        String content = "aa2a7111I am noob " +
                "from runoob.com";

        String pattern = "\\W";

        Pattern compile = Pattern.compile(pattern);


        Matcher matcher = compile.matcher(content);

        String trim = matcher.replaceAll("").trim();
        System.out.printf(trim);
    }

    @Test
    public void show(){
        for (int i = 0; i < 50; i++) {
            System.out.println(new Random().nextInt(9));
        }
    }

}
