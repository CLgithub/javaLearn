package com.cl.javabasis.day13;

import java.util.Arrays;
import java.util.Properties;

/**
 * System 类，主要用于获取系统的属性 
 * System类常用的方法：
 * 		arraycopy(src, srcPos, dest, destPos, length)
 * 		currentTimeMillis()得到系统时间
 * 		exit()退出jvm虚拟机
 * 		gc()	建议jvm虚拟机赶快启动垃圾回收器回收垃圾
 * 		finlize()	如果一个对象被垃圾回收器回收的时候，会先调用对象的finlize方法
 * 		getenv()	获得所有环境变量
 * 		getProperties() 获得所有系统属性
 */
public class MyDemo1 {
	public static void main(String[] args) {
//		method1();
//		getOSTime();
//		testExit();
		testGC2();
//		testGetenv();
	}

	/**
	 * src 源数组
	 * srcPos 源数组的起始位置
	 * dest 目标数组 
	 * destPos 目标数组中的起始位置 
	 * length 要复制的数组元素的数量*
	 * @author L
	 * @date 2016年3月20日
	 */
	static void method1() {
		int[] arr1 = { 2, 4, 6, 3, 5, 1 };
		int[] arr2 = new int[3];

		System.arraycopy(arr1, 1, arr2, 1, 2);
		System.out.println(Arrays.toString(arr2));

	}
	
	static void getOSTime(){
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * exit(int status)方法测试，0正常退出，非0异常退出
	 * 注意0或非0的数据都可以退出java虚拟机，对用使用者来说没有区别
	 * @author L
	 * @date 2016年3月20日
	 */
	static void testExit(){
		try {
			System.exit(0);
			System.out.println("MyDemo1.testExit()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testGC(){
		System.gc();
	}
	
	static void testGC2(){
		for(int i=0;i<4;i++){
			new Person("小明"+i);
			System.gc();//建议马上启动gc
		}
	}
	
	static void testGetenv(){
//		System.out.println(System.getenv());//获得所有环境变量
//		System.out.println(System.getenv("PATH"));
//		Properties properties=System.getProperties();//获得所有系统属性
//		properties.list(System.out);
//		System.out.println(System.getProperty("user.dir"));//获得某个系统属性
	}
	
}

class Person{
	String name;
	public Person(String name) {
		this.name = name;
	}
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.name+"被回收");
	}
	
}
