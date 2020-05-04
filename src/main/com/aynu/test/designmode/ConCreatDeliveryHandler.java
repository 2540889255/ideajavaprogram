package main.com.aynu.test.designmode;

public class ConCreatDeliveryHandler extends DeliveryHandler {

    @Override
    public void dink() {
        if (deliveryHandler!=null){
            System.out.println("已经喝了酒了");
            super.deliveryHandler.dink();
        }
        else {
            System.out.println("正在请求");
        }
    }
}
