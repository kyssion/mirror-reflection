package java包.a_util.a_array;
//不是线程同步的方法
//接口Serializable序列化, Cloneable 复制方法, Iterable<E> 迭代器, Collection<E> 集合对象, List<E>, RandomAccess 快速随机访问方法速度快于Iterable

import java.lang.reflect.Array;
import java.util.ArrayList;

public class b_MyArrayList {
	ArrayList<String> arrayList= new ArrayList<>();
	public void method(){
		arrayList.add(0, "1233");//添加 数据进入集合之中   第一个参数可以省略
		arrayList.addAll(0,arrayList);//讲一个实现 collection<E>接口的集合传入变成一个函数 地爱一个参数可以省略表示从什么卫士开始添加集合
		String string =arrayList.set(0, "sdf"); //用指定的元素替代此列表中指定位置上的元素。返回被替换的元素 
		int size = arrayList.size();
		String[] array = (String[]) arrayList.toArray();//	返回list 转化成的数组
		arrayList.clear();//清除集合内所有的元素
		ArrayList<String> arrayList2=(ArrayList<String>) arrayList.clone();//放回 一个浅复制克隆体
		//浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象。深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。
		boolean b=arrayList.contains("234");//如果此列表中包含指定的元素，则返回 true。
		//ensureCapacity(int minCapacity);如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
		String string4 =arrayList2.get(2); //返回此列表中指定位置上的元素。 
		int i=arrayList2.indexOf("sss"); //返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。 
		b=arrayList2.isEmpty();			//判空
		String string2=arrayList2. remove(3); //移除此列表中指定位置上的元素。 
		boolean bb=arrayList2.remove("sdfsdf"); //移除此列表中首次出现的指定元素（如果存在）。 
	}
}