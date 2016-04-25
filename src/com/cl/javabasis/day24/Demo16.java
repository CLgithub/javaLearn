package com.cl.javabasis.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

/*
 treeMap应用
 需求：从键盘输入一个字母组成字符串，分别统计每个字母出现的次数(10分)
	要求输出的效果按照字母的顺序输出  a(7)b(5)...
 */
public class Demo16 {
	public static void main(String[] args) throws IOException {
		InputStreamReader iStreamReader=new InputStreamReader(System.in);

		char[] buf=new char[1024];
		int content=0;
		while((content=iStreamReader.read(buf))!=-1){
			String str=new String(buf,0,content);
			char[] arr=str.substring(0, str.length()-1).toCharArray();//去掉回车字符
			System.out.println(arr.length);
			TreeMap<Character, Integer> treeMap=new TreeMap<>();
			for(Character c:arr){
				if(!treeMap.containsKey(c)){
					treeMap.put(c, 1);
				}else {
					treeMap.put(c, treeMap.get(c)+1);
				}
			}
			System.out.println(treeMap);
			
			
		}
		
	}
}
