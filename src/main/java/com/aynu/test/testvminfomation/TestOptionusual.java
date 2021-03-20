package com.aynu.test.testvminfomation;

public class TestOptionusual {

    public TestOptionusual(Human human) {
        human.sayHello();
    }

    public TestOptionusual() {
    }

    public static  class Human{
        public void sayHello() {
            System.out.println("我是一个人类");
        }
    }

    public static class Man extends Human {
        public void sayHello() {
            System.out.println("我是一个男人");
        }
    }

    public static class Woman extends Human {
        public void sayHello() {
            System.out.println("我是一个女人");
        }
    }

    public void sayHello(Human human){
        System.out.println("我是一个人类");
        human.sayHello();
    }
    public void sayHello(Man man){
        System.out.println("我是一个男人");
        man.sayHello();
    }
    public void sayHello(Woman woman){
        System.out.println("我是一个女人");
        woman.sayHello();
    }
    public static void main(String[] args) {
        Human man=new Man();
        Human woman=new Woman();
        /*Human human=new Human();
        man.sayHello();
        woman.sayHello();

        TestOptionusual testman=new TestOptionusual(man);
        TestOptionusual testwoman=new TestOptionusual(woman);



        testOptionusual.sayHello(human);*/
        TestOptionusual testOptionusual=new TestOptionusual();
        testOptionusual.sayHello(man);
        //testOptionusual.sayHello(woman);


    }
}
