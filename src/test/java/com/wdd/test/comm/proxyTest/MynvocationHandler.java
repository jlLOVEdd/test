package com.wdd.test.comm.proxyTest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MynvocationHandler implements java.lang.reflect.InvocationHandler {

    private Object target;

    public MynvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("-------------before-------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------after--------------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
