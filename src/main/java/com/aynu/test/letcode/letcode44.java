package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 *
 *
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnyode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode44 {


    public static void main(String[] args) {

        System.out.println(Integer.bitCount(11));
        System.out.println(hammingDistance(1,12));
    }


    public static int hammingDistance(int x, int y) {
        int i = Integer.bitCount(x ^ y);
        return i;
    }

    @Test
    public void show(){
        System.out.println(bitCount(3));
        System.out.println(8>>>1);
        System.out.println(0x55555555);
        System.out.println((3 >>> 1) & 0x55555555);
        System.out.println(3 - ((3 >>> 1) & 0x55555555));
    }

    public static int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
