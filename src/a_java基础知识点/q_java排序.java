package a_java基础知识点;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class q_java排序 {
	public static void main(String[] args) {
		ArrayList<One> ones = 
				new ArrayList<>();
	}
}
//comparable-比较接口  x.compareTo(xxx)调用的方法
class One implements Comparable<One>{
	@Override
	public int compareTo(One o) {
		// TODO Auto-generated method stub
		//-1 this<o ; 0 this==0 ;1 this>0
		return 0;
	}
}
//Comparator--比较器接口  第三个类实现这个借口来比较指定类型的类
class Mycompare implements Comparator<One>{

	@Override
	public int compare(One o1, One o2) {
		// TODO Auto-generated method stub
		//-1 o1<o2 ; 0 o1==02 ;1 o1>02
		return 0;
	}
	
}