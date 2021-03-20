package com.aynu.test.testthread;



public class test extends Thread{


    @Override
    public void run() {
        System.out.println("this is run medth");
        while (true){
            System.out.println(1);
        }
        /*while (!isInterrupted()){
            System.out.println("the thread is interrupt");
        }*/
    }

    public static void main(String[] args) {
        test test=new test();
        test.start();
        test.interrupt();


        /*try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("this is having problem");
        }
        test.interrupt();*/
    }
}
