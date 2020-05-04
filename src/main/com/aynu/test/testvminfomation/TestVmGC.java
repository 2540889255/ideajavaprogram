package main.com.aynu.test.testvminfomation;

public class TestVmGC {
    public static void main(String[] args) {
        {
            byte [] array=new byte[64*1024*1024];
        }
        int a=0;
        System.gc();

    }

}
