package com.aynu.test.testthread;

/**
 * @author admin
 */
public class ThreadStartDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Dog());

        thread.start();
        thread.join();
        /*Dog dog=new Dog();
        dog.run();*/
        while (true){
            Thread.sleep(1000);
            System.out.println("主线程正在运行");

        }

    }

}


class Dog implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am a dog");

        }
    }
}
