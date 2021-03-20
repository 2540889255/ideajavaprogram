package com.aynu.test.letcode;

import com.aynu.test.designmode.FactoryMethodSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther: LC
 * @Date : 2021 03 05 11:09
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Letcodesward13 {

     int  m;

     int n;

     int k;
    /*
    * 解题思路，首先是底部递归遍历，然后知道她超出规定的条件，然后＆横向遍历，对每一个节点，都要先进行底部遍历，
    *
    *
    * 递归终止条件：下一个节点超出数组，右边的结点超出数组，值超出匹配值
    *
    * 使用辅助记录遍历过的数组
    *
    *
    * 针对坐标值，
    * */
    @Test
    public void test(){
       movingCount(1,2,1);
    }

    public int movingCount(int m, int n, int k) {

        //这里将HashSet优化为一个数组，使用数组的值进行判断是否到达过
        //HashSet<String> hashSet=new HashSet();
        boolean[][]  arrays=new boolean[m][n];
        this.m=m;
        this.n=n;
        this.k=k;
        System.out.println(dfs(0, 0, 0,0, arrays));
        return 1;
    }

    public  int dfs(int x,int y,int sumx,int sumy,boolean[][] arrays){
        /*终止条件*/
        if ( x>= m || y>= n||sumx+sumy>k||arrays[x][y]){
            return 0;
        }
        System.out.println(x+""+y);
        arrays[x][y]=true;

        return 1+dfs(x+1,y,(x+1)%10==0?sumx-8:sumx+1,sumy,arrays)+dfs(x,y+1,sumx,(y+1)%10==0?sumy-8:sumy+1,arrays);
    }


    /*计算当前坐标的和*/
    public  int count(int x,int y){
        int sum=0;
        while (x>0){
            sum+=x%10;
            x=x/10;
        }
        while (y>0){
            sum+=y%10;
            y=y/10;
        }
        return sum;
    }



    @Test
    public void test2(){
        show(0,0);
    }
    public static void show(int x,int xm){
        System.out.println(x+"   "+xm);
        show(x+1,(x+1)%10==0?xm-8:xm+1);
    }
}
