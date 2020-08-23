package com.test.rpc;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 20:22 2020/8/5
 * @Modified By
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String content) {
        return "Hello "+ content ;
    }
}
