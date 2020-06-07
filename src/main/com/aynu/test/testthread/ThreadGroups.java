package main.com.aynu.test.testthread;


import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Random;

/**
 * 测试ThreadGroup
 *
 * Thread树形结构
 */
public class ThreadGroups extends ThreadGroup {



    public ThreadGroups(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("the thread %s has a exception",t.getId());

        e.printStackTrace(System.out);

        System.out.println("Terminating the rest of thread ");

        interrupt();
    }

    public static class Task implements Runnable{
        @Override
        public void run() {

            int  number =1000;

            while (true){
                Random random=new Random();

                int result=number*random.nextInt(10000000);
                if (Thread.currentThread().isInterrupted()){
                    System.out.printf("thread %sinterputer \n",Thread.currentThread().getId());
                    return;
                }
            }


        }
    }

    public static void main(String[] args) {

        ThreadGroups threadGroup=new ThreadGroups("myThreadGroup");

        int threadNumber = Runtime.getRuntime().availableProcessors();

        Task task=new Task();

        for (int i = 0; i < threadNumber ; i++) {
            Thread thread=new Thread(threadGroup,task);
            thread.start();
        }
        //显示ThreadGroup信息

        Thread[] thread =new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(thread);

        for (int i = 0; i < thread.length; i++) {
            System.out.printf("当前线程名字:%s ,当前线程%s \n",thread[i].getName(),thread[i].getState());

        }


    }
}
