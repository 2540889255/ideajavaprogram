package com.aynu.test.designmode.presenttree;

/**
 * @Auther: LC
 * @Date : 2021 02 23 17:39
 * @Description : com.aynu.test.designmode.presenttree
 * @Version 1.0
 */
public class TaskBhandler implements TaskHandler{

    TaskHandler taskHandler;

    public TaskBhandler(TaskHandler taskHandler) {
        this.taskHandler = taskHandler;
    }

    @Override
    public void handler(Task task) {

    }
}
