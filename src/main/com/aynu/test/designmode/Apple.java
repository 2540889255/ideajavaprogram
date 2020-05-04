package main.com.aynu.test.designmode;

public class Apple implements Fruit {


    @Override
    public void grow() {
        System.out.println("我是苹果我在成长");
    }

    @Override
    public void yield() {
        System.out.println("我是苹果我成熟了");
    }
}
