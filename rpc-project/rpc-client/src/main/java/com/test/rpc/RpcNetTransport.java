package com.test.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 21:20 2020/8/5
 * @Modified By
 **/
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request){
        Socket socket=null;
        Object result=null;
        ObjectOutputStream outputStream=null;
        ObjectInputStream inputStream=null;

        try {
            socket = new Socket(host,port);//建立连接

            outputStream = new ObjectOutputStream(socket.getOutputStream());//网络socket
            outputStream.writeObject(request);//序列化
            outputStream.flush();

            // 读取返回值
            inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
