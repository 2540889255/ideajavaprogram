package com.aynu.test.testlanmbda;

public class Operation {


    public static void main(String[] args) {

        ShowService showService=() -> System.out.println();
        /*showService.run(8,9);*/

        Show show=new Show() {
            @Override
            public void run () {

            }
        };
        Thread thread= new Thread( () -> System.out.println(1));
        Runnable runnable=() -> System.out.println(1);
    }
}
