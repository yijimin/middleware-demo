package com.test.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yijimin
 * @Description:
 * @Date: Created in 20:24 2020/8/5
 * @Modified By
 **/
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void  publish(Object servic,int port){

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            //不断接受请求
            while (true){
                Socket socket = serverSocket.accept();//BIO
                //每一个socket 交给一个processorHandler来处理
                executorService.execute(new ProcessorHandler(socket,servic));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
