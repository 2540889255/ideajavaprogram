package com.aynu.test.designmode;

public class BookNoDisCount extends BookLibraryStore {

    public BookNoDisCount(String name,Double price) {
        super(name,price);
    }



    @Override
    public void disCount() {
        System.out.println(price*10);
    }
}
