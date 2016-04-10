package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 File类：用于描述一个文件或文件夹
  
  通过File对象我们可以读取文件或文件夹的属性数据，如果我们需要读取文件的内容数据，那么我们需要使用io流技术
  
 IO流（Input Output）
 
 IO流解决问题。解决设备与设备之间的数据传输问题。内存----->硬盘	硬盘----->内存
 
 IO流分类：
 	如果按照数据流向划分：输入输出是相对于当前程序来说
 		1.输入流：
 		2.输出流：
 	如果按照处理单元划分：
 		1.字节流：读取的都是文件中的二进制数据，而且读出的二进制数据不会经过任何处理
 		2.字符流：读取的数据是以字符为单位的，也是读取文件中的二进制数据，不过会把这些二进制数据转换成我们能识别的字符。
 					100101000101010101--------->字符char
 					字符流=字节流+解码
 					
 输入字节流
 --------| InputStream	所以输入字节流的基类
 ------------| FileInputStream	读取文件数据的输入字节流
 
 使用 FileInputStream读取文件数据的步骤：
 	1.找到目标文件
 	2.建立数据的输入通道
 	3.使用流对象的方法，读取文件中的数据
 	4.关闭资源	
 * */
public class MyDemo1 {
	public static void main(String[] args) {
//		readTest1();
//		readTest2();
		readTest3();
	}
	
	//读取方式一：无法读取文件完整数据
	public static void readTest1(){
		try {
			//1.找到目标文件
			File file=new File("E:/aaa/aaa.txt");
			//2.建立数据的输入通道
			FileInputStream fileInputStream=new FileInputStream(file);
			//3.使用流对象的方法，读取文件中的数据
			int content=fileInputStream.read();//read()读取一个字节的数据,把读到的数据返回
			System.out.println("读到的内容是："+(char)content);
			//4.关闭资源		实际上就是释放资源
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//方式二使用循环来读取文件的数据
	public static void readTest2(){
		try{
			//1.找到目标文件
			File file=new File("E:/aaa/aaa.txt");
			//2.建立数据的输入通道
			FileInputStream fileInputStream=new FileInputStream(file);
			//3.使用流对象的方法，读取文件中的数据
			int content=0;//声明该变量用于存储读取到的数据
			while((content=fileInputStream.read())!=-1){//把读到的内容给content，判断content等于-1吗，如果不等于
				System.out.println((char) content);
			}
			//4.关闭资源		实际上就是释放资源
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//方式三使用缓冲数组读取。缺点：无法读取文件完整数据
	public static void readTest3(){
		try{
			//1.找到目标文件
			File file=new File("E:/aaa/aaa.txt");
			//2.建立数据的输入通道
			FileInputStream fileInputStream=new FileInputStream(file);
			//3.缓冲数组读取，读取文件中的数据
			byte[] buf=new byte[/*(int) file.length()*/1024];//相对于超市里的购物车
			//如果使用read方法读取数据传入字节数据，那么数据是存储到字节数组中的，而这时候read方法的返回值表示的是本次读取了几个字节数据到字节数组中
			int length=fileInputStream.read(buf);//数据读取到byte数组buf中，
			//用字节数组构建字符串
			String content=new String(buf,0,length);
			System.out.println("读到的内容是："+content);
//			System.out.println(file.length());
//			System.out.println(length);
			
			//4.关闭资源		实际上就是释放资源
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
