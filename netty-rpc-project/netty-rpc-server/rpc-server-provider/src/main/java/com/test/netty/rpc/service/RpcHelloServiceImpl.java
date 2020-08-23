package com.test.netty.rpc.service;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 12:11 2020/8/22
 * @Modified By
 **/
public class RpcHelloServiceImpl implements RpcHelloService {
    @Override
    public String hello(String name) {
        return "Hello:"+name;
    }
}
