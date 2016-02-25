package com.cl.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(8099);
			Socket socket=serverSocket.accept();;
			
			InputStream iStream=socket.getInputStream();
			OutputStream oStream=socket.getOutputStream();
			
			BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			OutputStreamWriter osw=new OutputStreamWriter(oStream);
			while(true){
				String inStr=bReader.readLine();
//				System.out.println(inStr);
				osw.write(inStr+System.getProperty("line.separator"));
				osw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
