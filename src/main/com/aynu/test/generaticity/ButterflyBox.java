package main.com.aynu.test.generaticity;

public class ButterflyBox<T> {
    private T t;

    public void add(T t){
        this.t=t;
    }

    public void  show(){
        System.out.println(t.getClass().getName());
    }

    public void somementh(Number number){

    }
}
