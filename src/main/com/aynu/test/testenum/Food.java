package main.com.aynu.test.testenum;

/**
 * 使用接口来组织枚举
 */
public interface Food {

    public enum CAFE implements Food{MILKCOFE,WATERCOFE,DARKCOFE};

    public enum DINK implements Food{WATER,MILK,CARBONATE};

    public enum EAT implements Food{TOMATO,POTATO};




}
