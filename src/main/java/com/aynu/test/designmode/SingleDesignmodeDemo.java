package com.aynu.test.designmode;

import org.apache.commons.math3.analysis.function.Sin;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: LC
 * @Date : 2021 02 19 12:01
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 */
public class SingleDesignmodeDemo {

    private static SingleDesignmodeDemo designmodeDemo=null;

    private static boolean flag=false;
    private SingleDesignmodeDemo() throws InterruptedException {
        synchronized (SingleDesignmodeDemo.class){
            if (flag==false){
                System.out.println(Thread.currentThread().getName()+"ok");
                flag=true;
            }else{
                throw new RuntimeException("请不要用反射获取单例类");
            }
        }
        System.out.println(flag);
    }


    /*懒汉式单例模式*/
    public static SingleDesignmodeDemo getInstence() throws InterruptedException {
        if (designmodeDemo==null) {
            synchronized (SingleDesignmodeDemo.class) {
                if (designmodeDemo == null) {
                    designmodeDemo = new SingleDesignmodeDemo();/*一共有三步骤，为对象在堆中开辟空间，执行对象的构造方法，初始化对象，将对象指向这个对空间*/
                }
                return designmodeDemo;
            }
        }
        return designmodeDemo;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {

        Constructor<SingleDesignmodeDemo> constructor = SingleDesignmodeDemo.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        SingleDesignmodeDemo singleDesignmodeDemo = constructor.newInstance();
        System.out.println(singleDesignmodeDemo.toString());
        SingleDesignmodeDemo singleDesignmodeDemo1 = SingleDesignmodeDemo.getInstence();
        System.out.println(singleDesignmodeDemo1.toString());
    }


    @Test
    public void test(){
        /*针对普通的单例模式*/
        /*private static SingleDesignmodeDemo designmodeDemo=null;

    private SingleDesignmodeDemo() throws InterruptedException {
            Thread.sleep(10);
            //System.out.println(Thread.currentThread().getName()+"ok");
        }


        *//*懒汉式单例模式*//*
        public static SingleDesignmodeDemo getInstence() throws InterruptedException {
            if (designmodeDemo==null){
                designmodeDemo=new SingleDesignmodeDemo();*//*一共有三步骤，为对象在堆中开辟空间，执行对象的构造方法，初始化对象，将对象指向这个对空间*//*
            }
            return designmodeDemo;
        }*/
    }
    @Test
    public void test2(){
        /*使用多线程进行双重锁*/
        /*for (int i = 0; i < 50; i++) {
            Thread thread=new Thread(()->{
                SingleDesignmodeDemo singleDesignmodeDemo = null;
                try {
                    singleDesignmodeDemo = SingleDesignmodeDemo.getInstence();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(singleDesignmodeDemo);
            });
            thread.start();
        }*/


    }

}
