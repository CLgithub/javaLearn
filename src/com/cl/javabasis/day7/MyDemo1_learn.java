package com.cl.javabasis.day7;

/**
 * 单例模式
 * 实现思路：
 * 	1、私有化构造方法
 * 	2、提供一个公有(别人能访问)静态(不用对象也能访问，因为别人没有对象)的获取方法
 * @author chenlei
 * @date 2021年11月16日
 */
public class MyDemo1_learn {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println(new MyDemo1_learn()==new MyDemo1_learn());
		System.out.println(Demo0.getDemo0()==Demo0.getDemo0());
		System.out.println(Demo1.getDemo1()==Demo1.getDemo1());
		System.out.println(Demo2.getDemo2()==Demo2.getDemo2());
		System.out.println(Demo3.getDemo3()==Demo3.getDemo3());
		System.out.println(Demo4.getDemo4()==Demo4.getDemo4());
//		Class<Demo4> class1=Demo4.class;
//		Demo4 newInstance = class1.newInstance(); // 构造方法私有的，不能调用此方法
//		System.out.println(Demo4.getDemo4()==newInstance);
		System.out.println(Demo4.getDemo4()==Demo4.getDemo4());
//		System.out.println(Demo4.C2.demo4==Demo4.C2.demo4);
	}
}

/**
 * 饿汉模式,线程安全
 * 优点：线程安全
 * 缺点：加载类时就直接new对象，可能造成资源浪费
 * @author chenlei
 * @date 2021年11月16日
 */
class Demo0{
	private Demo0(){}
	private static Demo0 demo0=new Demo0();
	
	public static Demo0 getDemo0() {
		return demo0;
	}
}

/**
 * 懒汉模式，线程不安全
 * 优点：使用时才new对象
 * 缺点：getDemo1方法线程不安全
 * @author chenlei
 * @date 2021年11月16日
 */
class Demo1{
	private Demo1() {
		super();
	}
	private static Demo1 demo1=null;
	public static Demo1 getDemo1() {
		if(demo1==null) {
			demo1=new Demo1();
		}
		return demo1;
	}
}

/**
 * 懒汉模式，线程安全
 * 优点：使用时才new对象，切线程安全
 * 缺点：getDemo2方法线程安全，单性能比较差，每一个线程到这里都需要等待锁
 * @author chenlei
 * @date 2021年11月16日
 */
class Demo2{
	private Demo2() {
	}
	private static Demo2 demo2;
	public synchronized static Demo2 getDemo2() {
		if(demo2==null) {
			demo2=new Demo2();
		}
		return demo2;
	}
}

/**
 * 双重检查锁实现，线程安全
 * 优点：使用时才new对象，且线程安全，并且只有最开始new的时候才会等待锁
 * 缺点：volatile关键字，对性能有些影响
 * @author chenlei
 * @date 2021年11月16日
 */
class Demo3{
	private Demo3() {
	}
	private volatile static Demo3 demo3;	// volatile关键字，确保在new Demo3()时，不会「指令重排」
	public static Demo3 getDemo3() {
		if(demo3==null) {
			synchronized (Demo3.class) {
				demo3=new Demo3();
			}
		}
		return demo3;
	}
}

/**
 * 静态内部类，线程安全
 * 设计思路，
 * 	1 构造方法私有化
 * 	2 提供一个公有静态方法获取
 * 	3 编写一个静态内部类，在静态内部内当中提供new
 * 	4 这样做的好处在于，Demo4加载时，并不会加载C2，因此不会被提前new，当getDemo4方法被调用时，才会加载C2，
 * @author chenlei
 * @date 2021年11月16日
 */
class Demo4{
	private Demo4(){}
	
	private static class C2 {
		private static final Demo4 demo4=new Demo4();	// 是否必须加final
	}
	
	public static Demo4 getDemo4() {
		return C2.demo4;
	}
}







