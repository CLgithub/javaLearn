package com.cl.javabasis.day23udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//群聊接收端
public class ChatReceive implements Runnable{

	@Override
	public void run() {
		try {
			//建立udp服务
			DatagramSocket socket=new DatagramSocket(8099);
			//准备一个空数据包
			byte[] buf=new byte[1024];
			DatagramPacket packet=new DatagramPacket(buf, buf.length);
			//监听端口接收数据
			boolean falg=true;
			while(falg){
				socket.receive(packet);
				//解包
				System.out.println(packet.getAddress()+":"+new String(buf,0,packet.getLength()));
			}
			//关闭资源
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
