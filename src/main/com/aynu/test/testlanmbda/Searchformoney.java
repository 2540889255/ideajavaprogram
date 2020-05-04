package main.com.aynu.test.testlanmbda;

public class Searchformoney implements Searchfor<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getMoney()>3500;
    }
}
