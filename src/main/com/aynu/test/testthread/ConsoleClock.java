package main.com.aynu.test.testthread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 这个是测试TimeUtil的程序
 */
public class ConsoleClock {


    static class Console implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                System.out.println("the clock is interrupted");
            }
            }
        }
    }


    public static void main(String[] args) {
        Console console=new Console();
        Thread thread=new Thread(console);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        ThreadGroups threadGroup=new ThreadGroups("myGroup");

    }
}
