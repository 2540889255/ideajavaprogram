package com.aynu.test.testlanmbda;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda基础语法 的测试
 * java8之中 引入了一个新的操作符 -》 该操作符成为箭头符号或者lambda表达式  lambda箭头将 表达式 拆分成两部分
 *
 * 箭头左侧   lambda表达式的参数列表
 * 箭头右侧  lambda表达式所需要执行的功能 即 lambda体
 *
 *
 * 函数式接口    接口中只有一个抽象接口的接口称为函数式接口
 *
 * 语法格式  :无参数  无返回值
 *
 * 语法格式 ： 有一个参数 有一个返回值
 *
 * 语法格式2 ： 有两个及两个以上参数  有返回值
 *
 * 语法格式  ： lambda表达式 参数列表的类型可以不写  因为JVM的编译器可以通过上下文推断出类型
 *
 * 二 lambda表达式需要函数式接口
 *
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用注解@FunctionInterface
 * 可以检查是否是函数式接口
 */
public class TestLambdaBasicGrammer {

    @Test
    public void testRunnable(){
        int a=0;
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello "+a);
            }
        };
        runnable.run();
        //现在
        Runnable lamrunnable= () ->System.out.println("hello lambda"+a);
        lamrunnable.run();


    }
    @Test
    public void testHasArgs(){
        Consumer consumer=(e) -> System.out.println(e);
        consumer.accept("悉尼那好");
    }
    @Test
    public void testHasTwoArgs(){
        Comparator<Integer> comparator= (x,y) -> {
            System.out.println("这是有返回值的 多个参数的函数");
            return  Integer.compare(x,y);
        };
        comparator.compare(1,5);
    }

}
