package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class letcode16 {

    public static void main(String[] args) {

        boolean afdsafd = isPalindrome("\",,,,,,,,,,,,acva\"");
        System.out.println(afdsafd);
    }

    public  static  boolean isPalindrome(String s) {

        s=s.toUpperCase();
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars = s.toCharArray();

        int index=0;
        int last=chars.length;
        int length= chars.length;
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(chars[index])){
            }else {
                index++;
                length--;
                continue;
            }
            while (!Character.isLetterOrDigit(chars[last-1])){
                last--;
                length--;
            }
            if (chars[index]!=chars[last-1]){
                return false;
            }
                index++;
                last--;

        }
        return true;

    }


    public  static  boolean isPalindrome3(String s) {
        s=s.toUpperCase();
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])){
                stringBuffer.append(chars[i]);
            }
        }
        String toString = stringBuffer.toString();
        char[] chars1 = toString.toCharArray();
        int length= chars1.length;
        for (int i = 0; i < length/2; i++) {

            if (chars1[i]!=chars1[length-i-1]){
                return false;
            }
        }

        return true;
    }

    public  static  boolean isPalindrome2(String s) {
        s=s.toUpperCase();
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])){
                stringBuffer.append(chars[i]);
            }
        }

        StringBuffer reverse = new StringBuffer(stringBuffer).reverse();
        int result = stringBuffer.compareTo(reverse);
        System.out.println(result);
        return true;
    }
    public  static  boolean isPalindrome1(String s) {

        String number=s;
        number = number.toLowerCase();
        number = number.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");
        char[] chars = number.toCharArray();
        int length= chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i]!=chars[length-i-1]){
                return false;
            }
        }

        return true;
    }

    @Test
    public void show(){

        int a=2;
        for (int i = 0; i < a; i++) {

            a=9;

            System.out.println(a);
        }
    }
}
