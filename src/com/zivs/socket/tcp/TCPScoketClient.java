package com.zivs.socket.tcp;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description: tcp scoket 通讯客户端
 * @author: zivs.zheng
 * @create: 2018-07-08 21:03
 */
public class TCPScoketClient {

    public static void main(String[] args) throws Exception {
        // 1.创建socket客户端
        Socket client = new Socket(InetAddress.getLocalHost(), 32001);

        // 2.通過socket建立数据传输通道，获取输出流写数据
        String data = "Hello I'm TCP message ...";
        OutputStream stream = client.getOutputStream();
        stream.write(data.getBytes());

        // 3.释放资源
        stream.close();
        client.close();
    }
}
