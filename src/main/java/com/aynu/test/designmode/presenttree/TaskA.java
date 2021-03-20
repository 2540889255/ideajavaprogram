package com.aynu.test.designmode.presenttree;

/**
 * @Auther: LC
 * @Date : 2021 02 23 17:28
 * @Description : com.aynu.test.designmode.presenttree
 * @Version 1.0
 */
public class TaskA implements Task{

    private int type=1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void doSomeThing() {
        System.out.println("任务一，开车");
    }
}
