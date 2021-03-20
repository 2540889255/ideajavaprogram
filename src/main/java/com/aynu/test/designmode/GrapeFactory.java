package com.aynu.test.designmode;

public class GrapeFactory implements FruitFactory {
    @Override
    public void seed(Fruit fruit) {
        fruit.grow();
    }

    @Override
    public void harvest(Fruit fruit) {
        fruit.yield();
    }
}
