package com.aynu.test.test;

public enum Day {


    Monday,

    Tuesday,

    Wedensday,

    thursday,

    firday;

    Day(){
        System.out.println("枚举的构造方法被调用");
    }
    static {
        System.out.println("枚举的静态方法被调用");
    }


    public static void main(String[] args) {
        Day[] values = Day.values();
        for (Day d:values
             ) {
            d.toString();
        }
    }
}
