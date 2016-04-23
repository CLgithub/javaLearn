package com.cl.javabasis.day23tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 UDP通讯协议的特点：
	 1.将数据极其源和目的封装为数据包，不需要建立连接。比如：广播📢，feiq聊天，游戏🎮……
	 2.每个数据包大小限制在64K中
	 3.因为无连接，所以不可靠
	 4.因为不需要建立连接，所以速度快
	 5.udp通讯是不分服务端与客户端的，只分发送端与接收端
	 
 TCP协议特点：
 	1.tcp是基于io流进行传输的，面向连接	比如：打电话☎️，qq、feiq的文件传输……
 	2.tcp进行数据传输的时候是没有大小限制的
 	3.面向连接，通过3次握手机制保证数据完整性，可靠
 	4.tcp是面向连接，所以速度慢。
 	5.tcp是区分客户端与服务端的
 	
 	
 tcp下的socket：
 	Socket(客户端),tcp的客户端一旦启动，马上要与服务端建立连接
 	ServerSocket(服务端)
 	
 tcp客户端使用步骤：
 	1.建立tcp的客户端服务
 	2.获取到对应到流对象 写出或读取数据
 	3.关闭资源
 	
 	
 */

//tcp客户端
public class MyDemo1 {
	public static void main(String[] args) throws IOException {
		//建立tcp服务
		Socket socket=new Socket(InetAddress.getLocalHost(), 8099);
		//获取到对应到流对象
		OutputStream oStream=socket.getOutputStream();
		InputStream iStream=socket.getInputStream();
		//利用输出流对象把数据写出
		oStream.write("服务端，你好".getBytes());
		
		byte[] buf=new byte[1024];
		int length=0;
		length=iStream.read(buf);
		System.out.println("客户端接收到的数据："+new String(buf,0,length));
		//关闭资源
//		oStream.close();
		socket.close();
	}
}
