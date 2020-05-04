package main.com.aynu.test.testinterfaces;

import java.util.ArrayList;

public class Testinnerclass {

    private int a;

    private ArrayList<Integer> list=new ArrayList<Integer>();

    public int b;


    public void fill(){
        for (int i=0;i<11;i++){
            list.add(i);
        }
    }

    public  void  show(){
        Testinnerclass.Innerson innerson=this.new Innerson();
        innerson.show();
    }

    public class Innerson{
        private  int i;

        public void show(){
            int a=list.get(1);
            System.out.println(a);
        }

    }

    public static void main(String[] args) {
        Testinnerclass testinnerclass=new Testinnerclass();

        Testinnerclass.Innerson innerson=testinnerclass.new Innerson();



        //innerson.

        //testinnerclass.fill();
        //testinnerclass.show();
    }

}
/*
class a extends Testinnerclass.Innerson {

    public void show(){
        list.add(2);
    }
}*/
