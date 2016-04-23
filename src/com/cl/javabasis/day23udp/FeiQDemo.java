package com.cl.javabasis.day23udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 
 每个网络程序都有自己所处理的特定格式数据，如果接收到到数据不符合指定的格式，那么就会被当成垃圾数据丢弃（加密。。）
 
 飞Q接收的数据格式：
	 version:time:sender:ip:flag:content ;
	 版本号   时间  发送人  IP 发送的标识符(32) 真正的内容;
 
 在udp协议中，有一个ip地址称作为广播📢地址，广播📢地址就是主机号为255的地址。
 给广播ip地址发送消息的时候，在同一个网络段的机器都可以接收到信息。
 192.168.1.255
 
 */

//使用udp协议给飞q发送消息
public class FeiQDemo {
	public static void main(String[] args) throws IOException {
		//建立udp的服务
		DatagramSocket socket=new DatagramSocket();
		//准备数据，封包
		String str="飞q广播📢数据测试";
		byte[] buf=new byte[1024];
		String content=getData(str);
		DatagramPacket datagramPacket=new DatagramPacket(content.getBytes(), content.getBytes().length, InetAddress.getByName("192.168.1.255"), 9090);
		//调用服务发送数据
		for(int i=0;i<10;i++){
			socket.send(datagramPacket);
		}
		//关闭资源
		socket.close();
	}
	
	//封包
	public static String getData(String content) {
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("1.0:");
		sBuffer.append(System.currentTimeMillis()+":");
		sBuffer.append("发送者:");
		sBuffer.append("192.168.10.1:");
		sBuffer.append("32:");
		sBuffer.append(content);
		
		return sBuffer.toString();
	}
}
