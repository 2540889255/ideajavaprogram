package com.aynu.test.testthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: LC
 * @Date : 2021 02 14 19:15
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class SaleTicketByLock {


    public static void main(String[] args) {
        TicketLock ticket=new TicketLock();

        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
            }

        },"A").start();
        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()-> {
            for (int i = 0; i < 9; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}



/*资源类*/
class TicketLock{

    ReentrantLock lock=new ReentrantLock();

    private int number=20;

    public void sale(){
        try {
            lock.lock();
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"张票"+"剩余"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}