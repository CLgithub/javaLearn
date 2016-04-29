package com.cl.javabasis.day27observer;

import java.util.ArrayList;
import java.util.Random;

/*
观察者设计模式：观察者设计模式解决的问题时当一个对象发生指定的动作时，要通过另外一个对象做出相应的处理。

需求： 编写一个气象站、一个工人，两个类，当气象站更新天气 的时候，要通知人做出相应的处理。

问题1：气象站更新了多次天气，人才做出一次处理
问题2. 在当前对象维护接口的引用，当当前对象发生指定的动作这时候即可调用接口中的方法了。
问题3：在现实生活中出了工人群体要关注天气，其他 的群体也需要关注天气

观察者设计模式的步骤：
	1. 当前目前对象发生指定的动作时，要通知另外一个对象做出相应的处理，这时候应该把对方的相应处理方法定义在接口上。
	2. 在当前对象维护接口的引用，当当前对象发生指定的动作这时候即可调用接口中的方法了。

*/
public class WeatherMain {
	public static void main(String[] args) {
		Emp emp=new Emp("小明");
		Emp emp2=new Emp("小红");
		Student student1=new Student("小黑");
		Student student2=new Student("小白");
		WeatherStation station=new WeatherStation();
		station.startWork();
		station.addLiener(emp);
		station.addLiener(emp2);
		station.addLiener(student1);
		station.addLiener(student2);
		
	}
}
//订阅天气预报的接口
interface Weatherlistener{
	void notifyWeather(String weather);
}
//气象站类
class WeatherStation {
	String[] weathers = {"晴天🌞","雾霾🌁","下雪❄️","多云☁️","下雨☔️"    };
	//当前天气
	String weather;
	//人
	ArrayList<Weatherlistener> wListeners=new ArrayList<>();
	
	public void addLiener(Weatherlistener wListener){
		wListeners.add(wListener);
	}
	//开始工作
	public void startWork() {
		Random random=new Random();
		new Thread(){
			@Override
			public void run() {
				while(true){//每1～1.5秒更新一次天气
					updateWeather();
					//通知人做出反映
					for(Weatherlistener wListener:wListeners ){
						wListener.notifyWeather(weather);
					}
					int s=random.nextInt(501)+1000;//1000~1500
					try {
						Thread.sleep(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	//更新天气
	public void updateWeather() {
		Random random=new Random();
		int index=random.nextInt(weathers.length);
		weather=weathers[index];
		System.out.println("当前的天气是："+weather);
	}
}



class Emp implements Weatherlistener{
	String name;
	public Emp(String name) {
		this.name = name;
	}
	//人要根据天气作出处理	{"晴天🌞","雾霾🌁","下雪❄️","多云☁️","下雨☔️" };
	public void notifyWeather(String weather) {
		if("晴天🌞".equals(weather)){
			System.out.println(name+"高高兴兴的去上班");
		}else if("雾霾🌁".equals(weather)) {
			System.out.println(name+"带着消毒面具🎭去上班");
		}else if("下雪❄️".equals(weather)) {
			System.out.println(name+"穿着棉衣去上班");
		}else if("多云☁️".equals(weather)) {
			System.out.println(name+"忧郁的去上班");
		}else if("下雨☔️".equals(weather)) {
			System.out.println(name+"带着雨伞🌂去上班");
		}
	}
}
class Student implements Weatherlistener{
	String name;
	public Student(String name) {
		this.name = name;
	}
	public void notifyWeather(String weather) {
		if("晴天🌞".equals(weather)){
			System.out.println(name+"高高兴兴的去上学");
		}else if("雾霾🌁".equals(weather)) {
			System.out.println(name+"带着消毒面具🎭去上学");
		}else if("下雪❄️".equals(weather)) {
			System.out.println(name+"穿着棉衣去上学");
		}else if("多云☁️".equals(weather)) {
			System.out.println(name+"忧郁的去上学");
		}else if("下雨☔️".equals(weather)) {
			System.out.println(name+"带着雨伞🌂去上学");
		}
	}
}

