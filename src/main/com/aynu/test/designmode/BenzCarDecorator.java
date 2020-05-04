package main.com.aynu.test.designmode;

public class BenzCarDecorator extends CarDecorator{


    @Override
    public void print() {
        System.out.println("奔驰车碰了漆");
    }

    @Override
    public void flush() {
        System.out.println("奔驰车清洗完毕");
    }
}
