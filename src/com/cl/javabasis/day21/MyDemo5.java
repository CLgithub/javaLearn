package com.cl.javabasis.day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 *  练习：使用字符流拷贝一个文本文件，接着只用字符流拷贝一个图片（观察图片的大小变化，思考为什么会这样子）
 */
public class MyDemo5 {
	public static void main(String[] args) {
		try {
//			copyText1();
			copyImageByC();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyText1() throws IOException {
		File sourceText=new File("E:/常用/目标.txt");
		File text1=new File("F:/testCopy.java");
		
		FileReader fileReader=new FileReader(sourceText);
		FileWriter fileWriter=new FileWriter(text1);
		
		int leng=0;
		char[] buf=new char[1024]; 
		while((leng=fileReader.read(buf))!=-1){
			fileWriter.write(new String(buf,0,leng));
		}
		
		fileWriter.close();
		fileReader.close();
	}
	
	public static void copyImageByC() throws IOException {
		File sourctImage=new File("F:/wang1.jpg");
		File image2=new File("F:/wang2.jpg");
		
		FileReader fileReader=new FileReader(sourctImage);
		FileWriter fileWriter=new FileWriter(image2);
		
		int leng=0;
		char[] buf=new char[1024]; 
		while((leng=fileReader.read(buf))!=-1){
			fileWriter.write(new String(buf,0,leng));
		}
		
		fileWriter.close();
		fileReader.close();
	}
}
