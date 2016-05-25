package com.cl.javabasis.day23tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. 编写一个服务端可以给多个客户端发送图片。 （多线程）
 * @author L
 * @date 2016年4月23日
 */
public class DownImage {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(8099);
		
		while(true){
			Socket socket=serverSocket.accept();
			new ImageServer(socket).start();
		}
	}
}
class ImageServer extends Thread{
	private Socket socket;
	private static HashSet<String> set=new HashSet<>();
	public ImageServer(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		System.out.println("开始下载");
		try {
			FileInputStream imgIS=new FileInputStream("/Users/L/Downloads/aaa/img.PNG");		//得到图片输入通道
			OutputStream socketOut=socket.getOutputStream();				//得到socket输出通道
			
			byte[] buf=new byte[1024];
			int length=0;
			while((length=imgIS.read(buf))!=-1){
				socketOut.write(buf,0,length);
			}
			//socket.getInetAddress().getHostAddress() 获取对方IP
			set.add(socket.getInetAddress().getHostAddress().toString());
			System.out.println(set);
			System.out.println("当前下载的人数是："+set.size());
			socket.close();
			imgIS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
