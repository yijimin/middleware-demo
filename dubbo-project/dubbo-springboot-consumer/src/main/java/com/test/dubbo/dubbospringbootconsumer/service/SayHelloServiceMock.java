package com.test.dubbo.dubbospringbootconsumer.service;

import com.test.dubbo.SayHelloService;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 13:55 2020/7/24
 * @Modified By
 **/
public class SayHelloServiceMock implements SayHelloService {
    @Override
    public String sayHello() {
        return "系统繁忙，请稍后再试";
    }
}
