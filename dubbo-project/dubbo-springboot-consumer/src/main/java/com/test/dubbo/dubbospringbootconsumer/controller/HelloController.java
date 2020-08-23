package com.test.dubbo.dubbospringbootconsumer.controller;

import com.test.dubbo.SayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 13:31 2020/7/24
 * @Modified By
 **/
@RestController
public class HelloController {

    // check不检查对应的provider是否启动
    @Reference(timeout = 1,cluster = "failfast",mock = "com.test.dubbo.dubbospringbootconsumer.service.SayHelloServiceMock",check = false)
    private SayHelloService sayHelloService;

    @GetMapping("/hello")
    public String hello(){
        return sayHelloService.sayHello();
    }

}
