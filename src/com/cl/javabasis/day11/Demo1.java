package com.cl.javabasis.day11;

/*
sun提供了很多的异常类给我们描述程序中各种不正常情况，但是还不足以描述所以
我们需要自定义异常类

需求：模拟feiq上线的时候，如果没有插上网线，那么久抛出一个没有插上网线的异常
如果已经插上了网线，那么就正常显示好友列表

自定义异常类的步骤：自定义一个类继承Exception即可

需求：模拟去吃饭，如果没有带够10元钱，那么就抛出没有代购钱的异常，如果带够了，就可以吃上香喷喷的地沟油饭


*/
public class Demo1 {
	public static void main(String[] args) {
//		String ip=null;
//		try {
//			feiQ(ip);
//		} catch (NoIpException e) {
//			e.printStackTrace();
//		}
		
		try {
			etc(30);
		} catch (NoQain e) {
			e.printStackTrace();
			System.out.println("回去拿钱");
		}
	}
	
	public static void etc(int qian) throws NoQain{
		if(qian<10){
			throw new NoQain("没带够钱");
		}
		System.out.println("正常吃饭");
	}
	

	public static void feiQ(String ip) throws NoIpException {
		if(null==ip){
			//抛出一个没有插上网线的异常
			throw new NoIpException("没有插上网线异常");
		}
		System.out.println("正常显示好友列表");
	}
	
	
}

//自定义一个异常类
class NoIpException extends Exception{

	public NoIpException(String string) {
		super(string);//调用了exception一个参数的构造函数
	}
}

class NoQain extends Exception{

	public NoQain(String string) {
		super(string);
	}
	
}
