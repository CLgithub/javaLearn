package com.cl.javabasis.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;

/*
finally块

finally块的使用前提是必须要存在try块

finally块的代码在任何情况都会执行，出来jvm退出的情况

finlly非常适合做资源释放的工作，这样可以保证资源文件在任何情况都可以被释放

try块的三种组合方式
第一种：有异常要要处理，但是没有资源要释放
		try{
			可能发生异常的代码
		}catch(捕获的异常类型 变量名){
			处理异常的代码
		}
第二种：有异常要要处理，又要资源要释放
		try{
			可能发生异常的代码
		}catch(捕获的异常类型 变量名){
			处理异常的代码
		}finally{
			释放资源的代码
		}
第三种：内部抛出的是运行时异常，又要资源要释放
		try{
			可能发生异常的代码
		}finally{
			释放资源的代码
		}
		
		try {
			throw new NullPointerException();
		} finally{
			
		}

*/
public class Demo3 {
	public static void main(String[] args) {
//		div(4, 0);
		readFile();
		
		
	}
	
	public static void div(int a,int b) {
		try{
			if(b==0){
				return;
				//退出jvm
//				System.exit(0);
			}
			int c=a/b;
			System.out.println("c="+c);
		}catch (Exception e) {
			System.out.println("出现了除数为0的异常");
//			throw e;
		}finally{
			System.out.println("finally块执行了");
		}
	}
	
	public static void readFile(){
		File file=new File("E:/aaa/b.txt");
		FileInputStream fileInputStream=null;
		try{
			fileInputStream=new FileInputStream(file);
			byte[] buf=new byte[1024];
			int i=0;
			while((i=fileInputStream.read(buf))!=-1){
				System.out.println(new String(buf,0,i));
			}
			
			/*FileReader fReader=new FileReader(file);
			char[] cs=new char[1024];
			int length=0;
			while((length=fReader.read(cs))!=-1){
				System.out.println(new String(cs,0,length));
			}*/
			
			
		}catch(Exception exception){
			System.out.println("读取资源文件失败");
		}finally{
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.out.println("释放资源失败");
				e.printStackTrace();
			}
		}
	}
	
}
