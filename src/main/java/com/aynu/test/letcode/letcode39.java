package com.aynu.test.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode39 {

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        for (String s:list
             ) {
            System.out.println(s);
        }
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i>=3) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add("FizzBuzz");
                    continue;
                }
                if (i % 3 == 0) {
                    list.add("Fizz");
                    continue;
                }
                if (i % 5 == 0) {
                    list.add("Buzz");
                    continue;
                }else {
                    list.add(String.valueOf(i));
                }
            }else {
                list.add(String.valueOf(i));
            }
        }
        
        return list;
    }
}
