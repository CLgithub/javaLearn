package com.cl.javabasis.day23tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 模拟tomcat服务器
 
 */
//模拟tomcat服务器
public class TomcatDemo extends Thread{
	
	Socket socket;

	public TomcatDemo(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("TomcatDemo.main()");
			//获取socket的输出流对象
			OutputStream oStream=socket.getOutputStream();
			//把数据写向浏览器
			String str="<html><title>aa</title><body>我是tocmat，</body></html>";
			oStream.write(str.getBytes("gb2312"));
//			oStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		//建立tcp的服务端
		ServerSocket serverSocket=new ServerSocket(8090);
		//不断的接受客户端的连接
		while(true){
			//接受客户端连接
			Socket socket=serverSocket.accept();
			new TomcatDemo(socket).start();
//			serverSocket.close();
		}
	}
	
}
