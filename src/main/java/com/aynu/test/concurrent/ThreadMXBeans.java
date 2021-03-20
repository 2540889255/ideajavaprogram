package com.aynu.test.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
public class ThreadMXBeans {


    public static void main(String[] args) {

        ThreadMXBean mxBean= ManagementFactory.getThreadMXBean();



        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                long[] deadlockedThreads = mxBean.findDeadlockedThreads();

                if (deadlockedThreads!=null){

                    ThreadInfo[] threadInfo = mxBean.getThreadInfo(deadlockedThreads);

                    for (int i = 0; i < threadInfo.length; i++) {
                        System.out.println(threadInfo[i].toString());
                    }
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
        /*ScheduledExecutorService service= Executors.newScheduledThreadPool(1);

        service.scheduleAtFixedRate(runnable,5L,10L, TimeUnit.SECONDS);*/
    }




}
