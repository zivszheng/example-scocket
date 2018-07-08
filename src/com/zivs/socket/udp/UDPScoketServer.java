package com.zivs.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description: udp scoket 通讯服务端
 * @author: zivs.zheng
 * @create: 2018-07-08 21:03
 */
public class UDPScoketServer {

    public static void main(String[] args) throws Exception {
        // 1.创建服务端socket对象 DatagramSocket
        DatagramSocket server = new DatagramSocket(32001);

        // 2.接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        server.receive(packet);

        // 3.数据包解析
        byte[] data = packet.getData();
        String host = packet.getAddress().getHostAddress();

        // 4.打印接收数据
        System.err.println("receive from " + host + " data : " + new String(data));

        // 5.释放资源
        server.close();
    }
}
