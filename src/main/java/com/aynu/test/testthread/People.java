package com.aynu.test.testthread;

import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;

import java.util.Random;

public class People implements Runnable{
    private Bank bank;

    public People(Bank bank){
        this.bank=bank;
    }

    @Override
    public void run() {
        Random random=new Random();
        for (int i=0;i<=20;i++){
            //this.putmoney(random.nextInt(100));
            this.putmoney(100);
           /* try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        /*for (int i=0;i<=20;i++){
            //this.getmoney(random.nextInt(100));
            this.getmoney(100);
        }*/
    }

    public  void getmoney(double getmoney){
        String threadname=Thread.currentThread().getName();
        System.out.println("我是"+threadname+":我现在获取了"+getmoney+"元");
        this.bank.remove(getmoney);

    }

    public  void  putmoney(double putmoney){
        String threadname=Thread.currentThread().getName();
        System.out.println("我是"+threadname+":我现在存入了"+putmoney+"元");
        this.bank.add(putmoney);

    }
}
