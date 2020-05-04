package main.com.aynu.test.generaticity;

import main.com.aynu.test.test.Son;
import main.com.aynu.test.testinterfaces.Testinnerclass;

public class CageAnimals<T>{


    /*private Box<Animals> t;

    private void add(Box<Animals> box){
        this.t=box;
    }

    public  void  show(){
        System.out.println(t.getClass().getName());
    }*/
    private T  number;

    public void add(T t){
        this.number=t;
    }

    public void show(){
        System.out.println(number.getClass().getName());
    }


    public static void main(String[] args) {
        /*CageAnimals<Animals> cageAnimals=new CageAnimals<Animals>();
        cageAnimals.add(new Lion());
        cageAnimals.show();
        cageAnimals.add(new Butterfly());
        cageAnimals.show();*/
        CageAnimals<Animals> cageAnimals=new CageAnimals<Animals>();
        LionBox<Lion> lionLionBox =new LionBox<Lion>();
        LionBox<Animals> animalsLionBox=new LionBox<Animals>();
        LionBox<? extends Animals> lionBox =new LionBox<>();
        //animalsLionBox=lionBox;//报错
        lionBox=animalsLionBox;//不报错
        //animalsLionBox=lionLionBox;
        //lionLionBox=animalsLionBox; 两个都不行 恰恰证明了两个没有转换的关系


        Object object=new Object();
        Integer integer=new Integer(1);
        object=integer;
        //cageAnimals=lionLionBox;

        /*Box<Animals> box=new Box<Animals>();
        Box<Butterfly> Bbox=new Box<Butterfly>();
        box.add(new Butterfly());
        box.add(new Lion());
        cageAnimals.add(box);
        cageAnimals.show();
        cageAnimals.add(Bbox);
        cageAnimals.show();*/

    }
}
