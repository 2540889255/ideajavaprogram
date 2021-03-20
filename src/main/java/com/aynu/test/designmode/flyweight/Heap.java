package com.aynu.test.designmode.flyweight;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 15 9:38
 * @Description : com.aynu.test.designmode.flyweight
 * @Version 1.0
 */
public class Heap implements Share{

    String name;

    public Heap(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }

    /**
     *
     **/
    @Test
    public void test() {

    }
}
