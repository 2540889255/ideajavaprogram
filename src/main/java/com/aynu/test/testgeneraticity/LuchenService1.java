package com.aynu.test.testgeneraticity;

import java.util.ArrayList;
import java.util.List;

public class LuchenService1 {

    private List<Luchen> list;

    public LuchenService1(List<Luchen> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<Luchen> list=new ArrayList<>();
        LuchenService1 luchenService=new LuchenService1(list);
    }
}

