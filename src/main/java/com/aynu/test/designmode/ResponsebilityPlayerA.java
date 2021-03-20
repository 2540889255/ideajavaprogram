package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 01 31 11:58
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 */
public class ResponsebilityPlayerA extends ResponsebilityChain {

    public ResponsebilityPlayerA(ResponsebilityChain responsebilityChain) {
        setResponsebilityChain(responsebilityChain);
    }

    @Override
    public void handler(int value) {

        if (value==1){
            System.out.println("this is a handler");
        }else {
            System.out.println("this is a handler");
            responsebilityChain.handler(value);
        }
    }
}
