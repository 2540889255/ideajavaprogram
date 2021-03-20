package com.aynu.test.testthread;

/**
 *
 */
public class TestThreadInterrupt extends Thread {

    static  volatile  Boolean status;

    @Override
    public void run() {
        System.out.println("the medth is in here");
        try {
            while (true) {
                System.out.println("the thread is running");
                Thread.sleep(500);
            }

        }catch (InterruptedException e){
            System.out.println("the program is stop");
        }finally {

        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new TestThreadInterrupt();

        boolean result=thread.isInterrupted();
        System.out.println(result);
        thread.start();
        boolean result1=false;
        Thread.State state = thread.getState();
        System.out.println("当前线程的状态是"+state);

        try {
            Thread.sleep(6000);
            thread.interrupt();
        }catch (Exception e){

        }finally {
            result1 = thread.isInterrupted();
        }
        System.out.println(result1);
    }

}


/*   thread.run();*/
        /*TestThreadInterrupt.status = thread.isInterrupted();
        System.out.println(status);
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.interrupt();
        Thread.sleep(5000);
        TestThreadInterrupt.status = thread.isInterrupted();
        System.out.println(status);*/
        /*while (!thread.isInterrupted()){

            System.out.println(1);
            Thread.sleep(1000);
            thread.interrupt();
        }*/