package com.test.rpc;

import java.lang.reflect.Proxy;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 21:03 2020/8/5
 * @Modified By
 **/
public class RpcProxyClient {

    public<T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},
                new RemoteInvocationHandler(host,port));
    }
}
