package com.aynu.test.annotation;



import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class TestAnnotation {

    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnotation> annotationClass=TestAnnotation.class;

        Method show = annotationClass.getMethod("show");
        MyAnnotation[] type = show.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation my:type
             ) {
            System.out.println(my.value());
        }

    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){

    }
}
