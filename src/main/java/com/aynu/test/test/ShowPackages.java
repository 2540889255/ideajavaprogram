package com.aynu.test.test;

import com.aynu.test.designmode.Apple;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *这个程序是为了输入包中所有类
 */
public class ShowPackages {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String packages = Apple.class.getPackage().getName();

        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        String path= packages.replace('.', '/');

        Enumeration<URL> resources = classLoader.getResources(path);

        List<File> dirs=new ArrayList<>();


        while (resources.hasMoreElements()){
            URL resource=resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        System.out.println(dirs.size());
        dirs.stream().forEach(System.out::println);
        System.out.println("---------------------------------");
        ArrayList<Class> classes=new ArrayList<>();

        for (File directory:dirs
             ) {
            System.out.println("这是directory:"+directory);
            classes.addAll(findClasses(directory,packages));
        }

        classes.stream().forEach(System.out::println);
    }

    private static List<Class> findClasses(File directory,String packageName) throws ClassNotFoundException {
        List<Class> classes =new ArrayList<Class>();
        if (!directory.exists()){
            return classes;
        }
        File[] files=directory.listFiles();

        for (File file:files
        ) {
            if (file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName+"."+file.getName()));
            }else if (file.getName().endsWith(".class")){
                try {
                    classes.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length()-6)));
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        return classes;

    }
}
