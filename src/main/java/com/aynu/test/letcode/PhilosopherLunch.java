package com.aynu.test.letcode;

/**
 * @Auther: LC
 * @Date : 2021 03 02 20:16
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 */
public class PhilosopherLunch {


    public static void main(String[] args) {

        Leftchopsticks leftchopsticks1=new Leftchopsticks("筷子");


        Consumer consumer1=new Consumer(leftchopsticks1,1);
        Consumer consumer2=new Consumer(leftchopsticks1,2);
        Consumer consumer3=new Consumer(leftchopsticks1,3);
        Consumer consumer4=new Consumer(leftchopsticks1,4);
        Consumer consumer5=new Consumer(leftchopsticks1,5);


        Thread thread1=new Thread(consumer1);
        Thread thread2=new Thread(consumer2);
        Thread thread3=new Thread(consumer3);
        Thread thread4=new Thread(consumer4);
        Thread thread5=new Thread(consumer5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


}

class Leftchopsticks{

    String name;

    boolean[] state={true,true,true,true,true};
    public Leftchopsticks(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean[] getState() {
        return state;
    }

    public void setState(boolean[] state) {
        this.state = state;
    }
}

class Consumer implements Runnable{

    Leftchopsticks leftchopsticks;

    int id;

    public Consumer(Leftchopsticks leftchopsticks,int id) {
        this.leftchopsticks=leftchopsticks;
        this.id=id;
    }

    @Override
    public void run() {

        boolean[] state = leftchopsticks.getState();
        while (true){
            System.out.println("我是线程"+Thread.currentThread().getName());
            think();

            eat(state);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    public void think(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我已经思考了1秒钟了");

    }


    public void eat(boolean[] state){

        while (true){
            int yest=id-1;
            int now=id;
            if (yest==0){
                yest=4;
            }
            if (now==5){
                now=0;
            }
            System.out.println("i am waiting"+Thread.currentThread().getName());
            if (state[yest]&&state[now]){
                state[yest]=false;
                state[now]=false;
                System.out.println("我吃到饭了,我是"+id+"拿到的筷子"+yest+"  "+now);

                state[yest]=true;
                state[now]=true;

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

    }




}
