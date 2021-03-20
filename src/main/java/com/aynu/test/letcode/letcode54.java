package com.aynu.test.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * @author admin
 */
public class letcode54 {


    public static void main(String[] args) {
        int[][] matrix= {
                {1,0}
        };
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColHaveZero = true;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowHaveZero = true;
            }
        }

        int column=matrix[0].length;
        int row=matrix.length;
        for (int i = 1; i < row; i++) {

            for (int j = 1; j < column; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < column; i++) {
            if (matrix[0][i]==0){
                for (int j = 1; j < row; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0]==0){
                for (int j = 1; j < column; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        /*if (matrix[0][0]==0){
            for (int i = 0; i < column; i++) {
                matrix[0][i]=0;
            }
            for (int i = 0; i < row; i++) {
                matrix[i][0]=0;
            }
        }*/
        for(int i = 0; i < matrix.length; i++) {
            if (isFirstColHaveZero) {
                matrix[i][0] = 0;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if (isFirstRowHaveZero) {
                matrix[0][j] = 0;
            }
        }


        System.out.println(1);
    }

    public static void setZeroes1(int[][] matrix) {

        int column=matrix[0].length;
        int row=matrix.length;
        int positionColumn=0;
        int positionRow=0;

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {
                if (matrix[i][j]==0){
                    map.put(i,j);
                }
            }
        }

        for (int i = 0; i < map.size()-1; i++) {
            Integer integer = map.get(i);

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=0;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][integer]=0;
            }

        }

        System.out.println(1);
    }


}
