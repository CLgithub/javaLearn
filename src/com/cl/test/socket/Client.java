package com.cl.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1", 8099);
			InputStream iStream=socket.getInputStream();
			OutputStream oStream=socket.getOutputStream();
			
			BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			OutputStreamWriter osw=new OutputStreamWriter(oStream);
			
			BufferedReader keyRread=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String keyStr=keyRread.readLine();
				osw.write(keyStr+System.getProperty("line.separator"));
				osw.flush();
				System.out.println(new String(bReader.readLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
