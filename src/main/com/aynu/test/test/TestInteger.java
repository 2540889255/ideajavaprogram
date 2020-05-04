package main.com.aynu.test.test;

/**
 * 测试Integer 的自动拆箱装箱
 */
public class TestInteger {

    int  number=11;

    public static int num=22;

    public static void main(String[] args) {

        int a=1;
        int b=1;

        Integer e=1;
        Integer f=1;

        Integer c=new Integer(1);
        Integer d=new Integer(1);
        System.out.println(a==b);
        System.out.println(c==a);
        System.out.println(d==a);
        System.out.println(c==d);
        System.out.println(a==e);
        System.out.println("---------------------");
        System.out.println(e==f);
        System.out.println(e==c);
        System.out.println(e==d);
        System.out.println(c==d);
    }
}
