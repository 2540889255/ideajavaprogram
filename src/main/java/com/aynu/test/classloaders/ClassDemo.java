package com.aynu.test.classloaders;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ServiceLoader;

public class ClassDemo {


    public static void main(String[] args) {
        ProcessBuilder processBuilder=new ProcessBuilder();
        try {
            Process start = processBuilder.start();
            InputStream inputStream = start.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //调用系统的线程，执行系统级别的指令
    @Test
    public  void checkPhysicAddress(){

        ProcessBuilder processBuilder=new ProcessBuilder("ipconfig","/all");

        try {
            Process start = processBuilder.start();
            InputStream inputStream = start.getInputStream();
            InputStreamReader reader=new InputStreamReader(inputStream,"GBK");
            BufferedReader readers=new BufferedReader(reader);
            readers.lines().forEach((s) -> System.out.println(s));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //使用程序打开网页
    @Test
    public void showGoogle(){
        Runtime runtime=Runtime.getRuntime();
        String path="E:\\softprogram\\Gougle\\ChromeCore\\ChromeCoreLauncher.exe";
        String chrome="www.baidu.com";
        String [] cmd={path,chrome};
        try {
            runtime.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //打印所有线程信息
    @Test
    public void showTaskList(){
        Runtime runtime = Runtime.getRuntime();
        try {
            Process tasklist = runtime.exec("tasklist");
            InputStream inputStream = tasklist.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"GBK");
            BufferedReader reader=new BufferedReader(inputStreamReader);
            reader.lines().forEach((x)-> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showAsmClass(){
        ClassWriter classWriter=new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        byte[] bytes = classWriter.toByteArray();
    }

    @Test
    public void TestSqlStatement(){

        /*Connection connection = DriverManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement();*/

    }

    @Test
    public void testJMHDemo(){

    }

}
