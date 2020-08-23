package com.test.dubbo.dubboprovider.service;

import com.test.dubbo.SayHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 12:59 2020/7/24
 * @Modified By
 **/
@Service
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Dubbo";
    }
}
