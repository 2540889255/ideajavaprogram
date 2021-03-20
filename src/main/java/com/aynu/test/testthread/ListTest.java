package com.aynu.test.testthread;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 16 12:37
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class ListTest {


    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList();

        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    list.add("1");
                }
            });
            thread.start();
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println(list.size());


    }

    /*使用collections。synlist进行多线程保证完整性*/
    @Test
    public void show() throws InterruptedException {
        List<String> list=new ArrayList();

        List<String> list1 = Collections.synchronizedList(list);

        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(() ->{
                String substring = UUID.randomUUID().toString().substring(0,5);
                list1.add(substring);
                System.out.println(list1);
            });
            thread.start();
        }
        TimeUnit.SECONDS.sleep(3);

    }

    @Test
    public void show2() throws InterruptedException {
        List<String> list=new CopyOnWriteArrayList();
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(() ->{
                String substring = UUID.randomUUID().toString().substring(0,5);
                list.add(substring);
                System.out.println(list);
            });
            thread.start();
        }

        TimeUnit.SECONDS.sleep(3);

    }


    @Test
    public void test(){
        Thread thread=new Thread(() -> {
            System.out.println(1);
        });
        thread.start();
    }
}
