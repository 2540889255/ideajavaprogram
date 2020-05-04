package main.com.aynu.test.testVM;

/**
 * 测试嵌套循环
 */
public class NestClass {

    int a=0;

    public static void main(String[] args) {
        NestClass nestClass=new NestClass();
        nestClass.method();
        System.out.println(nestClass.a);
    }

    public void method(){
        int b=4;
        a++;
        b+=2;
        System.out.println(a);
        System.out.println(b);
    }
}
