package com.cl.javabasis.day16;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cl.javabasis.day11.Test1;

/*
 需求： 接受键盘录入用户名与密码，如果用户名与密码已经存在集合中，那么就是视为重复元素，不允许添加到HashSet中。
 */
public class MyDemo3 {
	public static void main(String[] args) {
		Set set=new HashSet();
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("请输入用户名");
			String name=scanner.next();
			System.out.println("请输入密码");
			String password=scanner.next();
			User user=new User(name, password);
			if(set.add(user)){
				System.out.println("注册成功！"+user);
				System.out.println("当前用户有："+set);
			}else {
				System.out.println("该用户名已被使用:"+name);
			}
		}
		
//		TestStringHashCode();
	}
	/**
	 *  HashCode默认情况下表示的是内存地址，String 类已经重写了Object的hashCode方法了。
	 	注意： 如果两个字符串的内容一致，那么返回的hashCode 码肯定也会一致的。
	 */
	private static void  TestStringHashCode(){
		String str1	="aa";
		String str2	=new String("aa");
		System.out.println(str1==str2);
		System.out.println("str1的hashCode"+str1.hashCode());
		System.out.println("str2的hashCode"+str2.hashCode());
	}
}

class User{
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "[name=" + name + ",password=" + password + "]";
	}
	@Override
	public int hashCode() {
//		System.out.println(name.hashCode());
		//此处只需name一样，这视为重复
		return this.name.hashCode();
//		return 0;//如果是这样，每次都要调用equals方法和已经放入这个坑中的【每个】元素比较，
	}
	@Override
	public boolean equals(Object obj) {
		User user=(User) obj;
		return this.name.equals(user.name);
	}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
}
