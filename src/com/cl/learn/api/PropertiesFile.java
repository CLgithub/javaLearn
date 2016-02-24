package com.cl.learn.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	/**
	 * Properties测试,properties是Hashtable子类
	 * @author L
	 * @date 2016年2月24日
	 * @param args
	 */
	public static void main(String[] args) {
		Properties properties=new Properties();
		String name="e:/Properties.txt";
		try {
			properties.load(new FileInputStream(name));
		} catch (IOException e) {
			properties.put("count", new Integer(0).toString());
		}
		Integer count=Integer.parseInt(properties.getProperty("count"))+1;
		System.out.println("程序第"+count+"次运行");
		//将次数put到count
		properties.put("count", count.toString());
		//
		try {
			properties.store(new FileOutputStream(name), "Tist Program is used:");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
