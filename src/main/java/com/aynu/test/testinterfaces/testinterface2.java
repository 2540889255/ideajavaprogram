package com.aynu.test.testinterfaces;

/**
 * @author admin
 */
public interface testinterface2 {

    default  void getName(){
        System.out.println("this is testinterface2 getName");
    };
}
