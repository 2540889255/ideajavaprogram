package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class letcode9 {

    public static void main(String[] args) {
         char[][] arrays= {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '6', '.'},
                {'2', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        isValidSudoku(arrays);
    }

    public static boolean isValidSudoku(char[][] board) {

        HashMap hashMap=new HashMap();

        int multiple=3;

        int size;
        int d=0;
        /*for (int all = 0; all < 3; all++) {
            for (int i = all*3+0; i < all*3+3; i++) {
                int legth=board[i].length;
                for (int j = all*3+0; j < all*3+3; j++) {
                    char a=board[i][j];
                    if (a!='.'){
                        size=hashMap.size();
                        hashMap.put(a,a);
                        if (size==hashMap.size()){
                            return false;
                        }
                    }

                    System.out.println(d);
                    d++;
                }
            }
            hashMap=new HashMap();
        }*/


            for (int width = 0; width < 3; width++) {

                for (int i = width*3+0; i < width*3+3; i++) {
                    hashMap=new HashMap();
                    int legth=board[i].length;
                    for (int height = 0; height < 3; height++) {
                        for (int j = height * 3 + 0; j < height * 3 + 3; j++) {
                            System.out.println(i+","+j);
                            char a=board[i][j];
                            if (a!='.'){
                                size=hashMap.size();
                                hashMap.put(a,a);
                                if (size==hashMap.size()){
                                    return false;
                                }
                            }

                            System.out.println(d);
                            d++;
                        }
                    }
                }

            }



        int a=1;
        /*System.out.println(board.length);
        System.out.println(board[1].length);
        for (int i = 0; i < board.length; i++) {

        }*/





        return true;
    }

    @Test
    public void show1(){

        char[][] arrays= {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '6', '.'},
                {'2', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        int size;

        for (int heighs = 0; heighs < 3; heighs++) {
            for (int rows = 0; rows < 3; rows++) {
                HashMap rowhashMap=new HashMap();
                for (int i = rows*3+0; i < rows*3+3; i++) {

                    for (int j = heighs*3+0; j < heighs*3+3; j++) {
                        char a=arrays[i][j];
                        if (a!='.'){
                            size=rowhashMap.size();
                            rowhashMap.put(a,a);
                            if (size==rowhashMap.size()){

                                System.out.println("false");
                            }
                        }


                    }
                    System.out.println();
                }
            }
        }


        int heightsize=0;
        for (int i = 0; i < arrays.length; i++) {
            HashMap heighthashMap=new HashMap();
            for (int j = 0; j < arrays[i].length; j++) {
                char a=arrays[i][j];
                if (a!='.'){
                    size=heighthashMap.size();
                    heighthashMap.put(a,a);
                    if (size==heighthashMap.size()){
                        System.out.println("false");
                    }
                }

            }
        }

        int widthsize=0;

        for (int i = 0; i < arrays.length; i++) {
            HashMap widththashMap=new HashMap();
            for (int j = 0; j < arrays[i].length; j++) {
                char a=arrays[j][i];
                if (a!='.'){
                    size=widththashMap.size();
                    widththashMap.put(a,a);
                    if (size==widththashMap.size()){
                        System.out.println("false");
                    }
                }

            }
        }


    }
}
