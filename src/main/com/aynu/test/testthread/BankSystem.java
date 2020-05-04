package main.com.aynu.test.testthread;

public class BankSystem {


    public static void main(String[] args) {
        Bank bank=new Bank();
        new Thread(new People(bank)).start();
        new Thread(new People(bank)).start();

    }
}
