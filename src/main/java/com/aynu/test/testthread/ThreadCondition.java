package com.aynu.test.testthread;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: LC
 * @Date : 2021 02 16 11:19
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 * 测试
 */
public class ThreadCondition {



    public static void main(String[] args) {

        State state=new State();

        RunMethod runMethod=new RunMethod();
        Thread thread=new Thread(
                () ->{
                    runMethod.runA();
                },"A"
        );
        Thread thread1=new Thread(
                () ->{
                    runMethod.runB();
                },"B"
        );
        Thread thread2=new Thread(
                () ->{
                    runMethod.runC();
                },"C"
        );
        thread.start();
        thread1.start();
        thread2.start();
    }
}


//设置判断的状态数字
class State {

    private int states=2;

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

}

class RunMethod {

    ReentrantLock lock=new ReentrantLock();

    State state=new State();

    Logger logger= LoggerFactory.getLogger(ThreadWait.class);

    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();


    public void runA(){
        try {
            lock.lock();
            logger.info(() -> "我是线程A我到达了这");
            while (state.getStates()!=1){
                conditionA.await();
            }
            logger.info(() -> Thread.currentThread().getName()+"线程正在"+"AAAAAAAAAAAAAAAAAAAAAAAAAAA");
            conditionB.signal();
            state.setStates(2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public  void runB(){
        try {
            Thread.sleep(1000);
            lock.lock();
            while (state.getStates()!=2){
                conditionB.await();
            }
            logger.info(() -> Thread.currentThread().getName()+"线程正在"+"BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            conditionC.signal();
            state.setStates(3);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void runC(){
        try {
            lock.lock();
            while (state.getStates()!=3){
                conditionC.await();
            }
            logger.info(() -> Thread.currentThread().getName()+"线程正在"+"CCCCCCCCCCCCCCCCCCCCCCCCCCC");
            conditionA.signal();
            state.setStates(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

