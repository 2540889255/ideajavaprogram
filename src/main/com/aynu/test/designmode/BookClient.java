package main.com.aynu.test.designmode;

public class BookClient {

    public static void main(String[] args) {
        BookLibraryStore bookLibraryStore=new BookFixDisCount("红楼梦",10.0);
        bookLibraryStore.disCount();
    }
}
