package com.aynu.test.designmode;

public abstract class DeliveryHandler {

    public DeliveryHandler deliveryHandler=null;

    public void setDeliveryHandler(DeliveryHandler deliveryHandler){
        this.deliveryHandler=deliveryHandler;
    }

    public abstract void dink();

}
