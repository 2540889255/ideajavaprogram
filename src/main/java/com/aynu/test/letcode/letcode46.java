package com.aynu.test.letcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode46 {

    public static void main(String[] args) {
        /*boolean valid = isValid("]]");
        System.out.println(valid);*/
        boolean valids = isValids("{}[]");
        System.out.println(valids);
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack();
        for (char c:chars
             ) {
            if (stack.size()!=0) {
                if (result(stack.peek(),c)) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        if (stack.size()==0){
            return true;
        }
        return false;
    }

    public static boolean result(char a,char b){
        if (a=='('&&b==')'){
            return false;
        }
        if (a=='{'&&b=='}'){
            return false;
        }
        if (a=='['&&b==']'){
            return false;
        }
        return true;
    }

    public static boolean isValids(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
