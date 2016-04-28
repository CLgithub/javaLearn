package com.cl.javabasis.day27windowsbat;

/*
 bat处理文件：bat文件就可以一次性执行多个命令的文件
  
  为什么要学bat处理文件，快速运行一个软件我们一般都灰把软件打包一个jar包
  
  jar包双击可以运行仅对图形化解码的软件起作用，对应控制台的程序是不起作用的
  对应控制台的程序我们可以使用bat处理文件快速启动
  
  如何编写bat处理文件：
  	步骤：编写一个自定义的文本文件，把后缀改成bat，然后把所要执行的命令写在bat文件中
  
  bat处理文件常用的命令：
  	echo 向控制台输出指定的内容。
	echo off 隐藏echo off后面执行过的命令。
	@      隐藏当前行执行的命令。
	title 改变当前控制台窗口的标题
	color 指定控制台的背景颜色与前景颜色
	%注释的内容%
	pause: 让当前控制台停留。
	%1~%9:   给bat处理文件传入参数。
	
	
	linux或mac os下直接命令行
 
 */
public class MyDemo1 {
	public static void main(String[] args) {
		System.out.println("哈哈");
	}
}
