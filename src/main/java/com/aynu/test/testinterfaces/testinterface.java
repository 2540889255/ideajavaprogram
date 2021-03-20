package com.aynu.test.testinterfaces;

public interface testinterface {

    int number=1;

    public void  menthed();

    public void menthed2();

    default void getName(){
        System.out.println("this is testinterface1 getName");
    };
}
