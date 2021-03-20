package com.aynu.test.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

public interface Invocation{


    Object process() throws InvocationTargetException, IllegalAccessException;
}
