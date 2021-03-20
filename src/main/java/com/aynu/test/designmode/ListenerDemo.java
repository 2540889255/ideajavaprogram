package com.aynu.test.designmode;

public class ListenerDemo {


    public static void main(String[] args) {
        SujectObject  sujectObject=new SujectObject();

        ObserObject dog=new ObserObject();
        dog.setName("dog");
        ObserCat cat=new ObserCat();
        cat.setName("cat");
        sujectObject.setObser(dog);
        sujectObject.setObser(cat);

        sujectObject.click();
    }
}
