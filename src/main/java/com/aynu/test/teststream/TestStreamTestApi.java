package com.aynu.test.teststream;

import com.aynu.test.testlanmbda.Employee;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.aynu.test.testlanmbda.Employee.Status.*;
import static com.aynu.test.testlanmbda.Employee.Status.FREE;

/**
 * 这是Stream的题目的测试
 */
public class TestStreamTestApi {


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
    // 给定一个数字列表 返回一个 由所有数字平方构成的列表
    // 给定 1 2 3 返回   1 4 9

    @Test
    public void test(){
        Integer[] integer={1,2,3,4,5,6};

        Arrays.stream(integer)
                .map((x) ->x*x)
                .forEach(System.out::println);
    }
    //怎样使用 map和reduce 数一数流中有多少个Employee
    @Test
    public  void  testcountEmployee(){
        System.out.println("返回集合的去重之后的集合");
        Set<Employee> employees = lists.stream()
                .collect(Collectors.toSet());
        System.out.println(employees);
        System.out.println(employees.size());
        System.out.println("这是集合不去重复的size");
        Optional<Integer> integer = lists.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(integer.get());

    }



}
