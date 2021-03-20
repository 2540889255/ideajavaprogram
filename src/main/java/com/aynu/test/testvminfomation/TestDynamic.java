package com.aynu.test.testvminfomation;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class TestDynamic {

    static class  A{
        public void println(String string){
            System.out.println("println"+string);
        }

        public void show(String string){
            System.out.println("showMethod"+string);
        }
    }


    public static void main(String[] args) throws Throwable {
        Object o= System.currentTimeMillis()%2==0?System.out : new A();
        getMenth(o).invokeExact("icyfenix");
    }
    public static MethodHandle getMenth(Object o) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        // = MethodHandles.lookup().findVirtual(o.getClass(), "println", methodType).bindTo(o);
        MethodHandle handle=MethodHandles.lookup().findVirtual(o.getClass(),"show",methodType).bindTo(o);
        handle.invoke("show方法");
        return MethodHandles.lookup().findVirtual(o.getClass(),"println",methodType).bindTo(o);
    }


}
