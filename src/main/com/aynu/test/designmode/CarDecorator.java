package main.com.aynu.test.designmode;

public abstract class CarDecorator implements Car {

    private Car car=null;

    public abstract void print();

    public abstract void flush();

    @Override
    public void show() {
        this.car.show();
    }
}
