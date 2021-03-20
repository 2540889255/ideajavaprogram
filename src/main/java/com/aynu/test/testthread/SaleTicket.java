package com.aynu.test.testthread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 14 19:06
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        },"A").start();
        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}



/*资源类*/
class Ticket{
    private int number=20;

    public synchronized void sale(){
        if (number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"张票"+"剩余"+number);
        }
    }
}