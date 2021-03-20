package com.aynu.test.spring;


import java.lang.reflect.InvocationTargetException;

public interface Interceptor {


    //事前方法
    public boolean before();


    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    //事后方法
    public boolean after();

    public void afterReturning();

    public void afterThrowing();


}
