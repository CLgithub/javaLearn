package com.cl.javabasis.day16;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 集合的体系：
 * ------------|Collection	单列集合的根接口
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * -----------------------|LinkedList	ListkedList底层使用了链表数据结构实现的，特点：查询慢，增加快
 * -----------------------|Vector(了解) 底层也是维护了一个object的数组实现的，与arraylist是一样的，但是Vector是线程安全的，操作效率低
 * 
 * ------------------|Set	如果实现了Set接口的集合类，无序，不可重复
 * 								添加元素的顺序和出来元素的顺序不一样
 * -----------------------|HashSet	底层是使用哈希表来支持的，特点：存储快
							hashSet的实现原理：
								往Haset添加元素的时候，HashSet会先调用元素的hashCode方法得到元素的哈希值 ，
								然后通过元素 的哈希值经过移位等运算，就可以算出该元素在哈希表中 的存储位置。
								情况1： 如果算出元素存储的位置目前没有任何元素存储，那么该元素可以直接存储到该位置上。
								情况2： 如果算出该元素的存储位置目前已经存在有其他的元素了，那么会调用该元素的equals方法
								与该位置的元素再比较一次
								，如果equals返回的是true，那么该元素与这个位置上的元素就视为重复元素，不允许添加，
								如果equals方法返回的是false，那么该元素运行 添加。
 * -----------------------|TreeSet	如果元素具备自然顺序的特性，那么会按照元素自然顺序的特性排序存储
 * 							要注意：
 * 								1.往treeSet添加元素的时候，如果元素本事具备自然顺序的特性，那么久按照自然顺序的特性进行排序
 * 								2.往TreeSet添加元素的时候，如果元素本身不具备自然顺序的特性，那么该元素所属的类必须要实现
 * 									Comparable接口，把元素的比较规则定义在compareTo(T o)方法上。
 * 								3.如果比较元素的时候，compareTo方法返回 的是0，那么该元素就被视为重复元素，不允许添加.
 * 									(注意：TreeSet与HashCode、equals方法是没有任何关系。)
 * 								4.往TreeSet添加元素的时候，如果元素本身没有具备自然顺序的特性，而元素所属的类也没有实
 * 									现Comparable接口，那么必须要在创建TreeSet的时候传入一个比较器。
 * 
 * 										比较器
 * 											如何自定义定义比较器： 自定义一个类实现Comparator接口即可，把元素与元素之间的
 * 												比较规则定义在compare方法内即可。
 * 										两种方式，推荐使用方式二比较器（Comparator）
 * 								
 * 								5.往TreeSet添加元素的时候，如果元素本身不具备自然顺序的特性，而元素所属的类已经实现了
 * 									Comparable接口， 在创建TreeSet对象的时候也传入了比较器那么是以比较器的比较规则优先使用。
 */
public class MyDemo4 {
	public static void main(String[] args) {
//		TreeSet treeSet=new TreeSet(); 
		/*treeSet.add(10);
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(7);*/
		
		/*treeSet.add('b');
		treeSet.add('a');
		treeSet.add('e');
		treeSet.add('q');*/
		
//		treeSet.add(new Emp(110, "小明", 100));
//		treeSet.add(new Emp(440, "小白", 300));
//		treeSet.add(new Emp(220, "小红", 200));
//		treeSet.add(new Emp(100, "小李", 500));
//		treeSet.add(new Emp(330, "小黑", 400));
		
		//二叉树如果3个节点不能成树叉，则会自动调整节点，成树叉
		/*treeSet.add(new Emp(110, "小明", 100));
		treeSet.add(new Emp(220, "小红", 200));
		treeSet.add(new Emp(440, "小白", 300));
		treeSet.add(new Emp(330, "小黑", 400));
		treeSet.add(new Emp(100, "小李", 500));*/
		
		MyComparator myComparator=new MyComparator();
		TreeSet treeSet=new TreeSet(myComparator);
		
//		treeSet.add(new Emp1(110, "小明", 100));
//		treeSet.add(new Emp1(220, "小红", 200));
//		treeSet.add(new Emp1(440, "小白", 300));
//		treeSet.add(new Emp1(330, "小黑", 400));
//		treeSet.add(new Emp1(100, "小李", 500));
		
		//方式一和二一起时，按照比较器的规则
		treeSet.add(new Emp(110, "小明", 100));
		treeSet.add(new Emp(220, "小红", 200));
		treeSet.add(new Emp(440, "小白", 500));
		treeSet.add(new Emp(330, "小黑", 400));
		treeSet.add(new Emp(100, "小李", 250));
		
		System.out.println(treeSet);
		
		
	}
	
}
//方式一
class Emp implements Comparable{
	int id;
	String name;
	int salary;

	public Emp(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[编号=" + id + ",姓名=" + name + ",薪水=" + salary + "]";
	}

	/**
	 * 元素与元素之间的比较规则
	 * 返回：负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。 
	 */
	@Override
	public int compareTo(Object o) {
		Emp emp=(Emp) o;
		System.out.println(this.name+"comare"+emp.name);
		return this.salary-emp.salary;//按照薪水排序
//		return this.id-emp.id;
	}
}

//方式二
class Emp1 {
	int id;
	String name;
	int salary;

	public Emp1(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[编号=" + id + ",姓名=" + name + ",薪水=" + salary + "]";
	}
	
}

//自定义一个比较器类
class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Emp emp11=(Emp) o1;
		Emp emp12=(Emp) o2;
		return emp11.id-emp12.id;
	}
	
}
