package com.aynu.test.spring;

import org.springframework.objenesis.ObjenesisException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    Object target;

    Interceptor interceptor;


    public static Object getProxyBean(HelloImpl target,Interceptor interceptor) throws Throwable {

        ProxyBean proxyBean=new ProxyBean();
        proxyBean.interceptor=interceptor;
        proxyBean.target=target;
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return o;


        /*Object invoke = proxyBean.invoke(target, target.getClass().getMethod(""), target.getClass().getMethod("").getParameters());
        return invoke;*/
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyInvocation myInvocation=new MyInvocation(target,method,args);
        Object around=null;
        if (this.interceptor.before()){
            around = this.interceptor.around(myInvocation);
        }
        else {
            around = method.invoke(args);
        }
        return around;
    }
    public static void main(String[] args) throws Throwable {
        HelloImpl o=new HelloImpl();
        Interceptor interceptor=new MyInterceptor();
        Object proxyBean = ProxyBean.getProxyBean(o, interceptor);

        proxyBean.toString();

    }
}

interface Hello {
    void sayHello();
}
class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}