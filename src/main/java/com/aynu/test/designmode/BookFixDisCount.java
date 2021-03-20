package com.aynu.test.designmode;

public class BookFixDisCount extends BookLibraryStore {


    public BookFixDisCount(String name, Double price) {
        super(name, price);
    }

    @Override
    public void disCount() {
        System.out.println(price*0.18);
    }
}
