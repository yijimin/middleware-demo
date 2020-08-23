package com.test.demo.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 21:13 2020/7/5
 * @Modified By
 **/
public class MyProducer {

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // 连接IP
        connectionFactory.setHost("192.168.1.9");
        // 连接端口
        connectionFactory.setPort(5672);
        // 虚拟机
        connectionFactory.setVirtualHost("my_vhost");
        // 用户和密码
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        // 建立连接
        Connection connection = connectionFactory.newConnection();
        // 创建消息通道
        Channel channel = connection.createChannel();
        // 发送消息
        String msg = "Hello world, Rabbit MQ";
        // String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(EXCHANGE_NAME,"my.test.key",null,msg.getBytes());

        // 关闭
        channel.close();
        connection.close();
    }
}
