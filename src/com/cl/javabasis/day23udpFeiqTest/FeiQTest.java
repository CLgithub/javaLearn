package com.cl.javabasis.day23udpFeiqTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 飞Q接收的数据格式：
	 version:time:sender:ip:flag:content ;
	 版本号   时间  发送人  IP 发送的标识符(32) 真正的内容;
 */
public class FeiQTest {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket=new DatagramSocket();
		new Thread(new FeiQSender(datagramSocket,"168.10.13.222")).start();
		new Thread(new FeiQReceiver(datagramSocket)).start();
	}
}

/**
 * 发送线程
 * @author L
 * @date 2016年4月26日
 */
class FeiQSender implements Runnable{
	DatagramSocket datagramSocket;
	String ip;
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
	public FeiQSender(DatagramSocket datagramSocket,String ip) {
		this.datagramSocket = datagramSocket;
		this.ip=ip;
	}

	@Override
	public void run() {
		while(true){
			try {
				String content=this.getPacket(bufferedReader.readLine());
				DatagramPacket packet=new DatagramPacket(content.getBytes("gbk"), content.getBytes("gbk").length, 
						InetAddress.getByName(ip), 2425);
				datagramSocket.send(packet);
			} catch (IOException e) {
				datagramSocket.close();
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}
	
	private String getPacket(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append("1.0:");
		sb.append(System.currentTimeMillis() + ":");
		sb.append("发送者:");
		sb.append("168.10.13.222:");
		sb.append("32:");
		sb.append(str);
		return sb.toString();
	}
	
}
/**
 * 接收者线程
 * @author L
 * @date 2016年4月26日
 */
class FeiQReceiver implements Runnable{
	DatagramSocket datagramSocket;
	public FeiQReceiver(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

	@Override
	public void run() {
		while(true){
			try {
				//准备一个空数据包
				byte[] buf=new byte[1024];
				DatagramPacket packet=new DatagramPacket(buf, buf.length);
				//监听端口接收数据
				boolean falg=true;
				while(falg){
					datagramSocket.receive(packet);
					//解包
					System.out.println(packet.getAddress()+":"+new String(buf,0,packet.getLength(),"gbk"));
				}
			} catch (IOException e) {
				//关闭资源
				datagramSocket.close();
				e.printStackTrace();
			}
		
		}
	}
	
}