package com.cl.javabasis.day8;

/**
2：多态可以作为返回值类型。
 获取任意一辆车对象
 1：定义汽车类，有名字和颜色，提供有参和无参构造，有运行的行为。
 2：定义Bmw类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
 3：定义Benz类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
 4：定义Bsj类，继承Car类，提供无参构造和有参构造（super父类构造），重写父类运行行为。
 5：定义静态方法，汽车工厂，随机生产汽车。使用多态定义方法返回值类型。
	 1：使用(int)Math.round(Math.random()*2); 生成0-2之间随机数。
	 Math 类
	 2：使用if else 判断，指定，0,1,2 new 不同汽车 并返回。
 6：调用该方法，发现多态的好处。
 */
public class MyDemo6 {
	public static void main(String[] args) {
//		new Bmw("宝马x6", "红色").run();
//		new Benz("奔驰", "黑色").run();
		int x = 0;
		while (x < 100) {
			Car c = CarFactory();
			c.run();
			x++;
		}
	}

	// 定义静态方法，汽车工厂，随机生产汽车。使用多态定义方法返回值类型。
	// 使用随机数，0.1.2 if 0 bsj 1 bmw 2 bc
	public static Car CarFactory() {
		int x = (int) Math.round(Math.random() * 2);
		if (0 == x) {
			return new Bmw("宝马x6", "红色");
		} else if (1 == x) {
			return new Benz("奔驰", "黑色");
		} else if (2 == x) {
			return new Bsj("保时捷", "棕色");
		} else {
			return new Benz("Smart", "红色");
		}

	}
}
class Car{
	Car() {}
	Car(String name, String color) {
		this.name = name;
		this.color = color;
	}
	String name;
	String color;
	void run(){
		System.out.println(this.name+this.color+"跑跑");
	}
}
class Bmw extends Car{
	Bmw() {}
	Bmw(String name, String color) {
		super(name, color);
	}
	void run(){
		System.out.println(this.name+this.color+"宝马跑");
	}
}
class Benz extends Car{
	Benz() {}
	Benz(String name, String color) {
		super(name, color);
	}
	void run(){
		System.out.println(this.name+this.color+"奔驰跑");
	}
}
class Bsj extends Car{
	Bsj() {}
	Bsj(String name, String color) {
		super(name, color);
	}
	void run(){
		System.out.println(this.name+this.color+"保时捷跑");
	}
}