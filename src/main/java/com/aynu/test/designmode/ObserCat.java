package com.aynu.test.designmode;

public class ObserCat implements Obser{

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getObjectName() {
        return this.name;
    }

    @Override
    public void listener(Subject subject) {
        System.out.println("i am a cat i find the message");
    }
}
