package main.com.aynu.test.testlanmbda;

public class Searchforage implements Searchfor<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>35;
    }
}
