package com.aynu.test.testreflect;

public class Hero {

    private int id =12;

    public String name;

    public Hero(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
