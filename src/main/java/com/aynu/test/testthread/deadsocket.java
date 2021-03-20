package com.aynu.test.testthread;

public class deadsocket {

    static  class Person{
        private final String name;

        public Person(String name){
            this.name=name;
        }
        public String getName(){
            return this.name;
        }

        public  synchronized  void bow(Person bower){
            System.out.println("当前弯腰的是"+bower.getName());
            bower.backbow(this);
        }

        public synchronized  void backbow(Person bower){
            System.out.println("当前回背的是"+bower.getName());

        }
    }


    public static void main(String[] args) {
        Person zhang=new Person("张三");
        Person li=new Person("李四");
        new Thread(new Runnable() {
            @Override
            public void run() {
                zhang.bow(li);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.bow(zhang);
            }
        }).start();
    }
}
