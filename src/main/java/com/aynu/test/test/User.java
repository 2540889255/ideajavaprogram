package com.aynu.test.test;

/**
 * @Auther: LC
 * @Date : 2021 02 11 11:10
 * @Description : com.aynu.test.test
 * @Version 1.0
 */
public class User {

    private String name;

    private String id;

    public String say;

    public User() {
    }

    public User(String name, String id, String say) {
        this.name = name;
        this.id = id;
        this.say = say;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", say='" + say + '\'' +
                '}';
    }
}
