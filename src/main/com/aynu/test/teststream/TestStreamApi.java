package main.com.aynu.test.teststream;

import main.com.aynu.test.testlanmbda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一 stream的三个步骤
 *
 * 1创建Stream
 * 2中间操作
 * 3终止操作
 *
 */
public class TestStreamApi {

    @Test
    public void  testCreatStream(){
        //四种方式
        //第一种 使用Collection 系列的集合获取流
        List<Integer> list=new ArrayList();
        Stream<Integer> stream=list.stream();
        //第二种方式 通过 Arrays 数组类进行获取数据流
        Employee [] employees=new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employees);
        //第三种
        Stream<String> stringStream = Stream.of("12", "123", "12432143");
        //第四种 获取无限流
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate
                .limit(10)
                .forEach(System.out::println);
        //生成
        Stream.generate(()-> (int)(Math.random()*10))
                .limit(12)
                .forEach(System.out::println);
    }

}
