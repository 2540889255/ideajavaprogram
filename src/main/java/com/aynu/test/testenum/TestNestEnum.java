package com.aynu.test.testenum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Random;

public enum  TestNestEnum {

    ONE(Food.CAFE.class),
    TWO(Food.DINK.class),
    THREE(Food.EAT.class);

    private Food[] constants;

    TestNestEnum(Class<? extends Food> aClass) {
        constants = aClass.getEnumConstants();
    }

    public Food  getFood(){
        Random random=new Random();
        System.out.println(random.nextInt(constants.length));
        return constants[random.nextInt(constants.length)];
    }

    public static void main(String[] args) {
        /*TestNestEnum testNestEnum=TestNestEnum.ONE;
        for (int i = 0; i <30 ; i++) {
            System.out.println(testNestEnum.getFood());
        }*/

        EnumSet<TestNestEnum> enumSet=EnumSet.noneOf(TestNestEnum.class);
        enumSet.add(TestNestEnum.ONE);
        for (TestNestEnum test:enumSet
             ) {
            for (int i = 0; i <test.constants.length ; i++) {
                System.out.println(test.constants[i]);
            }
        }

        //new EnumSet<TestNestEnum>(,TestNestEnum.values());
        //测试 EnumMap  的操作
        EnumMap<TestNestEnum,Command> enumMap=new EnumMap<TestNestEnum,Command>(TestNestEnum.class);
        enumMap.put(TestNestEnum.ONE, new Command() {
            @Override
            public void action() {
                System.out.println("这是第一个");
            }
        });
        System.out.println(enumMap.size());
    }

    public interface Command{
        public void action();
    }
}
