package main.com.aynu.test.test;

public class Son extends father {

    public  static int  B=A;
    public  Son(){
        B=A;
    }
    /*public Say say(){
        //Say say=new Say();
        //return say;
        Saysomething saysomething=new Saysomething();
        saysomething.saysome();
        return  saysomething;
    }*/

    public  void sonsay(){
        System.out.println("这是子类独有的方法");
    }

    public static void staticmenth(){
        System.out.println("这是子类中的静态方法");
    }

    public  void  quick(){
        System.out.println("这是子类的普通方法");
    }


    /*public int show() {
        System.out.println("这是子类重载的方法");
        return "22";
    }*/

    public static void main(String[] args) {
        System.out.println(Son.B);
        System.out.println(new Son().B);
        /*Son son=new Son();
        son.say();

        father son1=new Son();
        son1.say();
        son1.say();*/
        //father father =new Son();
        /*System.out.println();
        Son son =new Son();

        father father=son;
        father.staticmenth();*/


        father father1=new father();
        Son son1 =new Son();
        father1=(father)son1;
        //son1=father1;
        //father1=son1;
        //son1 =(Son)father1;//编译失败
        //son1.quick();

    }


}
