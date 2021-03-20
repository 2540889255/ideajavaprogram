package com.aynu.test.letcode;

/**
 *
 *
 * @author admin
 */
public class letcode53 {


    public static void main(String[] args) {

        rotate();
    }

    public static void rotate() {
        int[][] matrix = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        int alength=matrix.length;
        int template=0;
        int length=1;
        for (int i = 1; i < alength; i++) {


            for (int j = 0; j < length; j++) {
                template=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=template;
            }
            length++;
        }

        for (int i = 0; i < alength; i++) {

            for (int j = 0; j < alength/2; j++) {
                template=matrix[i][j];
                matrix[i][j]=matrix[i][alength-j-1];
                matrix[i][alength-j-1]=template;
            }
        }
        System.out.println(1);
    }                                                         
}
