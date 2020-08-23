package com.test.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 20:37 2020/8/5
 * @Modified By
 **/
public class ProcessorHandler implements Runnable {


    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        try {
            // 读到内存中
            inputStream = new ObjectInputStream(socket.getInputStream());
            //输入流中应该有什么？
            //请求哪个类，方法名称、参数
            RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();
            Object result = invoke(rpcRequest); //反射调用本地服务

            // 输出，写出到流中
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws Exception {
        //反射调用
        Object[] args = rpcRequest.getParameters();//拿到客户端请求的参数
        Class<?>[] types = new Class[args.length];//获得每个参数的类型
        for(int i=0;i<args.length;i++){
            types[i]=args[i].getClass();
        }
        Class clazz = Class.forName(rpcRequest.getClassName()); //根据请求的类进行加载
        Method method = clazz.getMethod(rpcRequest.getMethodName(),types); //sayHello找到这个类中的方法
        Object result = method.invoke(service,args);//HelloServiceImpl 进行反射调用

        return result;
    }
}
