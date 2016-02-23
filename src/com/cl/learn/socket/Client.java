package com.cl.learn.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1", 8099);
			OutputStream outputStream=socket.getOutputStream();
			InputStream inputStream=socket.getInputStream();
			
			BufferedReader bfr=new BufferedReader(new InputStreamReader(inputStream));
			DataOutputStream dos=new DataOutputStream(outputStream);
			//键盘输入
			BufferedReader bfrKey=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String strWord=bfrKey.readLine();
				dos.writeBytes(strWord+System.getProperty("line.separator"));
				if(strWord.equalsIgnoreCase("quit")){
					break;
				}else {
					System.out.println(bfr.readLine());
				}
			}
			dos.close();
			bfrKey.close();
			bfr.close();
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
