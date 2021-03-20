package com.aynu.test.designmode;

public class ObserObject implements Obser{

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
        System.out.println("i am a dog i find the message");
    }
}
