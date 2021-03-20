package com.aynu.test.testthread;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin
 */
public class TestThreadWait {

    public static class EventStorage{
        private int maxSize;

        private Queue<Date> storage;

        public EventStorage() {
            this.maxSize = 10;
            this.storage = new LinkedList<>();
        }

        public synchronized void set(){
            while (storage.size()>=maxSize){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.offer(new Date());
            System.out.println("当前的消息队列中有"+storage.size());
            notify();

        }

        public synchronized void get(){
            while (storage.size()<=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String element=storage.poll().toString();
            System.out.println("get "+ storage.size()+""+element);
            notify();
        }
    }

    public static class Product implements Runnable{

        private EventStorage eventStorage;

        public Product(EventStorage eventStorage) {
            this.eventStorage = eventStorage;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                eventStorage.set();
            }
        }
    }

    public static class Consumer implements Runnable{

        private EventStorage eventStorage;

        public Consumer(EventStorage eventStorage) {
            this.eventStorage = eventStorage;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100 ; i++) {
                eventStorage.get();
            }
        }
    }

    public static void main(String[] args) {
        EventStorage eventStorage=new EventStorage();

        Product product=new Product(eventStorage);

        Consumer consumer=new Consumer(eventStorage);

        Thread productThread=new Thread(product);
        productThread.start();
        Thread consumerThread=new Thread(consumer);
        consumerThread.start();

    }
}
