package com.cl.learn.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(8099);
			while(true){
				Socket socket=serverSocket.accept();
				Servicer servicer=new Servicer(socket);
				Thread thread=new Thread(servicer);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
