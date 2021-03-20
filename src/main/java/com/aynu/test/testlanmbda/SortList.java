package com.aynu.test.testlanmbda;

import com.aynu.test.test.User;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 02 18 20:19
 * @Description : com.aynu.test.testlanmbda
 * @Version 1.0
 */
public class SortList {


    public static void main(String[] args) {

        List<User> list=new ArrayList<>();
        list.add(new User("1","a","money"));
        list.add(new User("2","b","money"));
        list.add(new User("3","c","money"));
        list.add(new User("4","d","money"));
        list.add(new User("5","e","money"));
        list.add(new User("6","f","money"));


        list.stream().filter(u -> u.getName().equals("2")).forEach( u -> {
            System.out.println(u.toString());
        });


        list.stream().map(u -> {
            u.getId().toUpperCase();
            return u;
        }).forEach(u -> {
            System.out.println(u);
        });
    }
}
