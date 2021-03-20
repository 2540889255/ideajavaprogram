package com.aynu.test.designmode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

public class SujectObject implements Subject{

    HashMap<String,Obser> hashMap=new HashMap<String,Obser>();

    @Override
    public void click() {

        hashMap.forEach( (x,y) ->{
            hashMap.get(x).listener(this);
        });
    }

    @Override
    public void setObser(Obser obser) {

        this.hashMap.put(obser.getObjectName(),obser);
    }

    @Override
    public void rmObject(Obser obser) {
        this.hashMap.remove(obser.getObjectName());
    }


    @Test
    public void show(){
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("1","1");
        hashMap.put("2","2");
        hashMap.put("3","3");
        hashMap.put("4","4");

        hashMap.forEach( (x,y) -> {
            System.out.println(x+""+y);
        });


    }
}
