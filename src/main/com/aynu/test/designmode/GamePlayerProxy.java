package main.com.aynu.test.designmode;

public class GamePlayerProxy implements IGamePlayer {

    private GamePlayer gamePlayer;

    public GamePlayerProxy(GamePlayer gamePlayer){
        this.gamePlayer=gamePlayer;
    }

    @Override
    public void killBoss() {
        this.before();
        this.gamePlayer.killBoss();
        this.after();
    }

    @Override
    public void liveUp() {
        this.before();
        this.gamePlayer.liveUp();
        this.after();
    }

    public void before(){
        System.out.println("当前时间是"+System.currentTimeMillis());
    }

    public void after(){
        System.out.println("当前时间是"+System.currentTimeMillis());
    }
}
