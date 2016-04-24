package com.cl.javabasis.day23tcp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

//下载图片客户端
public class DownImageClient {
	public static void main(String[] args) throws IOException {
		Socket socket=new Socket(InetAddress.getLocalHost(), 8099);
		InputStream iStream=socket.getInputStream();
		FileOutputStream fileOutputStream=new FileOutputStream("/Users/L/Downloads/aaa/img1.mp4");
		byte[] buf=new byte[1024];
		int length=0;
		while ((length=iStream.read(buf))!=-1){
			fileOutputStream.write(buf,0,length);
		}
		fileOutputStream.close();
		socket.close();
	}
}
