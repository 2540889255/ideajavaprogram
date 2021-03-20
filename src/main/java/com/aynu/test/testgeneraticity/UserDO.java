package com.aynu.test.testgeneraticity;


import java.util.List;

public class UserDO<T> {

    private Long length;

    private List<T> users;

    public UserDO() {
    }

    public UserDO(Long length, List<T> users) {
        this.length = length;
        this.users = users;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }
}
