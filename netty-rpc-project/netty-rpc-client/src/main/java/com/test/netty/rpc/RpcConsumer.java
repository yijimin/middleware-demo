package com.test.netty.rpc;

import com.test.netty.rpc.service.RpcHelloService;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 13:22 2020/8/22
 * @Modified By
 **/
public class RpcConsumer {

    public static void main(String[] args) {
        RpcHelloService rpcHello = RpcProxy.create(RpcHelloService.class);

        System.out.println(rpcHello.hello("Tom"));
    }
}
