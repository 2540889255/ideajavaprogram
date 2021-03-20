package com.aynu.test.testoptional;



import com.aynu.test.testlanmbda.Employee;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestOptional {
    /**
     * 常用方法
     *   optional.of (T  t) 创建一个optional实例
     *  optional。empty（） 创建一个空的Optional实例
     *  。ofNullable（T  t）若t不为null 创建Optional实例  否则创建Optional空的实例
     *  ispresent()   判断是否含有空值
     *  orElse   如果传入的对象中包含值 则返回该值 否则返回该对象
     *  orElseGet（Supplier s）如果调用对象包含值 返回该值 否则返回S获取的值
     *  map（function f） 如果有值对其处理 并返回处理后的optional  否则返回optional。empty
     *  flatMap （function mapper）yumap类似 要求返回值必须是Optional
     *
     */
    @Test
    public void  testOptionalmethod(){
        Employee employee=new Employee();
        Employee employee1=new Employee("小鹿");
        //
        Optional<Employee>  employees=Optional.of(employee);//传入是null的时候    空指针异常  可以用来检测空指针异常所出现的位置
        System.out.println(employee);
        //
        Optional<Employee> empty = Optional.empty();
        System.out.println(empty);//输出 Optional。empty  不会报错  但是获取其中的值的时候会报错
        //
        Optional<Employee> optionalO = Optional.ofNullable(null);
        System.out.println(optionalO);
        System.out.println(optionalO.isPresent());
        //
        System.out.println("orelse 如果传入的对象中包含值 则返回该值 否则返回该对象");
        Optional<Employee> optional=Optional.ofNullable(null);
        Employee employee2 = optional.orElse(new Employee("小黑"));
        System.out.println(employee2);

    }
    @Test
    public void testMan(){
        Man man=new Man();
        TestOptional testOptional=new TestOptional();
        String name=testOptional.getGodnessname(man);
        System.out.println(name);
    }

    public String getGodnessname(Man man){
        return man.getGodness().getName();
    }

    @Test
    public  void  testNewMan(){
        Optional<NewMan> newMan=Optional.ofNullable(null);
        TestOptional testOptional=new TestOptional();
        String s = testOptional.testNewMan(newMan);
        System.out.println(s);
    }

    public String testNewMan(Optional<NewMan> newMan){
        return newMan.orElse(new NewMan("小兰"))
                .getGodness()
                .orElse(new Godness("女老师"))
                .getName();

    }
}
