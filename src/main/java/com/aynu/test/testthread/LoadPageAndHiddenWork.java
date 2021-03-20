package com.aynu.test.testthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: LC
 * @Date : 2021 01 29 16:09
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 * 测试程序，模拟页面加载的时候，对于用于的请求之后，给予一定的返回，但是仍然保留一个工作线程，进行一定的操作可以对于用户的操作进行拓展
 */
public class LoadPageAndHiddenWork {

    ExecutorService executors=Executors.newSingleThreadExecutor();

    public void loadPage(){
        Callable callable= () ->{
            System.out.println("隐藏的任务正在进行中");

            Thread.sleep(1000*10);
            System.out.println("隐藏任务已经结束");
            return "隐藏任务已经完毕";
        };
        System.out.println("对于页面进行加载");

        executors.submit(callable);

        System.out.println("正在处理用户当前的请求");
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户当前的任务已经结束");
        executors.shutdown();
    }

    public static void main(String[] args) {
        LoadPageAndHiddenWork loadPageAndHiddenWork=new LoadPageAndHiddenWork();
        loadPageAndHiddenWork.loadPage();
    }

}
