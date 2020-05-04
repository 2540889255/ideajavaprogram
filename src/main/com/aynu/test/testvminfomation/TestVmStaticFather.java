package main.com.aynu.test.testvminfomation;

/**
 * 这个测试是为了测试字段没有多态性
 */
public class TestVmStaticFather {

    static class Father{
        //public  static int money=1;
        public  int money=1;

        public Father(){
           // money=2;
            showMoney();
        }

        public void showMoney() {
            System.out.println("father have money："+money);
        }
    }

     static class Son extends Father{
        //public  static int money=3;
        public  int money=3;

        public Son(){
            money=4;
            showMoney();
        }

        public void showMoney(){
            System.out.println("son have money："+money);
        }
    }


    public static void main(String[] args) {
        Father father=new Son();
        father.showMoney();
    }

}


