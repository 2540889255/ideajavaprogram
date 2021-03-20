package com.aynu.test.designmode;

public class Dog extends Animal {

    @Override
    public void move() {
        System.out.println("我是一条狗我可以移动");
    }

    @Override
    public void eat() {
        System.out.println("我是一条狗我可以吃");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.move();
        dog.eat();

    }
}
