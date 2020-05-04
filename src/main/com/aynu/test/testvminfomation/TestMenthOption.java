package main.com.aynu.test.testvminfomation;

public class TestMenthOption {

    public TestMenthOption(Human human) {
        human.sayHello();
    }

    public static abstract class Human{
        public void sayHello() {
            System.out.println("我是一个人类");
        }
    }

    public static class Man extends Human{
        @Override
        public void sayHello() {
            System.out.println("我是一个男人");
        }
    }

    public static class Woman extends Human{
        @Override
        public void sayHello() {
            System.out.println("我是一个女人");
        }
    }

    public static void main(String[] args) {
        Human man=new Man();
        Human woman=new Woman();

        man.sayHello();
        woman.sayHello();

        TestMenthOption testman=new TestMenthOption(man);
        TestMenthOption testwoman=new TestMenthOption(woman);



    }
}
