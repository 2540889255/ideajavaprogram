package main.com.aynu.test.designmode;

public class Grape implements Fruit {
    @Override
    public void grow() {
        System.out.println("我是葡萄我正在成长");
    }

    @Override
    public void yield() {
        System.out.println("我是葡萄我成熟了");
    }
}
