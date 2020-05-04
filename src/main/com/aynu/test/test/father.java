package main.com.aynu.test.test;

public class father {

    public  static  int A=1;

    static {
        A=2;
    }

    public father(){
        A=3;
    }

    public Say say(){
        //Say say=new Say();
        Say say=new Say() {
            @Override
            public void saysome() {
                System.out.println("这是父类中的saysome方法");
            }
        };
        return say;
    }

    public  static  void staticmenth(){
        System.out.println("这是父类的静态方法");
    }

    public  void quick(){
        System.out.println("这是父类的普通方法");
    }

    public  int show(){
        System.out.println("这是父类的方法");
        return 1;
    }
}
