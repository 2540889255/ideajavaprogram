package main.com.aynu.test.designmode;

public class DeliveryClient {

    public static void main(String[] args) {
        DeliveryHandler deliveryHandler=new ConCreatDeliveryHandler();
        DeliveryHandler deliveryHandler1=new ConCreatDeliveryHandler();

        deliveryHandler.setDeliveryHandler(deliveryHandler1);
        deliveryHandler.dink();

    }
}
