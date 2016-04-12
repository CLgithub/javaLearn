package com.cl.javabasis.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.management.RuntimeErrorException;

/*
 IO异常的处理
 
 */
public class MyDemo5 {
	public static void main(String[] args) {
		readTest();
	}
	
	public static void readTest() {
		FileInputStream fileInputStream=null;
		try{
			File file=new File("E:/a.txt");
			fileInputStream=new FileInputStream(file);
			
			byte[] buf=new byte[1024];
			int leng=0;
			while((leng=fileInputStream.read(buf))!=-1){
				System.out.println(new String(buf,0,leng));
			}
		}catch(IOException e){
			System.out.println("读取文件出错:"+e.getMessage());
			//处理异常...首先要阻止后面的代码执行，而且还需要通知调用者这里出错了...
			throw new RuntimeException(e);//把IOException传递给RuntimeException包装一层，是为了让调用者使用更加方便
		}finally {
			//关闭资源
			try {
				if(null!=fileInputStream){
					fileInputStream.close();
					System.out.println("关闭资源成功");
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
