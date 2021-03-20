package com.aynu.test.service;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 注册中心的消费者
 * @author admin
 */
public class SayConsumer {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //注册中心the
        Registry registry = LocateRegistry.getRegistry(999);
        //发现服务
        ISayService sayService = (ISayService)registry.lookup("sayService");
        //掉起服务
        String s = sayService.sayHello("xiaohei");
        System.out.printf("the result is "+s);
    }
}
