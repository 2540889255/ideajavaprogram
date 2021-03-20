package com.aynu.test.designmode.presenttree;

/**
 * @Auther: LC
 * @Date : 2021 02 23 17:35
 * @Description : com.aynu.test.designmode.presenttree
 * @Version 1.0
 */
public class RouteA implements TaskRouter{

    @Override
    public void Router(Task task) {

    }


    public static void main(String[] args) {
        TaskA taskA=new TaskA();
        TaskB taskB=new TaskB();


        /*if (taskA.getType()==1){
            System.out.println("taskA");
            new TaskAhandler().handler(taskA);
        }
        if (taskA.getType()==2){
            System.out.println("taskB");
        }*/

        /*new TaskAhandler(new TaskBhandler(null).handler(taskA));*/


    }
}
