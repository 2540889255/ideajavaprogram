package main.com.aynu.test.teststream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestTransacton {

    List<Transaction>  transactions=null;

    @Before
    public void before(){
        Trader raoul=new Trader("Raoul","Cambridge");
        Trader mario=new Trader("Mario","Milan");
        Trader alan=new Trader("Alan","Cambridge");
        Trader brian=new Trader("Brian","Cambridge");

        transactions= Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,711),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)

        );

    }

    @Test
    public void testSorted(){
        //找到2011年发生的交易 并按照交易额排序
        /*transactions.stream()
                .map((x) ->x.getYear()==2011)
                .sorted()
                .forEach(System.out::println);*/

        transactions.stream()
                .filter((x) -> x.getYear() == 2011)
                .sorted((x,y) -> Integer.compare(x.getValue(),y.getValue()))
                .forEach(System.out::println);
        System.out.println("交易员都在哪些城市工作");
        //交易员都在哪些城市工作
        transactions.stream()
                .map( x ->x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        //查找所有来自剑桥的交易员 并按照姓名排序
        System.out.println("查找所有来自剑桥的交易员 并按照姓名排序");
        transactions.stream()
                .filter( x ->x.getTrader().getCity().equals("Cambridge"))
                .sorted( (x,y) -> x.getTrader().getName().compareTo(y.getTrader().getName()))
                .forEach(System.out::println);
        //返回所有交易员的字符串 按照字母顺序排序
        System.out.println("返回所有交易员的字符串 按照字母顺序排序");
        transactions.stream()
                .distinct()
                .map( x-> x.getTrader().getName())
                .sorted()
                .forEach(System.out::println);
        //有没有交易员是在米兰工作
        System.out.println("有没有交易员是在米兰工作");
        boolean anyMatch = transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
        System.out.println(anyMatch);
        //打印生活在剑桥的所有交易员的所有交易额
        System.out.println("打印生活在剑桥的所有交易员的所有交易额");
        Optional<Integer> integer = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .reduce((x,y) -> Integer.sum(x,y));
                //.reduce(Integer::sum);
        System.out.println(integer.get());
        //所有交易中 最高的交易额是多少
        System.out.println("所有交易中 最高的交易额是多少");
        Optional<Integer> max = transactions.stream()
                .map(x -> x.getValue())
                .max((x, y) -> x.compareTo(y));
        System.out.println(max.get());

    }








    //找到交易额最小的交易
}
