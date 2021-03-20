package com.aynu.test.testVM;

//创建一个单例模式
public class CreateSington {

    private volatile static CreateSington instance;

    public static CreateSington getInstance(){
                if (instance==null){
                    synchronized (CreateSington.class){
                        if (instance==null){
                            instance=new CreateSington();
                        }
                    }
                }
                return  instance;
    }

    public static void main(String[] args) {
        CreateSington.getInstance();
    }
}
