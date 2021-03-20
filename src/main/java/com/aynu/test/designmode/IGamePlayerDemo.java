package com.aynu.test.designmode;

public class IGamePlayerDemo {


    public static void main(String[] args) {
        GamePlayer gamePlayer=new GamePlayer("李逍遥");
        GamePlayerProxy gamePlayerProxy=new GamePlayerProxy(gamePlayer);
        gamePlayerProxy.killBoss();
        gamePlayerProxy.liveUp();
    }
}
