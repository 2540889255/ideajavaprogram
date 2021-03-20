package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode19 {

    public static void main(String[] args) {

        String s = countAndSay(1);
        System.out.println(s);
    }

    public static String countAndSay(int n) {


        /*if (n==1){
            return "11";
        }
        else {*/
            String s = String.valueOf(n);

            int[] size = new int[s.length() * 2];
            char[] chars = s.toCharArray();
            int sizeLocation = 0;
            int nowValue = 0;
            for (int j = 0; j < chars.length; j++) {

                if (j == 0) {
                    size[sizeLocation] = 1;
                    sizeLocation++;
                    size[sizeLocation] = Integer.valueOf(String.valueOf(chars[0]));
                    continue;
                }

                if (chars[j] == chars[j - 1]) {
                    size[sizeLocation - 1] += 1;
                } else {
                    size[sizeLocation] += 1;
                    sizeLocation++;
                    size[sizeLocation] = Integer.valueOf(String.valueOf(chars[j]));
                    sizeLocation++;
                }
            /*if (chars[j]==chars[j+1]){
                size[sizeLocation]+=1;
                size[sizeLocation+1]=j;
                sizeLocation=+2;
            }*/
            }
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < size.length; i++) {
                if (size[i] != 0) {
                    buffer.append(size[i]);
                }
            }

            System.out.println(buffer.toString());
            return buffer.toString();
        /*}*/



    }

    @Test
    public void show(){

        int s = 1;
        String string="";
        for (int i = 0; i < 5; i++) {
            string=countAndSay(s);
        }

    }
    @Test
    public void show1(){

        String string="1";
        for (int i = 0; i < 3; i++) {
            string=show(string);
        }



    }

    public static String show(String s){
        int[] size = new int[s.length() * 2];
        char[] chars = s.toCharArray();
        int sizeLocation = 0;
        int nowValue = 0;
        for (int j = 0; j < chars.length; j++) {

            if (j == 0) {
                size[sizeLocation] = 1;
                sizeLocation++;
                size[sizeLocation] = Integer.valueOf(String.valueOf(chars[0]));
                sizeLocation++;
                continue;
            }

            if (chars[j] == chars[j - 1]) {
                size[sizeLocation - 2] += 1;
            } else {
                size[sizeLocation] += 1;
                sizeLocation++;
                size[sizeLocation] = Integer.valueOf(String.valueOf(chars[j]));
                sizeLocation++;
            }

        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size.length; i++) {
            if (size[i] != 0) {
                buffer.append(size[i]);
            }
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
