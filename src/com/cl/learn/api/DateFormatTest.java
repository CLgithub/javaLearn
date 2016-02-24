package com.cl.learn.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
	public static void main(String[] args) {
		String str="2016-02-22";
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日");
		try {
			Date date1= sdf1.parse(str);//字符串转换为date
			System.out.println(sdf2.format(date1));//date按某个格式输出
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
