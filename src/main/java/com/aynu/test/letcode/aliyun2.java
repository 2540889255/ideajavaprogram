package com.aynu.test.letcode;

import java.util.Deque;
import java.util.LinkedList;

public class aliyun2 {


   /* public static void main(String[] args) {
        int [][] tree ={{0,1,4},{0,2,7}};
        System.out.println(tree[0][1]);
    }*/

    public static void main(String[] args) {
        int [] list={1,3,4,2};
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < list.length; i++) {


        }

    }

    public void compare(Deque<Integer> deque,int value){
        if (value <deque.getFirst()){
            deque.addFirst(value);
        }if (value==1){

        }
    }
}
