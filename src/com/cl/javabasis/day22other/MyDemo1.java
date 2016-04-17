package com.cl.javabasis.day22other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.sound.midi.VoiceStatus;

/*
 需求：有a文件和b文件，需要将a文件和b文件合并成一个c文件
 */
public class MyDemo1 {
	public static void main(String[] args) throws IOException {
//		method1();
//		method2();
//		method3();
		method4();
	}
	
	//文件内容合并
	public static void method1() throws IOException{
		File filea=new File("/Users/L/Downloads/aaa/a");//a文件
		File fileb=new File("/Users/L/Downloads/aaa/b");//b文件
		FileReader fileReadera=new FileReader(filea);
		FileReader fileReaderb=new FileReader(fileb);
		BufferedReader bfa=new BufferedReader(fileReadera);
		BufferedReader bfb=new BufferedReader(fileReaderb);
		
		String str="";
		StringBuffer sbBuffer=new StringBuffer();
		while((str=bfa.readLine())!=null){
			sbBuffer.append(str);
		}
		while((str=bfb.readLine())!=null){
			sbBuffer.append(str);
		}
//		System.out.println(sbBuffer);
		
		//输出到文件c
		BufferedWriter bwc=new BufferedWriter(new FileWriter("/Users/L/Downloads/aaa/c"));
		bwc.write(sbBuffer.toString());
		
		bwc.close();
		bfb.close();
		bfa.close();
	}
	
	//文件内容合并2
	public static void method2() throws IOException{
		File filea=new File("/Users/L/Downloads/aaa/a");//a文件
		File fileb=new File("/Users/L/Downloads/aaa/b");//b文件
		File filed=new File("/Users/L/Downloads/aaa/d");//d文件
		
		FileInputStream fileInputStreama=new FileInputStream(filea);
		FileInputStream fileInputStreamb=new FileInputStream(fileb);
		FileOutputStream fileOutputStreamd=new FileOutputStream(filed);
		
		//把输入流存到集合中，然后再从集合中读取
		ArrayList<FileInputStream> arrayList=new ArrayList<>();
		arrayList.add(fileInputStreama);
		arrayList.add(fileInputStreamb);
		
		byte[] buf=new byte[1024];
		int length=0;
		for (int i = 0; i < arrayList.size(); i++) {
			FileInputStream fileInputStream=arrayList.get(i);
			while((length=fileInputStream.read(buf))!=-1){
				fileOutputStreamd.write(buf, 0, length);
			}
			fileInputStream.close();
		}
		
		fileOutputStreamd.close();
		fileInputStreamb.close();
		fileInputStreama.close();
	}
	
	//文件内容合并两个文件	使用SequenceInputStream
	public static void method3() throws IOException{
		File filea=new File("/Users/L/Downloads/aaa/a");//a文件
		File fileb=new File("/Users/L/Downloads/aaa/b");//b文件
		File filee=new File("/Users/L/Downloads/aaa/e");//e文件
		
		FileInputStream fileInputStreama=new FileInputStream(filea);
		FileInputStream fileInputStreamb=new FileInputStream(fileb);
		
		FileOutputStream fileOutputStreame=new FileOutputStream(filee);
		
		//建立序列流对象
		SequenceInputStream inputStream=new SequenceInputStream(fileInputStreama, fileInputStreamb);
		byte[] buf=new byte[1024];
		int length=0;
		while((length=inputStream.read(buf))!=-1){
			fileOutputStreame.write(buf,0,length);
		}
		
		fileOutputStreame.close();
		inputStream.close();
//		fileInputStreama.close();
//		fileInputStreamb.close();
		
	}
	
	//文件内容合并两个文件	使用SequenceInputStream
	public static void method4() throws IOException{
		File filea=new File("/Users/L/Downloads/aaa/a");//a文件
		File fileb=new File("/Users/L/Downloads/aaa/b");//b文件
		File filec=new File("/Users/L/Downloads/aaa/c");//b文件
		File filex=new File("/Users/L/Downloads/aaa/x");//e文件
		
		FileInputStream fileInputStreama=new FileInputStream(filea);
		FileInputStream fileInputStreamb=new FileInputStream(fileb);
		FileInputStream fileInputStreamc=new FileInputStream(filec);
		
		FileOutputStream fileOutputStreamx=new FileOutputStream(filex);
		
		//建立序列流对象
		Vector<FileInputStream> vector=new Vector<>();
		vector.add(fileInputStreama);
		vector.add(fileInputStreamb);
		vector.add(fileInputStreamc);
		Enumeration<FileInputStream> enumeration=vector.elements();
		
		SequenceInputStream inputStream=new SequenceInputStream(enumeration);
		byte[] buf=new byte[1024];
		int length=0;
		while((length=inputStream.read(buf))!=-1){
			fileOutputStreamx.write(buf,0,length);
		}
		
		fileOutputStreamx.close();
		inputStream.close();
	}
			
}
