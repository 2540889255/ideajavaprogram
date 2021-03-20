package com.aynu.test.testthread;

public class testthread implements Runnable {
    public static int a;

    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            a=a+1;
            //System.out.println(a);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /*(new Thread(new testthread())).start();


        String [] string={"1","2","3"};

        for (String s:string
             ) {
            Thread.sleep(1000);
            System.out.println(s);
        }
        for (int i=0;i<string.length;i++){
            Thread.sleep(1000);
            System.out.println(string[i]);
        }
*/

        Runnable r=new testthread();

        Thread t=new Thread(r);

        t.start();
        t.join();
        System.out.println(a);



    }
    /**
     * 当前的测试是为了检测线程之中 join方法 在当前线程之中 加入了新的线程 线程之中 可能出现
     */

}
