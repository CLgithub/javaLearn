package com.cl.javabasis.day23udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 在java中网络通讯也称为socket（套接字，插座）通讯，要求通讯的两台机器都要安装socket
 
 不同的协议有不同的插座（socket）
 
 UDP用户数据报协议：1无连接，2不可靠，3传输层
 TCP传输控制协议：1面向连接，2可靠，3传输层，4基于字节流
 
 UDP通讯协议的特点：
	 1.将数据极其源和目的封装为数据包，不需要建立连接。比如：广播📢，feiq聊天，游戏🎮……
	 2.每个数据包大小限制在64K中
	 3.因为无连接，所以不可靠
	 4.因为不需要建立连接，所以速度快
	 5.udp通讯是不分服务端与客户端的，只分发送端与接收端
	 
 udp协议下的Socket：
 	DatagramSocket(udp插座服务)
 	DatagramPacket(数据包类)
 		DatagramPacket(buf, length, address, port)
 		buf:发送的数据内容
 		length：发送数据的大小。
 		address：发送的目的ip地址对象
 		address：端口号
	 
 发送端的使用步骤：
 	1.建立udp的服务
 	2.准备数据，把数据封装到数据包中 发送端端数据包要带上ip与端口号
 	3.调用udp的服务发送数据包
 	4.关闭资源

 */
//发送端
public class Demo1Sender {
	public static void main(String[] args) throws IOException {
		//建立udp的服务
		DatagramSocket socket=new DatagramSocket();
		//准备数据，把数据封装到数据包中。
		String data = "测试数据fdsfsaffdsa 分发大发";
		//创建了一个数据包
		DatagramPacket datagramPacket=new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 9090);
		//调用udp的服务发送数据包
		socket.send(datagramPacket);
		//关闭资源---实际上就是释放占用的端口号
		socket.close();
		
	}
}
