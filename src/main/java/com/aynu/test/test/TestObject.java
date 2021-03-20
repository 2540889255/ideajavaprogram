package com.aynu.test.test;


public class TestObject {

    Day day;
    public TestObject(Day day){
        this.day=day;
    }

    public void tell(){
        if (day==Day.Monday){
            System.out.println("今天是星期一，要开始上班工作了");
        }
        if (day==Day.Tuesday){
            System.out.println("金泰你星期二，还是工作的一天");
        }
        if (day==Day.thursday){
            System.out.println("今天是星期三，也是工作的一天");
        }
        if (day==Day.Wedensday) {
            System.out.println("今天是星期四马上要放假了");
        }
        if (day==Day.firday){
            System.out.println("放假");
        }
    }

    public static void main(String[] args) {
        TestObject testObject=new TestObject(Day.thursday);
        testObject.tell();


    }
}
