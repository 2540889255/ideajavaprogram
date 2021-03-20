package com.aynu.test.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocation implements Invocation{

    Object target;

    Method method;

    Object[] params;

    public MyInvocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }


    @Override
    public Object process() throws InvocationTargetException, IllegalAccessException {
        Object invoke = method.invoke(target, params);
        return invoke;
    }
}
