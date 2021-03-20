package com.aynu.test.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 赛马游戏
 * @author admin
 */
public class HorseRace implements Runnable{

    int length=75;

    public static Horse1[] horses=new Horse1[7];


    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,new HorseRace());

        for (int i = 0; i < 7; i++) {

            Horse1 horse=new Horse1(cyclicBarrier);
            horses[i]=horse;
            exec.execute(horse);
        }
    }

    @Override
    public void run() {
        StringBuilder s = new StringBuilder();
        //打印赛道边界
        for(int i = 0; i < 75; i++) {
            s.append("=");
        }
        System.out.println(s);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 7; i++) {
            String trace = horses[i].trace();
            System.out.println(trace);
        }
        for (int i = 0; i < 7; i++) {
            String trace = horses[i].trace();
            if (trace.length()>=60){
                System.out.println(horses[i].id+"is won");
            }
            exec.shutdown();
            return;
        }


    }


}

class Horse1 implements Runnable{

    public static int base=0;

    public final  int id=base++;

    public CyclicBarrier cyclicBarrier;

    public volatile boolean notover=true;

    public Random random=new Random();

    StringBuffer stringBuffer=new StringBuffer();

    public Horse1() {
    }

    public Horse1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier=cyclicBarrier;
    }


    @Override
    public void run() {

        while (notover){
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public String trace(){
        int i = random.nextInt(3)+1;

        for (int j = 0; j < i; j++) {
            stringBuffer.append("*");
        }

        return stringBuffer.toString();
    }

    public void Test(){
        for (int i = 0; i < 2; i++) {
            Thread thread=new Thread(new Horse1());
        }
    }
}


