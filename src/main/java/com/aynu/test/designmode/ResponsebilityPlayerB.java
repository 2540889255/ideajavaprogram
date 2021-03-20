package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 01 31 11:58
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 */
public class ResponsebilityPlayerB extends ResponsebilityChain{

    public ResponsebilityPlayerB(ResponsebilityChain responsebilityChain) {
        setResponsebilityChain(responsebilityChain);
    }

    @Override
    public void handler(int value) {
        if (value==2){
            System.out.println("this is b handler");
        }else{
            System.out.println("this is b handler");
            responsebilityChain.handler(value);
        }
    }
}
