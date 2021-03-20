package com.aynu.test.test;


import java.util.*;


public class Son{
    private int state;

    private String name;

    private int year;

    public Son(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Son{" +
                "state=" + state +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public static void main(String[] args) {

        List<Son> list= Arrays.asList(new Son("Ming",38),
        new Son("Hongbai",25),new Son("Bai",43)
        );
        list.forEach(x -> System.out.println(x.toString()));
        list.sort(new Comparator<Son>() {
            @Override
            public int compare(Son o1, Son o2) {
                return o1.year>o2.year?1:-1;
            }
        });
        /*list.sort(new Comparator<Son>() {
            @Override
            public int compare(Son o1, Son o2) {
                return new Integer(o1.year).compareTo(o2.year);
            }
        });*/
        list.forEach(x -> System.out.println(x.toString()));
        /*HashMap<Son,String> hashMap=new HashMap<Son,String>();

        for (Son son:list
             ) {
            hashMap.put(son,"");
        }*/
    }
}