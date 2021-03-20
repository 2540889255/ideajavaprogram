package com.aynu.test.service;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 测试类似于服务注册中心服务调用
 * @author admin
 */
public interface ISayService extends Remote {

    public String sayHello(String name) throws RemoteException;
}
