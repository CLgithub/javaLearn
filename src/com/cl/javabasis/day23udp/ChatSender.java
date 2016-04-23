package com.cl.javabasis.day23udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//群聊发送端
public class ChatSender implements Runnable{

	@Override
	public void run() {
		try {
			//建立udp服务
			DatagramSocket socket=new DatagramSocket();
			//准备数据
			BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
			//数据封包
			String line="";
			while((line=bReader.readLine())!=null){
				DatagramPacket datagramPacket=new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.1.255"), 8099);
				//发送
				socket.send(datagramPacket);
			}
			//关闭资源
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
