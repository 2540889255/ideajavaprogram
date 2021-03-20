package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 02 10 9:33
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 *
 *
 * 静态代理模式，将代理类和被代理类实现同一个接口，然后再代理类中对于被代理得的操作进行添加完善
 *
 * 线程类的对象好像也是这样的，类比于线程对象，thread实现了runable接口，然后对于实现了runnable接口的方法进行了代理处理
 *
 */
public class StaticProxy {


    public static void main(String[] args) {

        Person person=new Person();

        WeddingPerson weddingPerson=new WeddingPerson(person);

/*
        weddingPerson.marry();
*/

        WeddingPerson weddingPerson1=new WeddingPerson(()->{
            System.out.println("我要结婚");
        });
        weddingPerson1.marry();



    }
}



interface Marry{

    public void marry();
}

class Person implements Marry{

    @Override
    public void marry() {
        System.out.println("我是人我结婚了");
    }
}

class WeddingPerson implements Marry{

    private Marry marry;

    public WeddingPerson(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void marry() {
        before();
        marry.marry();
        after();
    }

    public void before(){
        System.out.println("这是结婚前的操作");
    }

    public void after(){
        System.out.println("这是结婚后的操作");
    }
}

