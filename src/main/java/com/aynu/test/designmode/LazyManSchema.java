package com.aynu.test.designmode;

/**
 * 懒汉模式
 */
public class LazyManSchema {

    private static LazyManSchema lazyManSchema=null;

    private LazyManSchema(){

    }

    public synchronized static LazyManSchema getInstance(){
        if (lazyManSchema==null){
            lazyManSchema=new LazyManSchema();
        }

        return lazyManSchema;
    }
}
