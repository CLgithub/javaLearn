package com.cl.javabasis.day22other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
 需求：使用Properties实现本软件只能运行三次，超过三次之后就提升购买正版，退出jvm
 
 */
public class MyDemo5 {
	public static void main(String[] args) throws IOException {
		method2();
	}
	
	public static void method2() throws IOException {
		Properties properties=new Properties();
		File file=new File("/Users/L/Downloads/aaa/count.properties");
		if(!file.exists()){
			FileWriter fileWriter=new FileWriter(file);
			properties.setProperty("count", "0");
			properties.store(fileWriter, "运行次数");
			fileWriter.close();
		}
		properties.load(new FileReader(file));
		Integer count=Integer.parseInt((String) properties.getProperty("count"));
		if(count>=3){
			System.out.println("试用完毕，请购买正版软件");
			System.exit(0);
		}
		count++;
		System.out.println("你已经使用类"+count+"次");
		properties.setProperty("count", count.toString());
		properties.store(new FileWriter(file), "运行次数");
	}
	
	public static void method1() throws IOException  {
		Properties properties=new Properties();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("/Users/L/Downloads/aaa/pz1.properties");
			properties.load(fileReader);
			Object object=properties.getProperty("count");
			Integer count=Integer.parseInt((String) object);
			if(count>3){
				System.out.println("试用完毕，请购买正版软件");
			}
			count++;
			properties.setProperty("count", count.toString());
			FileWriter fileWriter=new FileWriter("/Users/L/Downloads/aaa/pz1.properties");
			properties.store(fileWriter, "运行次数");
			fileWriter.close();
		} catch (FileNotFoundException e) {
			FileWriter fileWriter=new FileWriter("/Users/L/Downloads/aaa/pz1.properties");
			properties.setProperty("count", "1");
			properties.store(fileWriter, "运行次数");
			fileWriter.close();
		}
		if(fileReader!=null){
			fileReader.close();
		}
	}
	
	
}
