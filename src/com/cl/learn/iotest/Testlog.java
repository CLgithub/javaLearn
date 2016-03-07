package com.cl.learn.iotest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

public class Testlog {
	public static void main(String[] args) {
		try {
			File log=new File("d:/stdout.log");
			BufferedReader bufferedReader=new BufferedReader(new FileReader(log));
			byte[] buf=bufferedReader.readLine().getBytes("UTF-8");
			String str=new String(buf,0,buf.length);
			
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
