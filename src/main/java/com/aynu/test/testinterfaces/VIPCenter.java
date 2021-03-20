package com.aynu.test.testinterfaces;

import java.net.http.HttpRequest;

public class VIPCenter extends Thread{

    static volatile  int a=0;


    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            a++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            VIPCenter thread=new VIPCenter();
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(VIPCenter.a);
    }
}


class User{
    String name;
}
class  VIPUer extends User{
    int number;
}

class DogVIPUser extends User{



}