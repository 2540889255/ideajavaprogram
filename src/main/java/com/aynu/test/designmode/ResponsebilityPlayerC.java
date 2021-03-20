package com.aynu.test.designmode;

/**
 * @Auther: LC
 * @Date : 2021 01 31 11:58
 * @Description : com.aynu.test.designmode
 * @Version 1.0
 */
public class ResponsebilityPlayerC extends ResponsebilityChain{

    public ResponsebilityPlayerC(ResponsebilityChain responsebilityChain) {
        setResponsebilityChain(responsebilityChain);
    }

    @Override
    public void handler(int value) {

        if (value==3){
            System.out.println("this is c handler");
        }else{
            System.out.println("this is last handler");
        }
    }
}
