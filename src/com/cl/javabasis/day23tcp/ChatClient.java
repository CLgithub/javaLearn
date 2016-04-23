package com.cl.javabasis.day23tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 需求：客户端与服务端聊天
 
 */
//聊天客户端
public class ChatClient {
	public static void main(String[] args) throws IOException {
		//建立tcp客户端服务
		Socket socket=new Socket(InetAddress.getLocalHost(), 8099);
		//获取socket的输出流对象
		BufferedWriter socketOut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//获取键盘的数据流对象读取数据
		BufferedReader keyReader=new BufferedReader(new InputStreamReader(System.in));
		
		//不断的读取键盘录入的数据，把数据写出
		String line=null;
		while((line=keyReader.readLine())!=null){
			socketOut.write(line+"\r\n");
			socketOut.flush();
			
			//读取服务端回送的数据
			System.out.println("服务端回送的数据："+socketIn.readLine());
		}
		//关闭资源
		socket.close();
	}
}
