package com.aynu.test.letcode;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class letcode11 {

    public static void main(String[] args) {


        rotate();

    }

    public static void rotate() {
        int[][] matrix= {
                {15,13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7,10,11}
        };

        int length= matrix.length;
        int template=0;
        for (int i = 0; i < length; i++) {

            for (int j = i; j < length; j++) {
                if (i!=j){
                    template=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=template;
                }
            }
        }
        System.out.println(1);
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length/2; j++) {
                template=matrix[i][j];
                matrix[i][j]=matrix[i][length-j-1];
                matrix[i][length-j-1]=template;
            }
        }

        return;

    }
}
