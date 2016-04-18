package com.cl.javabasis.day22other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 Properties (配置文件类)：主要用于生成配置文件与读取配置文件
 
 Properties要注意对细节：
 	1.如果配置文件的信息一旦使用了中文，那么在使用store方法生成配置文件的时候，只能使用字符流来解决，如果使用字节流生成配置文件的话，默认使用的是iso8859_1码进行存储
 	2.如果properties中的内容发生了变化，一定要重新存储配置文件，否则配置文件不会发生变化
 	
 
 */
public class MyDemo4 {
	public static void main(String[] args) throws IOException {
		method1();
//		method2();
	}
	//读取配置文件信息
	public static void method2() throws IOException {
		//创建Properties
		Properties properties=new Properties();
		properties.load(new FileReader("/Users/L/Downloads/aaa/persons.properties"));
		
		//遍历properties
		Set<Entry<Object, Object>> entries=properties.entrySet();
		for(Entry<Object, Object> entry:entries){
			System.out.println(entry);
		}
		//修改小明的密码
		properties.setProperty("小明", "007");
		//重新吧修改后的propertie再生成一个配置文件
		properties.store(new FileWriter("/Users/L/Downloads/aaa/persons.properties"), "hehe");
		
		
	}
	
	//保存配置文件信息
	public static void method1() throws IOException {
		//创建Properties
		Properties properties=new Properties();
		properties.setProperty("小明", "123");
		properties.setProperty("xiaohong", "234");
		properties.setProperty("xiaobai", "345");
//		properties.put(123, 12.4);
		
		//遍历properties
//		Set<Entry<Object, Object>> entries=properties.entrySet();
//		for(Entry<Object, Object> entry:entries){
//			System.out.println(entry);
//		}
		
		//使用Properties生成配置文件
		
		//第一个参数是一个输出流对象，对二个参数是使用一个字符串描述一下配置文件信息
//		properties.store(new FileOutputStream("/Users/L/Downloads/aaa/persons.properties"), "haha");
		properties.store(new FileWriter("/Users/L/Downloads/aaa/persons.properties"), "hehe");
	}
}
