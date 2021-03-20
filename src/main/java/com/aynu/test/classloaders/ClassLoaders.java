package com.aynu.test.classloaders;

import com.sun.net.httpserver.Headers;

public class ClassLoaders {

    public static void main(String[] args) {

        ClassLoader object=Object.class.getClassLoader();
        System.out.println("object类的类加载器是"+object);

        ClassLoader headers=Headers.class.getClassLoader();
        System.out.println(headers);

        ClassLoader classLoaders=ClassLoaders.class.getClassLoader();
        System.out.println(classLoaders);

        System.out.println(classLoaders.getParent());
    }
}
