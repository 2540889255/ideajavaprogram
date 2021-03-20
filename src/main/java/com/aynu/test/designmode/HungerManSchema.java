package com.aynu.test.designmode;

import javax.crypto.spec.PSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉单例模式
 */
public class HungerManSchema {

    private static HungerManSchema hungerManSchema=new HungerManSchema();
    public  static int a=0;
    private HungerManSchema(){

    }

    public static HungerManSchema getInstance(){
        a++;
        System.out.println(a);
        return hungerManSchema;
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        /*HungerManSchema hungerManSchema=new HungerManSchema();
        hungerManSchema.getInstance();
        HungerManSchema hungerManSchema1=new HungerManSchema();
        hungerManSchema.getInstance();*/
        HungerManSchema hungerManSchema=new HungerManSchema();
        Field fields = hungerManSchema.getClass().getDeclaredField("hungerManSchema");
        fields.setAccessible(true);

        Object o = fields.get(hungerManSchema);
        System.out.println(o.hashCode());
        System.out.println("----------");
        HungerManSchema hungerManSchema1=new HungerManSchema();
        Field field1s = hungerManSchema1.getClass().getDeclaredField("hungerManSchema");
        field1s.setAccessible(true);

        Object o1 = fields.get(hungerManSchema1);
        System.out.println(o.hashCode());
        System.out.println("--------------------------");
        //后面两个的哈希值不一样 因为反射出来的 构造方法使用了两次  尽管构造方法是 私有的
        Constructor<HungerManSchema> constructors = HungerManSchema.class.getDeclaredConstructor();
        constructors.setAccessible(true);
        HungerManSchema manSchema = constructors.newInstance();
        System.out.println(manSchema.hashCode());
        Constructor<HungerManSchema> constructor2 = HungerManSchema.class.getDeclaredConstructor();
        constructor2.setAccessible(true);
        HungerManSchema manSchema2 = constructor2.newInstance();
        System.out.println(manSchema2.hashCode());
    }
}
