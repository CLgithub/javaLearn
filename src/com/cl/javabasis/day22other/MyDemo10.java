package com.cl.javabasis.day22other;

import java.io.File;
import java.util.Arrays;

/*
需求
1:列出一个文件夹的子孙文件与目录
2，列出指定目录中所有的子孙文件与子孙目录名，要求名称前面要有相应数量的空格：
​	第一级前面有0个，第二级前面有1个，第三级前面有2个...，以此类推。
​3，列出指定目录中所有的子孙文件与子孙目录名，要求要是树状结构，效果如下所示：
​|--src
​|   |--cn
​|   |   |--itcast
​|   |   |   |--a_helloworld
​|   |   |   |   |--HelloWorld.java
​|   |   |   |--b_for
​|   |   |   |   |--ForTest.java
​|   |   |   |--c_api
​|   |   |   |   |--Student.java
​|--bin
​|   |--cn
​|   |   |--itcast
​|   |   |   |--i_exception
​|   |   |   |   |--ExceptionTest.class
​|   |   |   |--h_linecount
​|   |   |   |   |--LineCounter3.class
​|   |   |   |   |--LineCounter2.class
​|   |   |   |   |--LineCounter.class
​|--lib
​|   |--commons-io.jar

需求4:删除一个非空的文件夹

作业：剪切一个非空目录
 */
public class MyDemo10 {
	public static void main(String[] args) {
		File dir=new File("/Users/L/javaProjectE/javaLearn/src");
//		method3(dir,"​｜--");
		File dir2=new File("/Users/L/Downloads/aaa/dd");
//		dir2.delete();
//		method5(dir2);
		File dir3=new File("/Users/L/Downloads/dd");
		method6(dir2,dir3);
	}
	
	//剪切一个目录到指定文件夹下
	private static void method6(File dir,File dir2) {
		dir.renameTo(dir2);
	}

	//需求4:删除一个非空的文件夹
	public static void method5(File dir) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				file.delete();
			}else {
				method5(file);
			}
		}
		dir.delete();
	}
		
	
	//需求4:删除一个非空的文件夹
	public static void method4(File dir) {
		File[] files=dir.listFiles();
		if(files!=null){//dir存在
			if(files.length!=0){//dir不为空
				for(File file:files){
					if(file.isFile()){
						file.delete();
					}else {
						method4(file);
					}
				}
			}
			dir.delete();
		}
	}
	
	//列出指定目录中所有的子孙文件与子孙目录名，要求名称前面要有相应数量的空格：
	public static void method3(File dir,String space) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println(space+file.getName());
			}else if(file.isDirectory()) {
				System.out.println(space+file.getName());
				method3(file,"｜  "+space);
			}
		}
	}
	
	//列出指定目录中所有的子孙文件与子孙目录名，要求名称前面要有相应数量的空格：
	public static void method2(File dir,String space) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println(space+file.getName());
			}else if(file.isDirectory()) {
				System.out.println(space+file.getName());
				method2(file,"  "+space);
			}
		}
	}
	
	//列出一个文件夹的子孙文件与目录
	public static void method1(File dir) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println("文件名："+file.getName());
			}else if(file.isDirectory()) {
				System.out.println("文件夹名："+file.getName());
				method1(file);
			}
		}
	}
}
