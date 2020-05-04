package main.com.aynu.test.testlanmbda;

import org.junit.Test;

import javax.crypto.spec.PSource;
import java.util.*;

/**
 * 测试lambda表达式
 */
public class Testlambda {
    //测试匿名内部类


    @Test
    public void testclass(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet treeSet=new TreeSet(comparator);
    }

    @Test
    public void testlambda(){
        Comparator<Integer> comparator=(a,b) -> Integer.compare(a,b);
        TreeSet<Integer> treeSet=new TreeSet<>(comparator);

    }

    @Test
    public void emplyee(){

        List<Employee> list= Arrays.asList(
                new Employee("小黑",1,2.123213),
                new Employee("小白",23,2.123213),
                new Employee("小蓝",57,2.123213),
                new Employee("小子",78,2.123213),
                new Employee("小陆",45,2.123213),
                new Employee("小胡",36,2.123213)
        );
        Testlambda testlambda=new Testlambda();
        List<Employee> fillter = testlambda.fillter(list);
        for (Employee e:fillter
             ) {
            System.out.println(e.toString());
        }
        System.out.println("通过构建接口的方式进行信息的筛选");
        //其他的两种方式 第一种方式 优化
        Searchforage searchforage=new Searchforage();
        List<Employee> fillevery = testlambda.fillevery(list, searchforage);
        for (Employee e:fillevery
        ) {
            System.out.println(e.toString());
        }
        System.out.println("搜索通过money的数目");
        Searchformoney searchformoney=new Searchformoney();
        List<Employee> fillmoney = testlambda.fillevery(list, searchformoney);
        for (Employee e:fillmoney
        ) {
            System.out.println(e.toString());
        }
        System.out.println("第二种方式匿名内部类");
        //第二种方式优化 匿名内部类
        Searchfor  searchfor=new Searchfor() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()>35;
            }
        };
        List<Employee> fillevery1 = testlambda.fillevery(list, searchfor);
        for (Employee e:fillevery1
        ) {
            System.out.println(e.toString());
        }
        //优化方式第三种  lambda表达式
        System.out.println("这是优化方案的第三中 lambda表达式");
        List<Employee> fillevery2 = testlambda.fillevery(list, employee -> employee.getAge() > 35);
        fillevery2.forEach(System.out::println);
    }

    public List<Employee>  fillter(List<Employee> list){
        List<Employee> emps=new ArrayList<>();

        for (Employee emp:list
             ) {
            if (emp.getAge()>=35){
                emps.add(emp);
            }
        }
        return emps;
    }

    public List<Employee> fillevery(List<Employee> list,Searchfor searchfor){
        List<Employee> emps=new ArrayList<>();
        for (Employee employee:list
             ) {
            if (searchfor.test(employee)){
                emps.add(employee);
            }
        }
        return  emps;
    }
    //优化方式四  stream
    @Test
    public void teststream(){
        List<Employee> list= Arrays.asList(
                new Employee("小黑",1,2.123213),
                new Employee("小白",23,2.123213),
                new Employee("小蓝",57,2.123213),
                new Employee("小子",78,2.123213),
                new Employee("小陆",45,2.123213),
                new Employee("小胡",36,2.123213)
        );

        list.stream()
                .filter(employee -> employee.getAge()>35)
                .limit(3)
                .forEach(System.out::println);

        list.stream()
                .filter(employee -> employee.getAge()>35)
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
