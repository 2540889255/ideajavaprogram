package main.com.aynu.test.testVM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存
 */
public class DirectMemoryOOM {

    private  static final int _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field fields = Unsafe.class.getDeclaredFields()[0];
        fields.setAccessible(true);
        Unsafe unsafe=(Unsafe) fields.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
