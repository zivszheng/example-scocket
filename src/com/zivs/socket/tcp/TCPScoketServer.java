package com.zivs.socket.tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: tcp scoket 通讯服务端
 * @author: zivs.zheng
 * @create: 2018-07-08 21:03
 */
public class TCPScoketServer {

    public static void main(String[] args) throws Exception {
        // 1.创建socket服务端
        ServerSocket server = new ServerSocket(32001);

        // 2.监听链接（阻塞方法），有请求过来建立链接，返回与之对应的socket进行通讯
        Socket socket = server.accept();

        // 3.获取输入流，读取数据
        InputStream stream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = stream.read(bytes);
        String host = socket.getInetAddress().getHostAddress();

        // 4.打印接收数据
        System.err.println("receive from " + host + " data : " + new String(bytes, 0, len));

        // 5.资源释放
        stream.close();
        socket.close();
        server.close();
    }
}
