package com.cl.javabasis.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date日期类
 * Calendar日历类
 * SimpleDateFormat 日期格式化类
 * 		作用：
 * 			1.将日期转换为指定格式的字符串
 * 			2.将字符串转换为对应的日期
 * @author L
 * @date 2016年3月20日
 */
public class MyDemo3 {
	public static void main(String[] args) {
		method2();
	}
	
	static void method1(){
		//获取当前系统时间
		Date date=new Date();
		System.out.println(date);
		
		//获取当前系统日历
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//HOUR_OF_DAY是24小时制
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		
	}
	
	/**
	 * SimpleDateFormat 日期格式化类 
	 * 	作用：
	 * 	 1.将日期转换为指定格式的字符串
	 * 	 2.将字符串转换为对应的日期
	 * @author L
	 * @throws ParseException 
	 * @date 2016年3月20日
	 */
	static void method2(){
		try {
			SimpleDateFormat format1=new SimpleDateFormat();//默认
			System.out.println(format1.format(new Date()));
			// 1.将日期转换为指定格式的字符串
			//显示当前系统时间：YYYY年MM月dd日 hh时mm分ss秒
			String str="yyyy年MM月dd日 HH时mm分ss秒";
			SimpleDateFormat format2=new SimpleDateFormat(str);//默认
			System.out.println(format2.format(new Date(System.currentTimeMillis())));
			
			//2.将字符串转换为对应的日期
			String birthday="2000-02-22 13:34:23";
			String str3="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format3=new SimpleDateFormat(str3);//默认
			Date date=format3.parse(birthday);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
