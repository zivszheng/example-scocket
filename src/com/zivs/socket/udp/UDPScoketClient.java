package com.zivs.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description: udp scoket 通讯客户端
 * @author: zivs.zheng
 * @create: 2018-07-08 21:03
 */
public class UDPScoketClient {

    /**
     *  UDP（user datagram protocol）的中文叫用户数据报协议，属于传输层。
     *  UDP是面向非连接的协议，它不与对方建立连接，而是直接把我要发的数据报发给对方。
     *  所以UDP适用于一次传输数据量很少、对可靠性要求不高的或对实时性要求高的应用场景。
     *  正因为UDP无需建立类如三次握手的连接，而使得通信效率很高。
     */


    public static void main(String[] args) throws Exception {
        // 1.创建客户端socket对象 DatagramSocket
        DatagramSocket client = new DatagramSocket();

        // 2.打包发送数据
        String data = "Hello I'm UDP message ...";
        DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 32001);

        // 3.发送打包好了的数据
        client.send(packet);

        // 4.释放资源
        client.close();
    }
}
