package com.aynu.test.testthread;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: LC
 * @Date : 2021 02 16 14:51
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class SetTest {


    @Test
    public void show2() throws InterruptedException {
        Set<String> list=new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Thread thread=new Thread(() ->{
                String substring = UUID.randomUUID().toString().substring(0,5);
                list.add(substring);
                System.out.println(list);
            });
            thread.start();
        }

        TimeUnit.SECONDS.sleep(3);

    }

}
