package main.com.aynu.test.test;

import java.util.Arrays;

/**插入排序
 * @author admin
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] list ={9,3,1,4,4,8,7};

        for (int i = 1; i < list.length; i++) {
                swap(i,list);
        }
        Arrays.stream(list).forEach(System.out::print);
    }

    public static void swap(int i,int[] list){
        int star = i-1;
        if (star>=0){
            if (list[i]<list[i-1]){
                int template=list[i-1];
                list[i-1]=list[i];
                list[i]=template;
                swap(i-1,list);
            }

        }
    }
}
