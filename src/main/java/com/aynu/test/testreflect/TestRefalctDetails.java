package com.aynu.test.testreflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 这个程序是为了进行反射详细功能的展示，使用反射对不同的类对象的详细信息内容进行反射。类对象反射的具体内容有
 * 1，构造器方法
 * 2，方法的详细信息
 * 3，field的详细信息，是目标类的详细变量
 * @author admin
 */
public class TestRefalctDetails {


    public static void main(String[] args) throws ClassNotFoundException {



        Class<?> heros = Class.forName(Hero.class.getName());
        showControduct(heros);


    }



    public static void showControduct(Class hero){


        Constructor[] declaredConstructors = hero.getDeclaredConstructors();

        for (Constructor constructor:declaredConstructors) {


            String s = Modifier.toString(constructor.getModifiers());
            System.out.println("这是constructor的modifier参数"+s);

            System.out.println("这是constructor的name"+constructor.getName());

            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("这是参数"+parameterTypes[i].getName());
            }

        }
    }

    public static void showMendth(Class hero){

    }

    public static void showField(Class hero){

    }
}
