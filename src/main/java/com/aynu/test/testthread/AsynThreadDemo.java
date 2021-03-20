package com.aynu.test.testthread;

import org.apache.ignite.internal.util.typedef.X;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: LC
 * @Date : 2021 02 18 22:12
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class AsynThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*没有返回值的异步回调*/
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(() ->{
            System.out.println("hello i am start");
        });

        System.out.println(1111);

        completableFuture.get();
    }


    @Test
    public void test() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {


            int a=9/0;
            return 1024;
        });

        integerCompletableFuture.whenComplete((r,e) -> {
            System.out.println("the result is "+r);
            System.out.println("the exception is "+e);
        }).exceptionally( (e) ->{
            System.out.println(e.getMessage());
            return 500;
        } );


    }
}
