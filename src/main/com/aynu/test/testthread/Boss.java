package main.com.aynu.test.testthread;

public class Boss {

    public static void main(String[] args) {

        Drop drop=new Drop();

        (new Thread(new Product(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
