package com.aynu.test.testlanmbda;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java 8 内置的四大核心 函数式接口
 *
 * Consumer 接口
 *      void accept<T t>
 * Supplier<T>  供给型接口
 *      T get();
 *Function<T,R> T 函数  R 返回值  函数型接口
 *     R apply（T t）
 *Predicate<T> 断言型接口
 *      boolean test（T t）；
 *
 * */
public class TestInnerMendth {

    //消费型接口
    @Test
    public void testconsumer(){
        consumer(10000.0, money -> System.out.println("您已经消费了"+money));
    }

    public void consumer(Double money, Consumer consumer){
        consumer.accept(money);

    }
    //提供者接口
    @Test
    public void testsupplier(){
        List<Integer> list=new ArrayList();
        list=supplier(() -> {
            List<Integer> list1=new ArrayList();
            for (int i = 0; i <10; i++) {
                list1.add((int)(Math.random()*100));
            }
            return list1;
        });
        list.forEach(System.out::println);

    }
    public List<Integer> supplier(Supplier<List<Integer>> supplier){
        return supplier.get();
    }
    //测试函数型接口
    @Test
    public void testfunction(){
        String function = function("这是一个安静的晚上", (string) -> {
            return string.replace('这', '有');
        });

        System.out.println(function);
    }

    public String function(String string, Function<String,String> function){
        return function.apply(string);
    }
    //测试断言型接口
    @Test
    public void  predicate(){
        List<String> list= Arrays.asList(
                new String("下路"),
                new String("小徐"),
                new String("小陆"),
                new String("笑话"),
                new String("小兰")
        );
        List<String> strings = predicted(list, (string) -> {
            if (string.equals("小陆")) {
                return false;
            } else {
                return true;
            }
        });

        strings.forEach(System.out::println);
    }

    public List<String>  predicted(List<String> strings, Predicate predicate){
        List<String> list=new ArrayList<>();
        for (String s:strings
             ) {
            if (predicate.test(s)){
                list.add(s);
            }
        }
        return list;
    }


}
