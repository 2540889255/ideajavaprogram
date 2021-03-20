package com.aynu.test.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMyDynamicProxy {


        public static  void main (String[] args) {
            HelloImpl hello = new HelloImpl();
            MyInvocationHandler handler = new MyInvocationHandler(hello);
            // 构造代码实例
            Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);

            

            // 调用代理方法
            System.out.printf("---");
            System.out.printf(HelloImpl.class.getInterfaces()[0].getName());
            System.out.printf("---");

            proxyHello.sayHello();
        }
}
    interface Hello {
        void sayHello();
    }
    class HelloImpl implements  Hello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }
    class MyInvocationHandler implements InvocationHandler {
        private Object target;
        public MyInvocationHandler(Object target) {
            this.target = target;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            if (true){
                System.out.println("before");
            }

            System.out.println("Invoking sayHello");
            Object result = method.invoke(target, args);
            System.out.println(proxy.getClass());
            System.out.println("after");
            return result;
        }
    }


