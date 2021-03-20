package com.aynu.test.designmode.presenttree;

/**
 * @Auther: LC
 * @Date : 2021 02 23 17:26
 * @Description : com.aynu.test.designmode.presenttree
 * @Version 1.0
 */
public interface TaskHandler<T,R> {

    public void handler(Task task);

}
