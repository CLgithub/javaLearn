package com.cl.javabasis.day23tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 java.net.BindException 端口被占用
 
 serversocket的使用步骤：
 	1.建立tcp的客户端服务
 	2.接收客户端的连接产生一个socket
 	3.获取到对应到流对象 写出或读取数据
 	4.关闭资源
 */

//tcp服务端
public class MyDemo1Server {
	public static void main(String[] args) throws IOException {
		//建立tcp服务端，并监听端口
		ServerSocket serverSocket=new ServerSocket(8099);
		//接受客户端的连接
		Socket socket=serverSocket.accept();//accept()该方法也是一个阻塞型的方法，没有客户端与其连接是，会一直等待下去
		//获取输入流对象，读取客户端发送的信息
		InputStream iStream=socket.getInputStream();
		OutputStream oStream=socket.getOutputStream();
		//读取数据
		byte[] buf=new byte[1024];
		int length=0;
		length=iStream.read(buf);
		System.out.println("服务器端接收："+new String(buf,0,length));
		
		oStream.write("客户端你好".getBytes());
		oStream.flush();
		
		
		
		
		//关闭资源
//		iStream.close();
//		socket.close();
		serverSocket.close();
	}
}
