package main.com.aynu.test.testlanmbda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 *一  --方法引用 ：若lambda体中的内容已经实现了 ，我们可以使用“方法引用” （可以理解为方法引用是lambda表达式的另一种表现形式）
 *
 * 主要有三种语法格式
 *
 * 对象：：实例方法名
 *
 * 类 ：：静态方法名
 *
 * 类 ：：实例方法名
 *
 * 注意：
 * @lambda表达式 体中调用的方法的参数列表与返回值类型，要与函数式接口中的抽象方法的返回值一致
 *
 *Lambda表达式  参数列表的第一个参数 是实例方法的调用着 而第二个参数是 实例方法的参数的时候 可以使用classname ：：method
 *
 * 二 --构造器引用
 *
 * ClassName：：new
 *
 * 三 ==数组引用
 *
 * type：：new
 *
 */
public class TestMethodRef {
    //数组引用
    @Test
    public void testArraylist(){
        Function<Integer, List<Integer>> function=(x) -> {
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i <=x ; i++) {
                list.add((int) (Math.random()*12));
            }
            return list;
        };

        Function<Integer,List<Integer>>  function1=ArrayList::new;


    }

    //构造器引用
    @Test
    public  void testConstructor(){
        Supplier<Employee> supplier=() -> new Employee();

        Supplier<Employee>  supplier1=Employee::new;
        //创建多个参数的 构造器
        Function<String,Employee> function=(x) -> new Employee(x);

        Function<String,Employee> function1=Employee::new;
        Employee apply = function1.apply("小黑");
        System.out.println(apply);

    }



    //类加实例方法
    @Test
    public void testObjerct(){
        BiPredicate<String,String> biPredicate= (x,y) -> x.equals(y);
        boolean test = biPredicate.test("2", "3");
        System.out.println(test);
        //限制条件   第一个参数  是第二个参数的函数调用者时  可以使用
        BiPredicate<String,String> biPredicate1=String::equals;
        boolean test1 = biPredicate1.test("12", "323");
        System.out.println(test1);

    }

    //静态方法
    @Test
    public void teststaticmenth(){
        Comparator<Integer> comparator= (x,y) -> Integer.compare(x,y);
        int compare = comparator.compare(3, 4);
        System.out.println(compare);

        Comparator<Integer> comparator1=Integer::compare;
        int compare1 = comparator1.compare(5, 11);
        System.out.println(compare1);

    }

    @Test
    public void  testCreateClass(){
        Supplier<String> supplier=() ->{

            return  null;

        };

    }
    @Test
    public void testConsumer(){
        Consumer<String> consumer= (string) -> System.out.println(string);
        consumer.accept("喜欢");

        PrintStream ps = System.out;
        Consumer<String> consumer1=ps::println;
        consumer.accept("不喜欢");
    }
    @Test
    public void testSupplier(){
        Employee employee=new Employee();
        Supplier<String> supplier=() -> employee.getName();
        String s = supplier.get();
        System.out.println(s);

        Supplier<String> supplier1=employee::getName;
        String s1 = supplier.get();
        System.out.println(s1);


    }



}
