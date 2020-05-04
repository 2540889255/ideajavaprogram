package main.com.aynu.test.designmode;

public abstract class BookLibraryStore {

    public Double price;

    public String name;

    public BookLibraryStore(String name,Double price){
        this.name=name;
        this.price=price;
    }

    public abstract void disCount();

}
