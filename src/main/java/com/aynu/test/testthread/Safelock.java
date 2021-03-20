package com.aynu.test.testthread;



import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safelock {

    static class Person{
        private final  String name;
        private final Lock lock=new ReentrantLock();//创建一个可重入得互斥锁

        public Person(String name){
            this.name=name;
        }
        public String getName(){
            return this.name;
        }
        public boolean impendingBow(Person person){
            boolean mylock=false;
            boolean yourlock=false;

            try {
                mylock=lock.tryLock();//在调用时  锁未被另一个线程保持的情况下 才获取该锁
                yourlock=person.lock.tryLock();
            }finally {
                if (!(mylock&&yourlock)){
                    if (mylock){
                        lock.unlock();
                    }
                    if (yourlock){
                        person.lock.unlock();
                    }
                }
            }
            return mylock&&yourlock;
        }
        public void bow(Person person){
            if (impendingBow(person)){
                try {
                    System.out.println(this.name+"向"+person.getName()+"鞠躬了");
                    person.bowback(person);

                }finally {
                    lock.unlock();//重点
                    person.lock.unlock();
                }
            }else {
                System.out.println(this.name+"正在向我鞠躬但他已经看见我正在向他鞠躬"+person.getName());
            }
        }

        public void bowback(Person person){
            System.out.println(this.name+"已经向我鞠躬回敬");
        }
    }

    static class Bowloop implements Runnable{
        private Person boss;
        private Person farmer;
        public Bowloop(Person boss,Person farmer){
            this.boss=boss;
            this.farmer=farmer;
        }

        @Override
        public void run() {
            Random random=new Random();
            for (;;){
                    try {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boss.bow(farmer);
            }
        }

        public static void main(String[] args) {
            Person zhang=new Person("张三");
            Person li =new Person("李四");

            new Thread(new Bowloop(zhang,li)).start();
            new Thread(new Bowloop(li,zhang)).start();


        }
    }




}
