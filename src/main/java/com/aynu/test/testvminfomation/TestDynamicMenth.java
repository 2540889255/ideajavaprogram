package com.aynu.test.testvminfomation;



import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDynamicMenth {

    class GraderFather{
        private void thing() throws Throwable {
            System.out.println("我是爷爷");
        }
    }
    class Father extends GraderFather{
        void thing() throws Throwable {
            System.out.println("我是爸爸");
        }
    }
    class Son extends Father{
        @Override
        void thing() throws Throwable {
            /*GraderFather graderFather=new GraderFather();
            Method method=graderFather.getClass().getMethod("thing",void.class);
            method.invoke(void.class);*/
            //graderFather.thing();
            //使用MenHander解决问题
            //MethodType methodType = MethodType.methodType(void.class);
            //MethodHandle handle=MethodHandles.lookup().findSpecial(GraderFather.class,"thing",methodType,getClass());
            //handle.invoke(this);
            //jdk8之后的操作
            //MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodType methodType = MethodType.methodType(void.class);

            Field field = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            field.setAccessible(true);
            MethodHandle mh=((MethodHandles.Lookup)field.get(null)).findSpecial(GraderFather.class,"thing",methodType,GraderFather.class);
            mh.invoke(this);

        }
    }

    @Test
    public void test() throws Throwable {
        GraderFather graderFather=new GraderFather();
        graderFather.thing();
        Son son=new Son();
        son.thing();
    }
    public static void main(String[] args) {
        TestDynamicMenth test=new TestDynamicMenth();
        test.new Son();
    }
}
