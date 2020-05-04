package main.com.aynu.test.testlanmbda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestLambdaTask {
    List<Employee> list= Arrays.asList(
            new Employee("小黑",1,2.123213),
            new Employee("小白",23,2.123213),
            new Employee("小蓝",57,2.123213),
            new Employee("小子",78,2.123213),
            new Employee("小陆",45,2.123213),
            new Employee("小胡",36,2.123213)
    );

    @Test
    public void test(){
        Collections.sort(list, (a,b) -> {
            if (a.getAge()==b.getAge()){
                return a.getMoney().compareTo(b.getMoney());
            }else{
                return a.getAge().compareTo(b.getAge());
            }
        });

        list.forEach(System.out::println);
    }

    @Test
    public void teststr(){
        String s = stringOptionchange("这是一个安静的晚上", str -> str.intern());
        System.out.println(s);
        String string2=stringOptionchange("按时发份安抚",str -> str.replace('按','不'));
        System.out.println(string2);
        String string3=stringOptionchange("sadsadsad",str -> str.toUpperCase());
        System.out.println(string3);
    }

    public String stringOptionchange(String string,StringOption stringOption){
        return stringOption.option(string);
    }

}
