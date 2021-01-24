package com.zph.demo3;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    public HostMaster hostMaster;

    public void setHostMaster(HostMaster hostMaster) {
        this.hostMaster = hostMaster;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), hostMaster.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前");
        Object result = method.invoke(hostMaster,args);
        System.out.println("执行后");
        return result;
    }
}
