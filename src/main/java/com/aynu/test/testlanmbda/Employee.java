package com.aynu.test.testlanmbda;

import java.util.Objects;

public class Employee {

    private String name;

    private Integer age;

    private Double money;

    private Status status;
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Integer age, Double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Employee(String name, Integer age, Double money, Status status) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(money, employee.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money);
    }

    public enum Status{
        BUSY,
        FREE,
        VOCATION;

    }
}
