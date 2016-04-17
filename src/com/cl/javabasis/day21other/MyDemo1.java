package com.cl.javabasis.day21other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 装饰者设计模式：增强一个类的功能，而且还可以让这些装饰类互相装饰
 
 BufferedReader 拓展了FileReader的功能
 BufferedWriter 扩展了FileWriter的功能
 
 需求1:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号
 需求2:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有分号
 需求3:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有双引号
 
 需求4:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号+分号
 需求5:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号＋双引号
 需求6:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有分号＋双引号
 需求7:编写一个类拓展BufferReader的功能，增强readLine方法的字符串带有行号+分号＋双引号
 ......
 需求n
 
 增强一个类的功能的时候，可以选择使用继承：
 	优点：代码结果情绪，通俗易懂
 	缺点：使用不灵活，会导致继承的体系过于庞大
 	
 */
public class MyDemo1 {
	public static void main(String[] args) throws IOException {
		File file=new File("/Users/L/Downloads/aaa/bbb");
		FileReader fileReader=new FileReader(file);
		
//		BufferedLineNum mybuffer=new BufferedLineNum(fileReader);//带有行号
//		Buffered2 mybuffer=new Buffered2(fileReader);//带有分号
		Buffered3 mybuffer=new Buffered3(fileReader);//带有双引号
		String line="";
//		for(int i=0;i<3;i++){
//			line=bufferedLineNum.readLine();
		while((line=mybuffer.readLine())!=null){
			System.out.println(line);
		}
		mybuffer.close();
	}
}

//需求1
class BufferedLineNum extends BufferedReader{
	public BufferedLineNum(Reader in) {
		super(in);
	}
	int lineNum=0;
	@Override
	public String readLine() throws IOException {
		lineNum++;
		String str1=super.readLine();
		if(str1==null){
			return null;
		}
		return lineNum+":"+str1;
	}
}
//需求2
class Buffered2 extends BufferedReader{
	public Buffered2(Reader in) {
		super(in);
	}
	@Override
	public String readLine() throws IOException {
		String str1=super.readLine();
		if(str1==null){
			return null;
		}
		return str1+";";
	}
}
//需求3
class Buffered3 extends BufferedReader{
	public Buffered3(Reader in) {
		super(in);
	}
	@Override
	public String readLine() throws IOException {
		String str1=super.readLine();
		if(str1==null){
			return null;
		}
		return "\""+str1+"\"";
	}
}