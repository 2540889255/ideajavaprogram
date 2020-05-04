package main.com.aynu.test.test;

/**
 * 测试String类型在常量池的引用
 */
public class TestString {

    public static void main(String[] args) {
        String a="one";
        String b="two";

        String c="one"+"two";
        String d=a+b;
        String f=a+"two";

        String e="onetwo";
        System.out.println(d==e);
        System.out.println(c==e);

        System.out.println(e==f);
        String string=new String("qweq");
    }
}
