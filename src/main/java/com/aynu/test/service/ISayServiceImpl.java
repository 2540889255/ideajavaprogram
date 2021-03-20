package com.aynu.test.service;

import java.rmi.RemoteException;

/**
 * 注册进服务中心的调用service的实现类
 * @author admin
 */
public class ISayServiceImpl implements ISayService{

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.printf("the name is "+name);
        return "the name is "+name;
    }
}
