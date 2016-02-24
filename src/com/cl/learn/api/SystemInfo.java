package com.cl.learn.api;

import java.util.Enumeration;
import java.util.Properties;

public class SystemInfo {
	public static void main(String[] args) {
		Properties properties=System.getProperties();
		Enumeration enumeration=properties.propertyNames();
		while(enumeration.hasMoreElements()){
			String key=(String) enumeration.nextElement();
			Object value=properties.getProperty(key);
			System.out.println(key+"--->"+value);
		}
	}
}
