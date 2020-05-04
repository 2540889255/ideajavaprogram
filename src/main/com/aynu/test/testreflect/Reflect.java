package main.com.aynu.test.testreflect;

import java.lang.reflect.Field;

public class Reflect {



    public static void main(String[] args) {
        Hero hero=new Hero(119,"小兰");

        try {
            Field name = hero.getClass().getDeclaredField("id");
            name.setAccessible(true);
            System.out.println(name.get(hero));
            //name.set(hero,"小黑");
            //System.out.println(hero.name);
            //System.out.println(hero.getId());
        }catch (Exception e){

        }
    }
}
