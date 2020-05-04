package main.com.aynu.test.classloaders;

import java.io.*;

//继承classloader
//涵盖findclass方法
public class MyFileClassLoader extends ClassLoader{

    private String dictory;

    public MyFileClassLoader(String dictory) {
        this.dictory = dictory;
    }
    public MyFileClassLoader(String dictory,ClassLoader classLoaders){
        super(classLoaders);
        this.dictory=dictory;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String file=dictory+ File.separator+name.replace(".",File.separator)+".class";
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte [] by=new byte[1024];
        int length=-1;
        while (true){
            try {
                if (!((length=inputStream.read(by))!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream.write(by,0,length);
        }
        byte[] bytes = outputStream.toByteArray();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyFileClassLoader myFileClassLoader=new MyFileClassLoader("D:/testfile/");
        Class<?> demo = myFileClassLoader.loadClass("Demo");
        demo.newInstance();

    }
}
