package com.aynu.test.designmode.presenttree;

/**
 * @Auther: LC
 * @Date : 2021 02 23 17:29
 * @Description : com.aynu.test.designmode.presenttree
 * @Version 1.0
 */
public class TaskB implements Task{

    private int type=2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void doSomeThing() {
        System.out.println("任务二；划水");
    }
}
