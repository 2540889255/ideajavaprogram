package com.aynu.test.letcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *

 1.[abc] : 表示可能是a，可能是b，也可能是c。
 2.[^abc]: 表示不是a,b,c中的任意一个
 3.[a-zA-Z]: 表示是英文字母
 4.[0-9]:表示是数字

 简洁的字符表示
 .：匹配任意的字符
 \d：表示数字
 \D：表示非数字
 \s：表示由空字符组成，[ \t\n\r\x\f]
 \S：表示由非空字符组成，[^\s]
 \w：表示字母、数字、下划线，[a-zA-Z0-9_]
 \W：表示不是由字母、数字、下划线组成

 数量表达式
 1.?: 表示出现0次或1次
 2.+: 表示出现1次或多次
 3.*: 表示出现0次、1次或多次
 4.{n}：表示出现n次
 5.{n,m}：表示出现n~m次
 6.{n,}：表示出现n次或n次以上

 */
public class letcode17 {

    public static void main(String[] args) {
        int i = myAtoi("+2");
        System.out.println(i);



    }


    public static int myAtoi(String str) {


        str=str.trim();
        //^[\\+\\-]?\\d+
        //
        //^ 表示匹配字符串开头，我们匹配的就是 '+'  '-'  号
        //
        //[] 表示匹配包含的任一字符，比如[0-9]就是匹配数字字符 0 - 9 中的一个
        //
        //? 表示前面一个字符出现零次或者一次，这里用 ? 是因为 '+' 号可以省略
        //
        // \\d 表示一个数字 0 - 9 范围
        //
        //+ 表示前面一个字符出现一次或者多次，\\d+ 合一起就能匹配一连串数字了

        Pattern pattern=Pattern.compile("^[\\+\\-]?\\d+");

        Matcher matcher = pattern.matcher(str);

        int value=1;

        if (matcher.find()){
            try {
                value = Integer.valueOf(str.substring(matcher.start(), matcher.end()));

            }catch (Exception e){
                value=str.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return value;
    }

    public static int myAtoi1(String str) {
        if (str.length()==0){
            return 0;
        }
        StringBuffer stringBuffer=new StringBuffer();
        int fign=0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])){
                stringBuffer.append(chars[i]);
                fign=1;
            }
            if (chars[i]!=' '&&fign!=1){
                if (chars[i] == '-'||chars[i] == '+') {
                    if (chars[i] == '-'){
                        stringBuffer.insert(0,'-');
                    }else {

                    }

                } else{
                    return 0;
                }
            }
            if (fign==1&&!Character.isDigit(chars[i])){
                break;
            }
        }
        String s = stringBuffer.toString();

        if (s.equals("-")||s.equals("+")){
            return 0;
        }
        if (s.length()==0){
            return 0;
        }
        Integer integer;
        try {
            integer= Integer.valueOf(s);
        }catch (Exception e){

            return  chars[0]=='-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }

        return integer;
    }
}
