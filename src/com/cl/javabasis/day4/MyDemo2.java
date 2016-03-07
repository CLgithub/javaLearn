package com.cl.javabasis.day4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyDemo2 {
	public static void main(String[] args) {
		method2();
	}
	
	/**
	 * 计算1+2+3+4+5+6+7+8+9 的值
	 * @author L
	 * @date 2016年3月7日
	 */
	public static void method1(){
		int i=1;
		int sum=0;
		while(i<10){
			sum+=i;
			i++;
		}
		System.out.println(sum);
	}
	
	/**
	 * 编写程序随即生成一个0-100之间的随机数。程序提示用户输入一个数字，
	 * 不停猜测，直到猜对为止。最后输出猜测的数字，和猜测的次数。
	 * 并且如果没有猜中要提示用户输入的值是大了还是小了。
	 * @author L
	 * @date 2016年3月7日
	 */
	public static void method2(){
		try {
			Integer i1=(int) (Math.random()*100)+1;
			System.out.println(i1);
			System.out.println("请输入0-100之间整数");
			InputStream iStream=System.in;
			BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			Integer i2=null;
			int count=0;//用于计数
			while(true){
				count++;
				String string=bReader.readLine();
				i2=new Integer(string);
				if(i2>i1){
					System.out.println("大了");
				}else if(i2<i1){
					System.out.println("小了");
				}else {
					System.out.println("结果"+i2);
					System.out.println(count+"次猜中！");
					break;
				}
			}
			System.out.println("结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
