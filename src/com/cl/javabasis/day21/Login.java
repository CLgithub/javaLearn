package com.cl.javabasis.day21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
  练习：缓存输入输出字符流做用户登录注册...
 */
public class Login {
	public static void main(String[] args) throws IOException {
		File userInfo=new File("E:/aaa/userInfo.txt");
		while(true){
			System.out.println("请选择功能：A注册，B登陆");
			Scanner scanner=new Scanner(System.in);
			String str1=scanner.next();
			if("A".equalsIgnoreCase(str1)){
				//注册
				method1(scanner,userInfo);
			}else if("B".equalsIgnoreCase(str1)){
				//登陆
				method2(scanner,userInfo);
			}else {
				System.out.println("输入有误，请重新输入");
			}
		}
	}

	//注册
	private static void method1(Scanner scanner, File userInfoF) throws IOException {
//		FileReader fileReader=new FileReader(userInfoF);
//		FileWriter fileWriter=new FileWriter(userInfoF,true);
//		
//		BufferedReader bReader=new BufferedReader(fileReader);
//		BufferedWriter bWriter=new BufferedWriter(fileWriter);
		
		BufferedReader bReader=new BufferedReader(new FileReader(userInfoF));
		BufferedWriter bWriter=new BufferedWriter(new FileWriter(userInfoF,true));
		
		System.out.println("注册：请输入注册用户名");
		String userName=scanner.next();
		String password="";
		String userInfo="";
		boolean b=false;
		//判断用户名是否已经被用
		while((userInfo=bReader.readLine())!=null){
			if(userInfo.split(" ")[0].equals(userName)){//如果有同名
				b=true;
				break;
			}
		}
		//如果被用
		if(b){
			System.out.println("用户名已经被使用");
			return;
		}else {
			//如果没有被用
			System.out.println("注册：请输入注册密码");
			password=scanner.next();
		}
		System.out.println("注册成功");
		//存入
		bWriter.write(userName+" "+password);
		bWriter.newLine();
		bWriter.close();
		bReader.close();
		
	}

	//登陆
	private static void method2(Scanner scanner, File userInfoF) throws IOException {
//		FileReader fileReader=new FileReader(userInfoF);
//		BufferedReader bReader=new BufferedReader(fileReader);

		BufferedReader bReader=new BufferedReader(new FileReader(userInfoF));
		
		System.out.println("登陆：请输入登陆用户名");
		String userName=scanner.next();
		System.out.println("登陆：请输入登陆密码");
		String password=scanner.next();
		String userInfo=userName+" "+password;
		String line="";
		boolean b=false;
		while((line=bReader.readLine())!=null){
			if(line.equals(userInfo)){
				b=true;
				break;
			}
		}
		if(b){
			System.out.println("登陆成功");
		}else {
			System.out.println("用户名或密码错误，登陆失败");
		}
		bReader.close();
	}

}
