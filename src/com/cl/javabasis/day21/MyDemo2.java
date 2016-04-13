package com.cl.javabasis.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


/*
 
 */
public class MyDemo2 {
	public static void main(String[] args) {
		try {
//			writeTest();
			readTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//使用字节流读取中文
	public static void readTest() throws IOException{
		//找到目标文件
		File file=new File("E:/aaa/ccc.txt");
		//建立数据输出通道
		FileInputStream fileInputStream=new FileInputStream(file);
//		int leng=0;
//		while((leng=fileInputStream.read())!=-1){
//			//出现乱码的原因：一个中文在UTF-8(项目设置的编码)码表中占3个字节，属于不是一个完整的中文，所以乱码
//			System.out.print((char)leng);
//		}
		
//		byte[] buf=new byte[3];
//		for(int i=0;i<3;i++){
//			fileInputStream.read(buf);
//			System.out.print(new String(buf));
//		}
		
		int leng=0;
		byte[] buf=new byte[1024];
		while((leng=fileInputStream.read(buf))!=-1){
			System.out.print(new String(buf,0,leng));//其实也是借用了字符串的解码功能，同事也存在风险（比如1024刚好读到一个中文一半的时候）
		}
		
		
		fileInputStream.close();
	}
	
	//使用字节流写中文	字节流之所以能写中文，是因为借助了字符串的getBytes方法对字符串进行了编码（字符-->数字）
	public static void writeTest() throws IOException {
		//找到目标文件
		File file=new File("E:/aaa/ccc.txt");
		//建立数据输出通道
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		//准备数据，把数据写出
		String data="大家好";
		byte[] bs=data.getBytes();
		System.out.println(Arrays.toString(bs));
		fileOutputStream.write(bs);
		
		fileOutputStream.close();
	}
}
