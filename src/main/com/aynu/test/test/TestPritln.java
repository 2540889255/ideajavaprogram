package main.com.aynu.test.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestPritln {

    public void println(String name){
        System.out.println(name);
    }


    public static void main(String[] args) {
        TestPritln test=new TestPritln();

        test.println("时间");

        Set set=new HashSet();
        set.add(1);
        ArrayList list=new ArrayList();
        HashMap hashMap=new HashMap();
    }
}
