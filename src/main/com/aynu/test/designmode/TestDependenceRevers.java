package main.com.aynu.test.designmode;
/**
 * 依赖倒转
 */

public class TestDependenceRevers {

    public static void main(String[] args) {
        //测试方法一  //构造方法中
        TvStationName tv=new TvStationName();

        //Tv tvs=new Tv(tv);
        //tvs.open();
        //测试方法二   //
        /*Tv tvs=new Tv();
        tvs.setTvStation(tv);
        tvs.open();*/
        //测试方法三
        Tv tvs=new Tv();
        tvs.open(tv);
    }
}

class TvStationName implements TvStation{

    @Override
    public void show() {
        System.out.println("我打开了电视台");
    }
}
//方法一 通过构造器
/*interface  TvTurnOff{
    public void open();
}
interface TvStation{
    public void show();
}
class Tv implements TvTurnOff{

    public TvStation tvStation;
    public Tv(TvStation tvStation){
        this.tvStation=tvStation;
    }

    @Override
    public void open() {
        this.tvStation.show();
    }
}*/
//方法二 通过接口传递
interface TvTurnOff{
    public void open(TvStation tvStation);
}
interface TvStation{
    public void show();
}
class Tv implements TvTurnOff{

    @Override
    public void open(TvStation tvStation) {
        tvStation.show();
    }
}
//方法三
//通过setter方法传递
/*
interface TvTurnOff{
    public void open();

    public void setTvStation(TvStation tvStation);
}
interface TvStation{
    public void show();
}
class Tv implements TvTurnOff{
    public TvStation tvStation;
    @Override
    public void open() {
        this.tvStation.show();
    }

    @Override
    public void setTvStation(TvStation tvStation) {
        this.tvStation=tvStation;
    }
}
*/
