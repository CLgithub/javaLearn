package com.cl.learn.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Servicer implements Runnable{

	private Socket socket;
	
	public Servicer(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		try{
			OutputStream outputStream=socket.getOutputStream();
			InputStream inputStream=socket.getInputStream();
			BufferedReader bfr=new BufferedReader(new InputStreamReader(inputStream));
			DataOutputStream dos=new DataOutputStream(outputStream);
			while(true){
				String strWord=bfr.readLine();
				if(strWord.equalsIgnoreCase("quit")){
					break;
				}
				dos.writeBytes(strWord+System.getProperty("line.separator"));
				dos.flush();
				System.out.println("收到："+strWord);
			}
			dos.close();
			bfr.close();
			inputStream.close();
			outputStream.close();
		}catch(Exception e){
			e.getMessage();
		}
	}

}
