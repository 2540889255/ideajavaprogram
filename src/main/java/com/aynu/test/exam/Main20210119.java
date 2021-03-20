package com.aynu.test.exam;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Auther: LC
 * @Date : 2021 03 18 20:00
 * @Description : com.aynu.test.exam
 * @Version 1.0
 */
public class Main20210119 {

    static HashMap<String,String> hashmap=new HashMap();

    static TreeMap<Integer,String> treeMap=new TreeMap<>();

    public static void main(String[] args) throws IOException {

        /*Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            jiexi(name1);
            System.out.println(1);
        }*/


        jiexi("dict:停词:我想,的,得,从,去");
        jiexi("dict:目的地:三亚,北京,上海");
        jiexi("dict:出发地:南京,苏州");
        jiexi("dict:出游类型:跟团游,自由行");
        jiexi("dict:供应商:携程自营");
        jiexi("dict:节假日:春节");
        operation("我想春节从南京去三亚和海口潜水跟团游5天5钻携程自营");
        System.out.println(1);
    }

    public static void jiexi(String name){
        String[] split = name.split(":");
        String[] split1 = split[2].split(",");
        String mudi=split[1];
        for (int i = 0; i < split1.length; i++) {
            hashmap.put(split1[i],mudi);
        }
    }

    /**
     *
     **/
    @Test
    public void test() {
        HashMap hashMap=new HashMap();
        jiexi("dict:停词:我想,的,得,从,去");
        jiexi("dict:目的地:三亚,北京,上海");
        jiexi("dict:出发地:南京,苏州");
        jiexi("dict:出游类型:跟团游,自由行");
        jiexi("dict:供应商:携程自营");
        jiexi("dict:节假日:春节");
        operation("我想春节从南京去三亚和海口潜水跟团游5天5钻携程自营");
        System.out.println(1);
    }

    public static void operation(String name){

        Set<String> strings = hashmap.keySet();

        for (String s:strings
             ) {
            int i = name.indexOf(s);
            treeMap.put(i,hashmap.get(s));
        }

        System.out.println(":["+"]");
        Set<Integer> integers = treeMap.keySet();
        for (Integer i:integers
             ) {
            if (i>0){
                System.out.println(treeMap.get(i)+":["+"]"+hashmap.get(treeMap.get(i)));
            }
        }
    }
    /*public static void jiexi(String name,HashMap hashmap){
        String[] split = name.split(":");
        String[] split1 = split[2].split(",");
        String mudi=split[1];
        for (int i = 0; i < split1.length; i++) {
            hashmap.put(split1[i],mudi);
        }
    }*/
}
