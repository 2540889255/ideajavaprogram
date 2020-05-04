package main.com.aynu.test.designmode;

public class FactoryMethodSchema {

    public static void main(String[] args) {
        FruitFactory appleFactory=new AppleFactory();
        FruitFactory grapeFactory=new GrapeFactory();

        Fruit apple=new Apple();
        Fruit grape=new Grape();

        appleFactory.seed(apple);
        appleFactory.harvest(apple);

        grapeFactory.seed(grape);
        grapeFactory.harvest(grape);

    }
}
