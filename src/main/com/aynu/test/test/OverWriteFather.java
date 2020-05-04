package main.com.aynu.test.test;

public class OverWriteFather {

    public int money=1;

    public static int age=1;

    public OverWriteFather(){
        money=3;
        age=3;
        show();
    }

    public void show(){
        System.out.println("我是father 我有钱"+money);
        System.out.println("我是father 我年龄"+age);
    }



    static class OverWriteSon extends OverWriteFather{

        public int money=0;

        public int age=0;
        public OverWriteSon(){
            money=2;
            age=2;
            show();
        }

        public void show(){
            System.out.println("我是Son 我有钱"+money);
            System.out.println("我是Son 我年龄"+age);
        }
    }

    public static void main(String[] args) {
        OverWriteFather father=new OverWriteSon();
        System.out.println("当前father 的钱为"+father.money);
        System.out.println("当前father 的钱为"+father.age);
    }
}
