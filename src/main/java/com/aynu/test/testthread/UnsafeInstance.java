package com.aynu.test.testthread;



import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author admin
 */
public class UnsafeInstance {

    public static Unsafe reflectGetUnsafe(){
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
