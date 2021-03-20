package com.aynu.test.testIo;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.logging.FileHandler;

public class TestFile {
    @Test
    public void test(){
        File file=new File("E:\\ideajavaprogram\\target\\classes\\index.html");
    }

    public static void main(String[] args) {
        File file =new File("D:/testfile");
        System.out.println(file.canRead());
        System.out.println(file.length());//获取文件的长度  单位是字节
        System.out.println(file.getParent());//获取文件父目录的名字
        //System.out.println(file.listFiles());
        String[] s=file.list();
        System.out.println(s[0]);
        System.out.println(s[1]);
    }
    @Test
    public void readtxt() throws IOException {
        File file=new File("D:/testfile/one.txt");
        System.out.println(file.length());//读取的是txt文件里面内容的字节长度

        FileInputStream fileInputStream=new FileInputStream(file);
        //System.out.println(fileInputStream.read());
        //fileInputStream.available();
        int a=176;
        byte [] buffer=new byte[a];

        while ((fileInputStream.read(buffer,0,a)!=-1)&&(a>0)){
            System.out.println(new String(buffer));
        }
        fileInputStream.close();

    }
    /**
     * 这个是测试 Fileread 和 FileWrite的作用
     */
    @Test
    public void testFileread() throws IOException {
        int b =(int) System.in.read();
        System.out.println(b);
        FileReader fileReader=new FileReader("D:/testfile/one.txt");

        int a=fileReader.read();
        while (a!=-1){
            System.out.print((char) a);
            a=fileReader.read();
        }
        fileReader.close();




    }
}
