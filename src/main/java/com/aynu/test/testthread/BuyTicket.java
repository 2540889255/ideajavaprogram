package com.aynu.test.testthread;

/**
 * @author admin
 * @Auther: LC
 * @Date : 2021 02 14 12:46
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class BuyTicket {

    int ticketNumber =10;

    public static void main(String[] args) {

        BuyTicket buyTicket=new BuyTicket();
        Buyer buyer=new Buyer(buyTicket,"小黑");
        Buyer buyer2=new Buyer(buyTicket,"小黄");
        Buyer buyer3=new Buyer(buyTicket,"小兰");

        Thread thread=new Thread(buyer);
        Thread thread1=new Thread(buyer2);
        Thread thread2=new Thread(buyer3);
        thread.start();
        thread1.start();
        thread2.start();
    }
}


class Buyer implements Runnable{

    BuyTicket buyTicket;

    String name;

    public Buyer(BuyTicket buyTicket,String name) {
        this.buyTicket = buyTicket;
        this.name=name;
    }

    @Override
    public void run() {

        while (true){
            if (buyTicket.ticketNumber>0){
                buyTicket.ticketNumber--;
                System.out.println("我是"+name+"当前的票数为"+buyTicket.ticketNumber);
            }else {
                break;
            }
        }
    }
}