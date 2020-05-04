package main.com.aynu.test.testenum;

import java.util.Arrays;
//普通的实现接口的枚举
public class TestFood {


    public static void main(String[] args) {
        Food.CAFE[] values = Food.CAFE.values();
        Arrays.stream(values).forEach(System.out::println);


    }
}
