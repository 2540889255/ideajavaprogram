package com.aynu.test.letcode;


public class aliyun {


    public static void main(String[] args) {

        int[] A= {1,2,-3,4,5,-6,12,1};
        int maxbefore=0;

        int maxafter =0;
        for (int i=0;i<A.length;i++){

            if (A[i]>=0){
                maxafter+=A[i];
            }if (i==A.length-1){
                maxbefore=max(maxafter,maxbefore);
            }
            if (A[i]<0){
                maxbefore=max(maxafter,maxbefore);
                maxafter=0;
            }
            System.out.println(maxbefore);
        }
        System.out.println(maxbefore);
    }

    public static int max(int a ,int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }


}
