package main.com.aynu.test.testthread;

import java.util.Random;

public class Product implements  Runnable{

    public  Drop drop;

    public Product(Drop drop) {
        this.drop=drop;
    }



    @Override
    public void run() {
        String [] string={"消息一","消息二","消息三","消息四"};
        Random random=new Random();
        for (int i=0;i<string.length;i++){
            try {
                drop.put(string[i]);
                try {
                    Thread.sleep(random.nextInt(5000));
                }catch (Exception e){
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            drop.put("over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
