package com.aynu.test.testinterfaces;

public class testclass implements testinterface,testinterface2{
    @Override
    public void menthed() {

    }

    @Override
    public void menthed2() {

    }

    @Override
    public void getName() {

    }


    public static void main(String[] args) {
        testclass test=new testclass();
        test.getName();
    }
}
