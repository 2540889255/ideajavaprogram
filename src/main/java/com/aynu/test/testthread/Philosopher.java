package com.aynu.test.testthread;

/**
 * @Auther: LC
 * @Date : 2021 03 02 21:58
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class Philosopher {

    public static void main(String[] args) {
        T t=new T();

        R r1=new R(t,1);
        R r2=new R(t,2);
        R r3=new R(t,3);
        R r4=new R(t,4);

        Thread thread1=new Thread(r1);
        Thread thread2=new Thread(r2);
        Thread thread3=new Thread(r3);
        Thread thread4=new Thread(r4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }



}

class T {
    boolean state=true;
}

class R implements Runnable{

    T t;

    int id;
    public R(T t,int id) {
        this.t=t;
        this.id=id;
    }

    @Override
    public void run() {

        while (true){
            System.out.println("i am "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (id==2){
                t.state=false;
                System.out.println("i am 2 state is change");
            }
            if (!t.state){
                System.out.println("i am "+Thread.currentThread().getName()+"the state is change");
                return;
            }

        }
    }
}