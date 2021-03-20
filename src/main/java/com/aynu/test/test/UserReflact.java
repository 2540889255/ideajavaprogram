package com.aynu.test.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: LC
 * @Date : 2021 02 11 11:12
 * @Description : com.aynu.test.test
 * @Version 1.0
 */
public class UserReflact {


    public static void main(String[] args) throws Exception {

        Class<?> userClass = Class.forName("com.aynu.test.test.User");

        //测试user的属性
        System.out.println("这是User类的所有属性");
        Field[] fields = userClass.getFields();
        for (Field field:fields
             ) {
            System.out.println("共有属性"+field);
        }
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field f:declaredFields
             ) {
            System.out.println("公有和私有变量"+f);
        }

        System.out.println("这是User类的所有方法");
        Method[] methods = userClass.getMethods();
        for (Method method:methods
             ) {
            System.out.println("所有方法"+method);//这个会带有父类的方法
        }
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method m :declaredMethods
            ) {
            System.out.println("所有方法2"+m);//
        }


        System.out.println("这是User类的所有构造方法");


        System.out.println("===========================");

        Constructor<?> constructor = userClass.getConstructor();
        Object o = constructor.newInstance();
        User user=(User)o;

        Field say = userClass.getField("say");
        say.set(user,"hello");
        //设置公有的属性
        System.out.println(user.getSay());

        //设置私有的属性
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"luchen");
        System.out.println(user.getName());

        //userClass.getMethod();



    }
}
