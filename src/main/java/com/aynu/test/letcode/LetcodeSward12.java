package com.aynu.test.letcode;

import com.aynu.test.Until.LuchenArraysUntil;

/**
 * @Auther: LC
 * @Date : 2021 02 28 12:44
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 */
public class LetcodeSward12 {


    /*
    * 思路
    * 首先遍历大的数组，
    * 然后将要匹配的数组传进去，
    * 然后进行判断，
    * 如果判断是相同的，判断他的上下左右是否是，接下来的字符，然后以此类推，递归进入成功匹配的数组位置，，遍历的时候遍历完一个要将数组变为空值，
    *
    * */
    public static void main(String[] args) {
        char[][] matrix= {
                {'a','b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };

    }

    public static boolean exist(char[][] board,String word){

        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board,words,i,j,0)) {
                    return true;
                };
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,char[] words,int i,int j,int wordPosition){
        //如果超出数组的边界
        if (i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=words[wordPosition]){
            return false;
        }

        //判断是否到了数组的最后一个
        if (wordPosition==words.length-1){
            return true;
        }
        board[i][j]='\0';
        boolean result=(dfs(board,words,i+1,j,wordPosition+1)|| dfs(board,words,i-1,j,wordPosition+1)||
                        dfs(board,words,i,j+1,wordPosition+1)|| dfs(board,words,i,j-1,wordPosition+1));

        //这一步，是作用于比如A,左右两个都符合下一个值，然后他们递归，然后他们俩有一个递归，递归失败，那个需要把递归后的修改的值再修改回来，
        //防止，干扰另一个方向寻求值。
        board[i][j]=words[wordPosition];
        return result;
    }



    public static boolean exists(char[][] board, String word) {

        char[] chars = word.toCharArray();
        char head=chars[0];

        int[][] position=new int[chars.length*10][2];
        int positonhead=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==head){
                    position[positonhead][0]=i;
                    position[positonhead][1]=j;
                    positonhead++;
                }
            }
        }

        LuchenArraysUntil.PrintArraysTwo(position);
        return true;
    }

    public void search(char[] board,String word,int x,int y){

    }


}
