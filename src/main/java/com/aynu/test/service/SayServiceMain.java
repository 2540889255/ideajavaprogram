package com.aynu.test.service;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SayServiceMain {


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        //实例化，要暴露给远程的方法,接口
        ISayService sayService=new ISayServiceImpl();
        //开启本地服务
        ISayService iSayService = (ISayService)UnicastRemoteObject.exportObject(sayService, 666);
        //服务注册中心
        Registry registry = LocateRegistry.createRegistry(999);
        registry.rebind("sayService",iSayService);
    }
}
