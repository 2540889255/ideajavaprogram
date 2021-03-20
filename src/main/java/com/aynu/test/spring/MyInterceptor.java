package com.aynu.test.spring;


import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements  Interceptor{

    boolean before;

    boolean around;

    boolean after;
    @Override
    public boolean before() {
        System.out.println("the method before");
        return true;
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("the method around");
        Object process = invocation.process();
        return process;
    }

    @Override
    public boolean after() {

        System.out.println("the method after");
        return true;
    }

    @Override
    public void afterReturning() {

    }

    @Override
    public void afterThrowing() {

    }

    public boolean isBefore() {
        return before;
    }

    public void setBefore(boolean before) {
        this.before = before;
    }

    public boolean isAround() {
        return around;
    }

    public void setAround(boolean around) {
        this.around = around;
    }

    public boolean isAfter() {
        return after;
    }

    public void setAfter(boolean after) {
        this.after = after;
    }
}
