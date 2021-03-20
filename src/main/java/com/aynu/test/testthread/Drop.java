package com.aynu.test.testthread;



public class Drop {

    private String message;

    private Boolean empty=true;


    public synchronized String teke(){

        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty=true;
        notifyAll();
        return message;

    }

    public synchronized void put(String message) throws InterruptedException {
        while (!empty){
            wait();
        }
        empty=false;
        notifyAll();
        this.message=message;
    }
}
