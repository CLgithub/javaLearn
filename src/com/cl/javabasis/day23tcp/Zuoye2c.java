package com.cl.javabasis.day23tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Zuoye2c {
	public static void main(String[] args) throws IOException {
		//建立tcp客户端服务
		Socket socket=new Socket(InetAddress.getLocalHost(), 8099);
		//获取socket的输出流对象
		BufferedWriter socketOut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//获取键盘的数据流对象读取数据
		BufferedReader keyReader=new BufferedReader(new InputStreamReader(System.in));
		
		ShuChu shuChu=new ShuChu(socketIn);
		new Thread(shuChu).start();
		ShuRu shuRu=new ShuRu(socketOut,keyReader);
		new Thread(shuRu).start();
		
		//关闭资源
//		socket.close();
	}
}
class ShuRu implements Runnable{
	BufferedWriter socketOut;
	BufferedReader keyReader;
	public ShuRu(BufferedWriter socketOut,BufferedReader keyReader) {
		this.socketOut=socketOut;
		this.keyReader=keyReader;
	}

	@Override
	public void run() {
		while(true){
			try {
				socketOut.write(keyReader.readLine()+"\r\n");
				socketOut.flush();
			} catch (IOException e) {
				System.out.println("ShuRu.run()");
				e.printStackTrace();
				break;
			}
		}
		try {
			keyReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socketOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class ShuChu implements Runnable{
	BufferedReader socketIn;
	
	public ShuChu(BufferedReader socketIn) {
		this.socketIn = socketIn;
	}

	@Override
	public void run() {
		while(true){
			try {
				String line="";
				while((line=socketIn.readLine())!=null){
					//读取服务端回送的数据
					System.out.println("服务端回送的数据："+line);
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		try {
			socketIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
