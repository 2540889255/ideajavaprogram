package com.aynu.test.testthread;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: LC
 * @Date : 2021 02 15 11:15
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class ThreadWait {

    Logger logger= LoggerFactory.getLogger(ThreadWait.class);

    public static void main(String[] args) {


        ReentrantLock lock=new ReentrantLock();
        Number number=new Number();

        Thread thread=new Thread(
                () ->{
                    for (int i = 0; i < 200; i++) {

                        number.increase();
                        /*try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
        );

        Thread thread1=new Thread(
                () ->{
                    for (int i = 0; i < 200; i++) {
                        number.decrease();

                        /*try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/

                    }
                }
        );

        thread.start();
        thread1.start();
        /*Number number=new Number();

        Thread product=new Thread(new Products(number));
        Thread consumer=new Thread(new Consumers(number));
        consumer.start();
        product.start();*/
    }



    @Test
    public void Test(){




    }

}


class Number{

    Logger logger= LoggerFactory.getLogger(ThreadWait.class);

    int number =200;

    public synchronized   void increase(){

        logger.info(() -> "当前的number数值为"+number+"增加为"+(++number));
/*
        System.out.println(Thread.currentThread().getName()+"当前的Number数量增加为"+number++);
*/
    }

    public  synchronized    void decrease(){
        logger.info(() -> "当前的number数值为"+number+"消耗为"+(--number));

/*
        System.out.println(Thread.currentThread().getName()+"当前的Number数量减少为"+number--);
*/
    }
}


class Products implements Runnable{

    Number number;


    public Products(Number number) {
        this.number = number;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            number.increase();
            /*try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}

class Consumers implements Runnable{

    Number number;

    public Consumers(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            number.decrease();
            /*try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}
