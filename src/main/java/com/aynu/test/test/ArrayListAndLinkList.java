package com.aynu.test.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Auther: LC
 * @Date : 2021 03 10 13:41
 * @Description : com.aynu.test.test
 * @Version 1.0
 * 测试查看linkedlist和arrayList的区别
 */
public class ArrayListAndLinkList {

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();


        ArrayList arrayList=new ArrayList();
    }

    @Test
    public void test2(){
        ArrayList arrayList=new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        //System.out.println(arrayList.hashCode());
        ArrayList arrayList1=new ArrayList();
        //arrayList1.add("2");
        arrayList1.add("2 ");
        arrayList1.add("1");

        arrayList.retainAll(arrayList1);
        System.out.println("------------");
        arrayList.forEach((x) ->{
            System.out.println(x.toString());
        });
    }


    /**
     *
     **/
    @Test
    public void test() {
        LinkedList<String> linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add(null);
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("3");
        System.out.println(linkedList.indexOf("3"));
        System.out.println(linkedList.lastIndexOf("3"));//因为是双向链表，所以从last节点往前遍历
        System.out.println(linkedList.indexOf("2"));//linkedlist下表从0开始
        System.out.println(linkedList.size());


        Iterator<String> iterator = linkedList.iterator();
        System.out.println("--------------使用升序迭代器");
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("--------------使用降序迭代器");
        Iterator<String> stringIterator = linkedList.descendingIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

    }
}
