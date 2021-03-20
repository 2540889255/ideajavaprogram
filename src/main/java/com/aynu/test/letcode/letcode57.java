package com.aynu.test.letcode;

/**
 *
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/conm7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode57 {

    public static void main(String[] args) {
        String aba = longestPalindrome2("abbba");
        System.out.println(aba);
    }

    public static String longestPalindrome(String s) {

        StringBuffer stringBuffer=new StringBuffer();
        char[] chars = s.toCharArray();
        int length=chars.length;
        String result = s.substring(0,1);
        for (int i = 1; i < length; i++) {
            int x=i-1;
            int y=i+1;
            stringBuffer.append(chars[i]);

            while (x>=0&&y<=length-1&&chars[x]==chars[y]){
                    stringBuffer.insert(0,chars[x]);
                    stringBuffer.append(chars[y]);
                    x--;
                    y++;
            }

            if (x>=0&&chars[x]==chars[i]){
                stringBuffer.insert(0,chars[x]);
                x++;
            } /*else if (chars[x]==chars[i]){
                stringBuffer.insert(0,chars[x]);
                x--;
            }*/
            if (result.length()<stringBuffer.length()){
                result=stringBuffer.toString();
            }
            stringBuffer.delete(0,stringBuffer.length());
        }

        return result;
    }

    public static String longestPalindrome1(String s) {
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars = s.toCharArray();
        int length=chars.length-1;
        String result = s.substring(0,1);
        for (int i = 1; i < length; i++) {
            int x=i-1;
            int y=i+1;
            stringBuffer.append(chars[i]);
            if (chars[x]==chars[i]){
                stringBuffer.insert(0,chars[x]);
                x--;
            }else if (chars[y]==chars[i]){
                stringBuffer.append(chars[y]);
                y++;
            }

            while (x>=0&&y<=length&&chars[x]==chars[y]){

                stringBuffer.insert(0,chars[x]);
                stringBuffer.append(chars[y]);
                x--;
                y++;

            }
            if (result.length()<stringBuffer.length()){
                result=stringBuffer.toString();
            }
            stringBuffer.delete(0,stringBuffer.length());
        }

        return result;
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

}
