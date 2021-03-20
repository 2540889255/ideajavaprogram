package com.aynu.test.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 *杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class letcode45 {

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(1);
        System.out.println(lists.size());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        if (numRows<1) {
            return lists;
        }
        List<Integer> yestList=new ArrayList<>(1);
        yestList.add(1);
        lists.add(yestList);
        if (numRows==1) {
            return lists;
        }
        List<Integer> afterList = new ArrayList<>();
        afterList.add(1);
        afterList.add(1);
        lists.add(afterList);
        List<Integer> list;
        for (int i = 0; i < numRows-2; i++) {

            list=new ArrayList<>();
            list.add(1);
            for (int j = 1; j < afterList.size(); j++) {
                list.add(afterList.get(j)+afterList.get(j-1));
            }
            list.add(1);
            afterList=list;
            lists.add(list);
        }
        return lists;
    }
}
