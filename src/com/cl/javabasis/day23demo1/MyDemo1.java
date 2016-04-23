package com.cl.javabasis.day23demo1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 网络编程：网络编程主要用于解决计算机与计算机（手机📱，平板……）直之间到数据传输问题
 
 网络编程：不需要基于html页面就可以达到数据之间的传输，比如：feiq，qq，微信，……
 网页编程：基于html页面的基础上进行数据的交互。比如：oa，淘宝，京东，……
 
 计算机网络：分布在不同地域的计算机通过外边设备链接起来，达到了消息互通，资源共享的效果就称作为计算机网络
 
 网络通讯的三要素：
 	1.IP
 	2.端口号		：用于标明该消息是交个那个应用程序处理，只不过是个标准符而已
 	3.协议
 	
 1.IP地址:本质是一个32位二进制数据。后来为了方便记忆ip地址，就把ip地址切成了4份，每份8bit。	2^8 = 0~255
 	192.168.1.103 11000000-10101000-00000001-01100111
 	
	 IP地址＝网络号＋主机号
	 	
	 IP地址分类:
	 	A类地址 ＝ 一个网络号 ＋ 三个主机号	可配置2^(3*8)个地址	政府单位
	 	B类地址 ＝ 两个网络号 ＋ 两个主机号	2^16				事业单位
	 	C类地址 ＝ 三个网络号 ＋ 一个主机号	2^8					私人使用
	 	
	 IP类：InetAddress
	 	常用的方法：
	 		getLocalHost()		获取本机的ip地址对象
	 		getByName(String host) 在给定主机名的情况下确定主机的 IP 地址。
	 		getHostAddress()	返回 IP 地址字符串（以文本表现形式）。
	 		getHostName()		返回主机名
 
 2.端口号是没有类来描述：
 	端口号的范围：0～65535
 	0～1023，系统紧密绑定于一些服务
 	1024～65535:我们可以使用。。。
 	
 3.网络通讯的协议：
 	udp协议：用户数据报协议
 	
 	tcp协议：传输控制协议
 	
 	
 */
public class MyDemo1 {
	public static void main(String[] args) throws IOException {
		//getLocalHost 获取本机的ip地址对象
//		InetAddress inetAddress=InetAddress.getLocalHost();
//		System.out.println("IP地址:"+inetAddress.getHostAddress());
//		System.out.println("主机名:"+inetAddress.getHostName());
		
		//获取别人机器的ip地址对象,
		
		//可以根据一个ip地址的字符串形式或者一个主机名生成一个ip地址对象。
//		InetAddress inetAddress2=InetAddress.getByName("192.168.1.105");
////		InetAddress inetAddress2=InetAddress.getByName("LdeiMac");
//		System.out.println("IP地址:"+inetAddress2.getHostAddress());
//		System.out.println("主机名:"+inetAddress2.getHostName());
		
		InetAddress[] addresses=InetAddress.getAllByName("www.google.com.hk");//ip 主机名 域名
		System.out.println(Arrays.toString(addresses));
	}
}
