package com.aynu.test.letcode;

import java.util.Arrays;
import java.util.Vector;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Letcode6 {


    public static void main(String[] args) {

/*
      int [] list={7,9,9};


        int size=list.length-1;

        list[size]+=1;

        for (int i = size; i >= 0 ; i--) {

            if (list[i]>=10){
                list[i]=0;
                list[i-1]+=1;
            }
        }
        Arrays.stream(list).forEach(System.out::print);


        Vector<Integer> vector=new Vector<Integer>();
        vector.add(0,1);
        vector.add(0,2);
        vector.add(0,3);
        vector.add(0,4);
        int size=vector.size()-1;

        vector.set(size, vector.get(size)+1);
        for (int i = size; i >=0 ; i--) {
            if (vector.get(i) >=10){
                vector.set(i,0);
                if (i-1<0){
                    vector.insertElementAt(0,1);
                }else {
                    vector.set(i-1, vector.get(i-1)+1);
                }

            }
        }

        vector.stream().forEach(System.out::print);
        /*int [] last=new int[size+1];*/
        Letcode6 letcode6=new Letcode6();
        letcode6.change();
    }


    public int[] change(){
        int [] list={9,9,9};

        int size=list.length-1;
        int [] newList=new int[size+2];
        list[size]+=1;

        for (int i = size; i >= 0 ; i--) {

            if (list[i]>=10){
                list[i]=0;
                if (i-1<0){
                    newList[0]=1;
                    for (int j = 0; j < list.length; j++) {
                        newList[j+1]=list[i];
                    }
                }else {
                    list[i-1]+=1;
                }

            }

        }
        if (newList[0]==1){
            return newList;
        }
        return list;


    }
}
