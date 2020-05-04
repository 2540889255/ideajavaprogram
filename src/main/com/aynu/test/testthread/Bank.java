package main.com.aynu.test.testthread;

public class Bank {
     double money=1000;

    public synchronized void add(double addmoney){
        this.money+=addmoney;
        this.show();
    }
    public synchronized   void remove(double removemoney){
        this.money-=removemoney;
        this.show();
    }

    public  void show(){
        System.out.println("当前银行的存款数字为"+this.money);
    }
}
