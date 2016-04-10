package com.cl.javabasis.day19io;

import java.io.File;

/*
 路径问题:
 
  绝对路径：该文件在硬盘上的完整路径，绝对路径一般都是以盘符开通的。

 相对路径：资源文件相对于当前程序所在的路径。
 	.		当前路径
 	..		上一级路径
 	...		错误
 注意：如果程序与资源文件不在同一个盘下，是没法写相对路径的
 
*/
public class MyDemo2 {
	public static void main(String[] args) {
		File file=new File("E:/a.txt");//绝对路径
		File file1=new File(".");
		System.out.println("当前路径的绝对路径是："+file1.getAbsolutePath());
		
		File file2=new File("../../a.txt");
		System.out.println("存在吗？"+file2.exists());
		
		File btxt=new File("./src/com/cl/javabasis/day18io/b.txt");
//		File btxt=new File("src/com/cl/javabasis/day18io/b.txt");
		System.out.println(btxt.exists());
	}
}
