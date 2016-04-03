package com.cl.javabasis.day16;
/**
 * 集合：集合是存储对象数据的集合容器。
	集合比数组的优势：
	1. 集合可以存储任意类型的对象数据，数组只能存储同一种数据类型 的数据。
	2. 集合的长度是会发生变化的，数组的长度是固定的。
	
 *  集合的体系：
 * ------------|Collection	单列集合的根接口
 * 					常用方法
 * 						增加
							add(E e)  //添加成功返回true，添加 失败返回false.
							addAll(Collection c)  //把一个集合 的元素添加到另外一个集合中去。
						删除
							clear() //清空集合中的元素
							remove(Object o) //指定集合中的元素进行删除，删除成功true，失败false
							
							removeAll(Collection  c) c.removeAll(c2);//删除c集合中与c2的交集的元素
							retainAll(Collection  c) c.retainAll(c2);//保留c集合中与c2的交集元素 
						查看
							size() //得到集合长度
						判断
							isEmpty() //是否为空
							contains(Object o) //包含某个元素吗
							containsAll(Collection<?> c) //System.out.println("c集合有包含c2集合中的所有元素吗："+c.containsAll(c2));
						迭代
							toArray() //把集合中的全部元素放到一个object的数组中返回
							iterator() //得到迭代器，
 * ------------------|List	如果实现了List接口的集合类，有序，可重复
 * 						List特有的方法
							添加		
								add(Object object)
							 	addAll(Collection<? extends E> c)  
							 获取
							 	get(int index)  //得到某位置的集合元素
							 	indexOf(Object o) 	//找出指定元素第一次出现在集合中的索引值
							 	lastIndexOf(Object o) //找出指定元素第一次出现在集合中的索引值
							 	subList(int fromIndex, int toIndex) 返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分list
							 修改
							 	set(int index, E element) //设置某位置的元素为element
							 	
					 	List接口中特有的方法具备的特点：操作的方法都具有索引值	 
						只有list接口下面的集合类才具备索引值，其他接口下面的集合类都不具有索引值
						
						* 迭代
						listIterator() 
						
 * -----------------------|ArrayList	ArrayList底层是维护了一个Object数组实现的，特点：查询快，增删慢
 * 											什么时候使用ArrayList:如果目前的数据是查询比较多，增删比较少的时候，比如：高校的图书馆
 								ArrayList 特有的方法
									ensureCapacity(int minCapacity) //一般用构造方法指定
									trimToSize() 
 * -----------------------|LinkedList	ListkedList底层使用了链表数据结构实现的，特点：查询慢，增加快
								LinkedList 常用特有的方法
										1：方法介绍
								            addFirst(E e) 把元素添加到集合的首位置上
											addLast(E e) 把元素添加到集合的末尾
											getFirst() 获取集合的首位置元素
											getLast() 获取集合的末尾位置元素
											removeFirst() 删除集合首位置元素并返回
											removeLast() 删除集合末尾位置元素并返回
												如果集合中没有元素，获取或者删除元
												素抛：NoSuchElementException
										2：数据结构
											1：栈 （1.6）：主要是用于实现（模拟）堆栈数据结构的存储方式
												先进后出
												push() 将元素插入到集合首位置（将元素push到栈中）
												pop() 移除并返回集合中的首位置元素
											2：队列（双端队列1.5）：主要是为了可以使用linkedList模拟队列数据结构的存储方式
												先进先出
												offer()	将元素加到集合的末尾处（特殊是末尾）
												poll()	移除集合的首位置元素并返回
										3：返回逆序的迭代器对象      
												descendingIterator()   返回逆序的迭代器对象
 * -----------------------|Vector(了解)	底层也是维护了一个object的数组实现的，与arraylist是一样的，但是Vector是线程安全的，操作效率低
 * 
 * ------------------|Set	如果实现了Set接口的集合类，无序，不可重复

 * 迭代器总结：
----| iterator() //得到迭代器，
	迭代器的方法：
		hasNext()	当前指针是否有指向元素，如果有元素可以返回true，否则返回false
		next()	取出元素，指针向下移动
		remove()	移除迭代器最后一次返回的元素
	
	注意：迭代器在遍历的时候要注意的事项
		 * 在迭代器迭代元素的过程中(迭代器创建到使用结束，就不允许集合对象……)，不允许使用集合对象改变集合中的元素个数，如果需要添加或删除
		 * 只能使用迭代器的方法进行操作
		 * 如果使用了集合对象改变了集合中的元素个数，就会出现ConcurrentModificationException异常
------| listIterator()
			特有的方法
				添加：
				hasPrevious()//判断是否存在上一个元素
				previous()  //获取上一个元素,原来：当前指针先向上移动一个单位，然后再取出当前指针的元素
							而next()是先取，再向下移
		
				add（E）	//把当前元素插入到当前指针指向的位置上去，指针向下移动一位
				set(E e) //替换迭代器最后一次返回的元素
								
 */
public class ZJList {

}
