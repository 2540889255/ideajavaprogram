package com.aynu.test.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author admin
 */
public class TestArraysSort {



    private static TestCompare TestCompares =new TestCompare();

    public static void main(String[] args) {
        String [] arrays={"1","2","3","4","5","6"};

        Arrays.sort(arrays,TestCompares);

        Integer[] integers={1,2,3,4,56,7};
        Arrays.sort(integers,(x,y) -> x.compareTo(y));

        int [] ints={1,2,3,4,5,6};

/*
        Arrays.sort(ints,(x,y) -> String.valueOf(x).compareTo(String.valueOf(y)));
*/
        Test[] tests=new Test[5];
        Arrays.sort(tests,(x,y) -> String.valueOf(x).compareTo(String.valueOf(y)));
    }

    static class  TestCompare implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.length()-o2.length();
        }
    }

    static class Test {

    }

}
