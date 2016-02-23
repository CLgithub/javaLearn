package com.cl.learn.iotest.charcode;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharCode {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.getProperties().put("file.encoding", "iso8859-1");
		System.getProperties().list(System.out);
		String str = "中";
		for (int i = 0; i < str.length(); i++) {
//			System.out.println(Integer.toBinaryString(str.charAt(i)));
			System.out.println("Unicode:"+Integer.toHexString(str.charAt(i)));
		}
//		byte[] buf = str.getBytes("gb2312");//将str转换为指定编码字节数组
		byte[] buf = str.getBytes();//将str转换为默认编码字节数组
		for (int i = 0; i < buf.length; i++) {
//			System.out.println(Integer.toBinaryString(buf[i]));
			System.out.println(Integer.toHexString(buf[i]));
		}
		System.out.println(str);//实际上也是先将“中”转换为utf-8（设置的工程编码）编码的字节数组，再调用write写入到输出流中
		for (int i = 0; i < buf.length; i++) {
			System.out.write(buf[i]);//将转换了编码的字节数组写入到System.out对象中
		}
		System.out.println("a");//调用println()方法是会调用flush()方法刷新缓存区
	}
}
