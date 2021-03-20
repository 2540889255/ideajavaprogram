package com.aynu.test.classloaders;



import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassloader {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File file=new File("D:/testfile/");

        URI uri=file.toURI();
        System.out.println(uri);
        URL url = uri.toURL();
        System.out.println(url);
        URLClassLoader urlClassLoader=new URLClassLoader(new URL[]{url});//默认加载器是父类加载器
        System.out.println(urlClassLoader.getParent());
        Class<?> aClass = urlClassLoader.loadClass("Demo");
        aClass.newInstance();


    }
    @Test
    public void test(){
        int a=1;
        int b=a>>9;
        System.out.println(b);
    }
}
