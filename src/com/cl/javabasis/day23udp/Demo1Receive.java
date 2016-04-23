package com.cl.javabasis.day23udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 接收端
 	1.接收udp的服务,并且要监听一个端口
 	2.准备空的数据包，用于存储数据
 	3.调用udp的服务接收数据
 	4.关闭资源
 */
public class Demo1Receive {
	public static void main(String[] args) throws IOException {
		// 接收udp的服务,并且要监听一个端口
		DatagramSocket socket = new DatagramSocket(9090);
		// 准备空的数据包，用于存储数据
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		// 调用udp的服务接收数据
		socket.receive(datagramPacket);// 数据实际上就是存储到了byte的字节数组buf,这个方法是个阻塞型的方法，没有接收到数据会一直阻塞
		System.out.println("接受端接收到的数据：" + new String(buf, 0, datagramPacket.getLength()));//获取数据包存储了多少字节
		 //关闭资源
		socket.close();
	}
}
