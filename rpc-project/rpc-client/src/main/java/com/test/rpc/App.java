package com.test.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RpcProxyClient rpcProxyClient=new RpcProxyClient();

        HelloService helloService = rpcProxyClient.clientProxy
                (HelloService.class, "localhost", 8080);

        String result = helloService.sayHello("Tom");
        System.out.println(result);
    }
}
