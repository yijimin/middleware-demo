package com.test.demo.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 21:26 2020/7/5
 * @Modified By
 **/
public class MyConsumer {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";

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

        // 声明交换机
        // String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",false, false, null);

        // 声明队列
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" Waiting for message....");

        // 利用routing key绑定队列和交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"my.test.key");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };
        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
