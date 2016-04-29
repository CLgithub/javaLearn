package com.cl.javabasis.day27factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 工厂设计模式就是用于产生对象的
 
 需求：编写一个工厂方法根据配置文件返回对应的对象
 */
public class MyDemo1 {
	public static void main(String[] args) throws Exception {
		Object object=getInstance();
		System.out.println(object);
	}

	//需求：编写一个工厂方法根据配置文件返回对应的对象
	public static Object getInstance() throws Exception {
		//读取配置文件
		FileReader fileReader=new FileReader("info.txt");
		BufferedReader bReader=new BufferedReader(fileReader);
		
		//先读取第一行：读取类的信息
		String className=bReader.readLine();
		//通过完整类名获取对应的Class对象
		Class clazz1=Class.forName(className);
		//获取到对应到构造方法
		Constructor constructor=clazz1.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Object object=constructor.newInstance(null);
		//给对象设置对应的属性值
		String line=null;
		while((line=bReader.readLine())!=null){
			String[] strings=line.split("=");
			Field field=clazz1.getDeclaredField(strings[0]);
			field.setAccessible(true);
			//先判断属性类型
			Class type= field.getType();
			if(type==int.class){
				field.set(object, Integer.parseInt(strings[1]));
			}else{
				field.set(object,strings[1]);
			}
			
		}
		return object;
	}
}

class Car{}

class BMW extends Car{
	
}

class BSJ extends Car{
	
}