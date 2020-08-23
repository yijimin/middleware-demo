package com.test.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HelloService helloService=new HelloServiceImpl();

        RpcProxyServer proxyServer=new RpcProxyServer();
        proxyServer.publish(helloService,8080);
    }
}
