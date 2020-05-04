package main.com.aynu.test.teststream;

import main.com.aynu.test.testlanmbda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 一 stream的三个步骤
 *
 * 1创建Stream
 * 2中间操作
 * 3终止操作
 *
 */
public class TestStreamMiddleApi {
    List<Employee> lists= Arrays.asList(
            new Employee("小黑",1,2.123213),
            new Employee("小白",23,2.123213),
            new Employee("小蓝",57,2.123213),
            new Employee("小子",78,2.123213),
            new Employee("小陆",45,2.123213),
            new Employee("小胡",36,2.123213),
            new Employee("小陆",45,2.123213),
            new Employee("小陆",45,2.123213)
    );
    //中间操作
    //排序
    //sorted 自然排序
    //sorted（Comparator com） 定制排序
    @Test
    public void  testSortarray(){
        List<String> list=Arrays.asList(
                "a","b","h","e"
        );
        list.stream()
                .sorted()
                .forEach(System.out::println);

    }
    //映射
    //map 接收 lambda 将元素转换成其他形式的或提取信息  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成为一个新的元素
    //flatmap   接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有的流连接成一个流。
    @Test
    public void testMap(){
        List<String> list=Arrays.asList(
                "aaaa","bbbb","bbhh"
        );

/*        list.stream()
                .map((x)-> x.toUpperCase())
                .forEach(System.out::println);

        lists.stream()
                .map(Employee::getName)
                .forEach(System.out::println);*/

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamMiddleApi::fillstr);
        stream.forEach((sm) -> sm.forEach(System.out::println));
        System.out.println("这是flatmap所产生的结果");
        list.stream()
                .flatMap(TestStreamMiddleApi::fillstr)
                .forEach(System.out::println);
    }

    public static Stream<Character>  fillstr(String string){
        List<Character> list=new ArrayList<>();
        for (Character character:string.toCharArray()
             ) {
            list.add(character);
        }
        return list.stream();
    }

    //筛选和切片
    //filter --接受lambda，从流中排出某些元素
    //limit  -- 截断流 使其元素不超过指定数量
    //skip --  跳过元素 返回一个扔掉了前 n个元素的流  若流中元素不满n个 则返回空流   与limit互补
    //distinct --筛选  通过流hashcode和 equals 去除重复元素
    //内部迭代 ：迭代操作由Stream由 Stream Api 执行
    @Test
    public void testOperation(){

        List<Integer> list2= new ArrayList<>();
        list2.add(2);
        list2.add(2);
        list2.add(4);
        lists.stream().filter((e) ->e.getAge()>35).forEach(System.out::println);
        System.out.println("进行去重操作");
        lists.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
