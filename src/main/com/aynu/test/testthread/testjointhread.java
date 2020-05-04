package main.com.aynu.test.testthread;

public class testjointhread {


    public static void prite(String string){
        String threadname=Thread.currentThread().getName();
        System.out.println("当前线程的名字是"+threadname+"当前的运行状态是"+string);
    }

    public static  class quickthread implements  Runnable{

        @Override
        public void run() {
            String [] strings={"消息一","消息二","消息三","消息四"};
            try {
                for (int i=0;i<strings.length;i++){
                    Thread.sleep(4000);
                    prite(strings[i]);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        prite("启动子类线程");
        long start=System.currentTimeMillis();
        Thread t=new Thread(new quickthread());
        t.start();
        while (t.isAlive()){
            prite("继续等待");
            t.join(1000);
        }
        System.out.println("子线程结束了");



    }
}
