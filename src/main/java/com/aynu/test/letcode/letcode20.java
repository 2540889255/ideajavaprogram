package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 *
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode20 {

    public static void main(String[] args) {
        String[] strings=new String[6];
        strings[0]="flight";
        strings[1]="flights";
        strings[2]="flight";
        strings[3]="flights";
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {


        StringBuffer stringBuffer=new StringBuffer();

        stringBuffer.append(strs[0]);
        int length=strs[0].length()-1;
        String common="";
        for (int i = 0; i < length; i++) {
            int indexOf = strs[1].indexOf(String.valueOf(stringBuffer));


            if (indexOf==-1){
                stringBuffer.deleteCharAt(length--);
            }else {
                common=stringBuffer.toString();
            }
        }
        return common;
    }


    public static String longestCommonPrefixs(String[] strs,String common) {


        StringBuffer stringBuffer=new StringBuffer();

        stringBuffer.append(strs[0]);
        int length=strs[0].length()-1;
        common="";
        for (int i = 0; i < length; i++) {
            int indexOf = strs[1].indexOf(String.valueOf(stringBuffer));


            if (indexOf==-1){
                stringBuffer.deleteCharAt(length--);
            }else {
                common=stringBuffer.toString();
            }
        }
        return common;
    }


    @Test
    public void show(){

        String[] strings=new String[6];
        strings[0]="flower";
        strings[1]="flow";
        strings[2]="flight";

        String common=strings[0];
        System.out.println(strings.length);
        for (int i = 1; i < strings.length; i++) {
            common=longestCommonPrefixss(strings[i], common);
        }
        System.out.println(common);
    }

    public static String longestCommonPrefixss(String strs,String common) {


        StringBuffer stringBuffer=new StringBuffer();

        stringBuffer.append(common);
        int length2=common.length()-1;
        int length=common.length()-1;
        for (int i = 0; i < length2; i++) {
            int indexOf = strs.indexOf(String.valueOf(stringBuffer));
            if (indexOf==-1){
                stringBuffer.deleteCharAt(length--);
            }else {
                return common=stringBuffer.toString();
            }
        }
        return common;
    }


    /*public String longestCommonPrefix(String[] strs) {
        String common=strs[0];
        System.out.println(strs.length);
        for (int i = 1; i < strs.length; i++) {
            common=longestCommonPrefixss(strs[i], common);
        }
        return common;
    }
    public static String longestCommonPrefixss(String strs,String common) {


        StringBuffer stringBuffer=new StringBuffer();

        stringBuffer.append(common);
        int length2=common.length()-1;
        int length=common.length()-1;
        for (int i = 0; i < length2; i++) {
            int indexOf = strs.indexOf(String.valueOf(stringBuffer));
            if (indexOf==-1){
                stringBuffer.deleteCharAt(length--);
            }else {
                return common=stringBuffer.toString();
            }
        }
        return common;
    }*/
}



