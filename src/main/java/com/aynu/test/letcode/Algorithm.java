package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

/**
 * @author admin
 */
public class Algorithm {

    public static void main(String[] args) {
        Algorithm algorithm=new Algorithm();
        int sums = algorithm.sums(5);
        System.out.println(sums);
    }
    @Test
    public void testmax(){
        int [] ins ={1,0,3,4,10,6,7};
        int max = max(ins, ins.length - 1);
        System.out.println(max);
    }

    @Test
    public void main() {

        Algorithm algorithm=new Algorithm();
        int [] ins ={1,2,3,4,5,6,7};
        int sums=0;
        int sum = algorithm.sum(ins, ins.length-1,sums);
        System.out.println(sum);


        /*int sums = sums(3);
        System.out.println(sums);*/
    }

    public  int sum(int [] ins,int legth,int sums){

        if (legth==0){
            return ins[0];
        }else {
            return sums=ins[legth]+sum(ins,legth-1,sums);
        }

    }

    public int sums(int x){
        if (x==0) {
            return 0;
        }else {
            return x += sums(x - 1);
        }

    }

    public int max(int[] nums,int length){

        if (length==1){
            return Math.max(nums[1],nums[0]);
        }else {
            return Math.max(nums[length],max(nums,length-1));
        }
    }
    public static int sum;
}
