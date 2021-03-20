package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 01 31 11:57
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 * 责任链模式
 */

public abstract class ResponsebilityChain {

    protected ResponsebilityChain responsebilityChain;

    public void setResponsebilityChain(ResponsebilityChain responsebilityChain){
        this.responsebilityChain=responsebilityChain;
    }

    public abstract void handler(int value);

    public static void main(String[] args) {


        ResponsebilityChain responsebilityChain=
                new ResponsebilityPlayerA(new ResponsebilityPlayerB(new ResponsebilityPlayerC(null)));

        responsebilityChain.handler(3);
    }
}
