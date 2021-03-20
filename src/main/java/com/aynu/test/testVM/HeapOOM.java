package com.aynu.test.testVM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{

    }
    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
