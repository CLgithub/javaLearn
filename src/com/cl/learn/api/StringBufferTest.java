package com.cl.learn.api;

import java.io.IOException;

public class StringBufferTest {
	public static void main(String[] args) {
		byte[] buf=new byte[1024];
		String strInfo=null;
		int pos=0;
		int ch=0;
		while (true){
			try {
				ch=System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (ch) {
			case 13://归为符，windows下'\r'
				break;
			case 10://换行符,windows下'\n'
				strInfo=new String(buf, 0, pos);
				if(strInfo.equals("bye")){
					return;
				}else {
					System.out.println(strInfo);
					pos=0;
					break;
				}
			default:
				buf[pos++]=(byte) ch;
			}
		}
	}
}
