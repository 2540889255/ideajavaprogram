package com.aynu.test.designmode;

public class GamePlayer implements IGamePlayer{

    String name="";

    public GamePlayer(String name){
        this.name=name;
    }

    @Override
    public void killBoss() {
        System.out.println("我是"+name+"我正在打怪");
    }

    @Override
    public void liveUp() {
        System.out.println("我是"+name+"我升级了");
    }
}
