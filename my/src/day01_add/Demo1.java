package day01_add;

import java.net.URL;

public class Demo1{
    public static void main(String[] args){
        System.out.println("测试，手动编写编译");
        URL s1= Demo1.class.getClassLoader().getResource(".");
        URL s2= Demo1.class.getClassLoader().getResource("/");
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
    }
}
