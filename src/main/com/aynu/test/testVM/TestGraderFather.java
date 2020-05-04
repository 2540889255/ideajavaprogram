package main.com.aynu.test.testVM;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class TestGraderFather {

    public void think(){
        System.out.println("我是爷爷");
    }

    static class Father extends TestGraderFather{
        public void think(){
            System.out.println("我是爸爸");
        }
    }

    static class Son extends Father{
        public void think(){
            System.out.println("我是儿子");
        }

        public void getGraderFather() throws Throwable {

            MethodType methodType = MethodType.methodType(void.class);
            Field impl_lookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            impl_lookup.setAccessible(true);
            MethodHandle think = ((MethodHandles.Lookup) impl_lookup.get(null)).findSpecial(TestGraderFather.class, "think", methodType,TestGraderFather.class);
            think.invoke(this);
        }
    }

    public static void main(String[] args) throws Throwable {
        Son son=new Son();
        son.getGraderFather();
    }
}
