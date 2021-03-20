package com.aynu.test.testCollection;


/**
 * 测试类
 */
public class Man {

    static final String SERIALIZEDUID="123456789";

    int id =1;

    public Man() {
    }

    @Override
    public int hashCode() {

        return Integer.valueOf(SERIALIZEDUID);
    }

    @Override
    public boolean equals(Object obj) {

        Man man=(Man) obj;
        if (this.id==man.id){
            return true;
        }
        return false;
    }
}
