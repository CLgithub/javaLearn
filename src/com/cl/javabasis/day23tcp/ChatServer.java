package com.cl.javabasis.day23tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 1.如果使用BufferedReader的readline方法，一定要加上\r\n才把数据写出，否则就自己用字节数组去读
 2.使用字符流一定要调用flush方法把数据刷出缓存区
 
 */
//聊天的服务端
public class ChatServer {
	public static void main(String[] args) throws IOException {
		//建立tcp的服务端
		ServerSocket serverSocket=new ServerSocket(8099);
		//接收客户端连接
		Socket socket=serverSocket.accept();
		//获取对应的流对象
		InputStream iStream=socket.getInputStream();
		OutputStream oStream=socket.getOutputStream();
		BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
		BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(oStream));
		//获取键盘输入流
		BufferedReader keyReader=new BufferedReader(new InputStreamReader(System.in));
		
		//读取客户端发来的数据
		String line=null;
		while((line=bReader.readLine())!=null){
			System.out.println("服务端接收到的数据："+line);
			//键盘输入的写出到bWriter
//			bWriter.write(keyReader.readLine()+"\r\n");
			bWriter.write(new StringBuffer(line).reverse().toString()+"\r\n");
			bWriter.flush();
		}
		//关闭资源
		serverSocket.close();
	}
}
