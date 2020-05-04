package main.com.aynu.test.generaticity;

public class father<T> {

    private T t;

    private void add(T t) {
        this.t = t;
    }

    private <U> void show(U u) {
        System.out.println(u.getClass().getName());
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        father<Integer> father = new father<Integer>();
        father.add(new Integer(101));
        father.show("something、");
        father<String> father1 = new father<>();

    }


}