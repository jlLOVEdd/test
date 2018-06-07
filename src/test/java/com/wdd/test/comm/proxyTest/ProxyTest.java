package com.wdd.test.comm.proxyTest;

public class ProxyTest {
    public static void main(String[] args) {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        MynvocationHandler mynvocationHandler = new MynvocationHandler((Object) providerService);
        ProviderService p = (ProviderService) mynvocationHandler.getProxy();
        p.add();
    }
}
