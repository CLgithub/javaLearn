package com.cl.javabasis.day23udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SafeRecive {
	public static void main(String[] args) throws IOException, InterruptedException {
		DatagramSocket socket=new DatagramSocket(8099);
		byte[] buf=new byte[1024];
		DatagramPacket packet=new DatagramPacket(buf, buf.length);
		while(true){
			socket.receive(packet);
			System.out.println(new String(buf,0,packet.getLength()));
			Thread.sleep(10);
		}
		
	}
}
