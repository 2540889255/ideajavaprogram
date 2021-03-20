package com.aynu.test.teststream;

import com.aynu.test.testlanmbda.Employee;
import org.junit.jupiter.api.Test;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.aynu.test.testlanmbda.Employee.Status.*;

/**
 * Stream 流
 * 终止操作
 */
public class TestStreamFinalApi {
    /*
    * 查找与匹配
    *  allmatch--检查是否匹配所有字符
    *  anymatch--检查是否至少匹配了一个字符
    *  nonematch--检查是否没有匹配的元素
    *  findfirst--返回第一个元素
    *  findany--返回当前流中的任意元素
    *   count--返回当前流中的元素的个数
    *  max--返回流中的最大值
    *  min--返回流中的最小值
    *
    * */

    List<Employee> lists= Arrays.asList(
            new Employee("小黑",1,2.123213, FREE),
            new Employee("小白",23,2.123213,BUSY),
            new Employee("小蓝",57,2.123213,FREE),
            new Employee("小子",78,2.123213,BUSY),
            new Employee("小陆",45,2.123213,VOCATION),
            new Employee("小胡",36,2.123213,BUSY),
            new Employee("小陆",45,2.123213,VOCATION),
            new Employee("小陆",45,8.123213,FREE)
    );
    /*
    * 收集  Collect  将流转换为其他形式，接受一个Collector接口的实现 用于给Stream流中的元素做  汇总
    * */

    @Test
    public void testCollect(){

        lists.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("这是将结果集映射成为set集合");
        lists.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        //测试
        System.out.println("这是总数的测试");
        Long collect = lists.stream()
                .map(Employee::getMoney)
                .collect(Collectors.counting());
        System.out.println(collect);
        //平均值
        Double averagemoney = lists.stream()
                .collect(Collectors.averagingDouble(Employee::getMoney));
        System.out.println(averagemoney);
        System.out.println("这是最大的工资的钱数");
        Optional<Double> collect1 = lists.stream()
                .map(Employee::getMoney)
                .collect(Collectors.maxBy((x, y) -> Double.compare(x, y)));
        System.out.println(collect1);
        System.out.println("获取工资最大的人的信息");
        Optional<Employee> employee = lists.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getMoney(), y.getMoney())));
        System.out.println(employee);
    }


    /*
     归约
        reduce (T identity，BinaryOperator)  / reduce（BinaryOperator） --可以将流中的元素=反复结合起来 得到一个值

    * */
    @Test
    public void  testSummary(){
        List<Integer> list =Arrays.asList(
                1,2,3,4,5,6,7,8
        );

        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        List<String> list1 =Arrays.asList(
                "1","2","2","2","3","2","2"
        );

        String reduce1 = list1.stream()
                .reduce("2", (x, y) -> x + y);
        System.out.println(reduce1);

    }


    @Test
    public void testfinalOperation(){
        boolean match = lists.stream()
                .allMatch((employee) -> employee.getAge() > 5);
        System.out.println(match);
        boolean anymatch = lists.stream()
                .anyMatch((employee) -> employee.getAge() > 5);
        System.out.println(anymatch);

    }


}
