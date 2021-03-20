package com.aynu.test.testvminfomation;

/**
 * VM 参数  -verbose：gc -Xms20M -Xmx20M -Xmn10M  -XX：+PrintGCDetails -XX:SurvivorRatio=8
 *
 * -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 */
public class testAllocation {

    static final int _1MB=1024*1024;

    public static void testAllocations(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        /*allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[1*_1MB];*/
        allocation4=new byte[17*_1MB];
    }

    public static void main(String[] args) {
        testAllocations();
    }
}
