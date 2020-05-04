package main.com.aynu.test.testCollection;

import kotlin.coroutines.RestrictsSuspension;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestCollection {

    public Collection<String> c;


    public static void main(String[] args) {
        TestCollection testCollection=new TestCollection();
        List<String> list =new ArrayList<String>();

        for (int i=0;i<=10;i++){
            String liststring=String.valueOf(i);
            list.add(liststring);
        }
        
        /*Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            String number= (String) iterator.next();
            System.out.println(number);
        }*/
        /*list.remove("3");

        for (String string:list
             ) {

            System.out.println(string);

        }*/
        list.remove(1);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            String number= (String) iterator.next();
            System.out.println(number);
        }

    }
    @org.junit.Test
    public void test(){
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
    }

    @Test
    public void teststream(){
        List<String> list=new ArrayList<>();
        list.add("一");
        list.add("二");
        list.add("三");

        list=list.stream().filter(lists ->!lists.equalsIgnoreCase("一")).collect(Collectors.toList());
        System.out.println(list);
    }
    /**
     * 写一个迭代器Fillter
     */
    public void  filter(Collection list){
        for (Iterator iterator=list.iterator();iterator.hasNext();){
            if (iterator.next()==null){
                iterator.remove();
            }
            System.out.println();
        }
    }

    /**
     * 食用 removeall （Collections.singleton()）出去所有指定元素的实例
     */
    @Test
    public void single(){
        List<String> list=new ArrayList<>();
        list.add("一");
        list.add("二");
        list.add("三");
        list.add("一");

        list.removeAll(Collections.singleton("一"));
        Iterator<String> iterator=list.iterator();

        while (iterator.hasNext()){
            String element=iterator.next();
            System.out.println(element);
        }
    }
    @Test
    public void  testrepating(){
        String [] a=new String[20];
        for (int i=0;i<a.length-1;i++){
            a[i]="这是第"+i+"个元素";
        }
        a[19]="这是第1个元素";
        Set set =new HashSet();
        for (String string:a
             ) {
            if (set.add(string)==false){
                System.out.println("重复的元素"+string);
            }
        }
    }

    @org.junit.Test
    public void testadd(){
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            b.add(temp);
        }
    }

    @Test
    public void testprevious(){
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<=20;i++){
            list.add(i);
        }

        Collections.shuffle(list);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*ListIterator listIterator=list.listIterator();
        if (listIterator.hasPrevious()){
            System.out.println(listIterator.nextIndex());
            System.out.println(listIterator.previousIndex());

        }*/
    }
    /**
     * 这是一个测试队列的 queue
     */
    @Test
    public  void testqueue() throws InterruptedException {

        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<=20;i++){
            queue.add(i);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
            //System.out.println(queue.element());
            //Thread.sleep(1000);
        }
        String s="54";
        char[] i=s.toCharArray();
        System.out.println(i[1]);
        System.out.println(i.length);
        char a='1';
        //String d=(String)a;
        /*List list=new ArrayList(Collections.singleton(i));
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next().getClass().toString());
        }*/
    }
    /**
     * 这个程序是为了统计各个字符串出现的次数
     */
    @Test
    public void testString(){
        Map<String,Integer> map=new HashMap<String, Integer>();
        String [] strings=new String[1020];

        for (int i=0;i<=1000;i++) {
            strings[i] = String.valueOf((int)(Math.random() * 10));
        }
        System.out.println(strings[1]);
        for (String s:strings
             ) {
            Integer integer=map.get(s);
            map.put(s,integer==null?1:integer+1);
        }
        //System.out.println(map.size());
        System.out.println(map);
        System.out.println("这是Map2");
        Map<String,Integer> map2=new HashMap<String, Integer>();
        map2.put("1",2);
        map2.put("1",3);


        Iterator iterator=map2.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map2);

    }
    /**
     * 这是测试其他的集合类别
     */
    @Test
    public void testSet(){
        String a="12351241631265847365148391";

        //int count =a.subSet().size();
    }
}
