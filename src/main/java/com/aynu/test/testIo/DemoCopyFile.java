package com.aynu.test.testIo;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * 复制文件
 * @author admin
 */
public class DemoCopyFile {


    public void copyFile(){

        File source=new File("");
        File desc=new File("");

        try {
            FileInputStream inputStream=new FileInputStream(source);
            FileOutputStream outputStream=new FileOutputStream(desc);

            byte[] buffer =new byte[1024];

            while (inputStream.read(buffer)>0){
                outputStream.write(buffer,0, buffer.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }


    public void copyFile2(){
        File source=new File("");
        File desc=new File("");

        try (
                FileInputStream fileInputStream=new FileInputStream(source);
                FileOutputStream fileOutputStream=new FileOutputStream(desc);
                ){
            FileChannel inoutChannel = fileInputStream.getChannel();
            FileChannel outputChannel = fileOutputStream.getChannel();

            for (Long length=inoutChannel.size(); length >0;) {
                long transferTo = inoutChannel.transferTo(inoutChannel.position(), length, outputChannel);
                inoutChannel.position(inoutChannel.position()+transferTo);
                length=length-transferTo;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show(){
        /*Files files=Files.copy();
        File file=new File("");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer map = channel.map();*/

    }
}
