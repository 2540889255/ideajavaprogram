package com.aynu.test.testthread;

import java.util.concurrent.TimeUnit;

/**
 * 测试模拟银行的账户情况
 * @author admin
 */
public class Account {

    String name;

    double balance;

    public void setBalance(double balance) {
        this.balance = balance;

        try {
            Thread.sleep(3000);
            this.balance=1;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized double  getBalance() {
        return balance;
    }


    public static void main(String[] args) {
        Account account=new Account();
        Thread thread=new Thread(() -> account.setBalance(1000));
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(account.getBalance());

        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(account.getBalance());


    }
}
