package java包.a_util.a_array.集合;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Spliterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class b_实现接口实现类 {
	//实现list 接口
	public void method(){
		//链表类 表示链表的集合--实现了 list deque 和queue 接口--接口中的所有方法都实现了 但是注意链表的特性
		LinkedList<String> linkedList = new LinkedList<>();//构造函数传入可以集合
		//相比较 arraylist add 速度更快
		//ArrayList -- 扩展abstractList 实现动态数组 实现了 list接口
		ArrayList<String> arrayList = new ArrayList<>();//构造函数可以传入 集合或者 capacity
		arrayList.add("string");
		arrayList.toArray();//----注意toarray类型的方法
		//Vector 类  同步arraylist
		Vector<String> vector = new Vector<>();
 	}
	//实现 set  接口  散列机制
	public void method1(){
		//hash 散列   实现了 set接口保证了 add remove contains size 方法时间函数相同  存储数据的时候并不保证数据的连续性
		HashSet<String> hashSet = new HashSet<>();//可以传入 集合 容量  或者容量和填充率-
		//知识继承了hashset 保证了数据的可继承
		LinkedHashSet<String> linkedHashSet =new LinkedHashSet<>();//保证了数据可以顺序返回
		//sortset唯一的实现类
		TreeSet<String> treeSet = new TreeSet<>();//四种构造方法  默认 按照自然排序法进行排序 可传入集合 比较器 或者 srotedSet集合对象
	}
	//实现Queue的类
	public void method2(){
		//priorityQueue  优先队列
		PriorityQueue<String> priorityQueue = new PriorityQueue<>();//可以传入指定大小的初容量 比较器 优先队列  或者实现了 sortedSet接口的对象
		//因为这个函数的第二代顺序并不是确定的 必须使用如下类型的方法进行调用
		priorityQueue.offer("hehe");//添加元素进入对象之中
		priorityQueue.poll();//出队列
	}
	//deque--实现了deque - 接口
	public  void  method3(){
		//简单的双端队列的实现类
		ArrayDeque<String> arrayDeque =  new ArrayDeque<>();//构造参数有 大小和集合
	}
	//实现map接口的实现类
	public void method4() throws FileNotFoundException, IOException{
		//HashMap 实现了  map接口  扩展了 NAvigableMap
		HashMap<String, String> map = new HashMap<>();//构造方法有 map集合 和 指定宽度 和 定宽度并且指定响应值
		map.put("stig", "sss");
		map.get("sss");
		//treeMap  --实现了  map接口  扩展了 NAvigableMap接口
		TreeMap<String, String> treeMap = new TreeMap<>();//可以传入一个比较器 可以传入一个 map映射  可以传入一个 sorted map
		//linkedHashMap -- 扩展了 hashMap --实现 链表hashMap
		//hashtable   和 hashmap类似但是是一个同步类
		Hashtable<String, String> hashtable = new Hashtable<>();
		//Propertiese  -- 读取 properties文件中的项目  读写配置文件
		Properties properties = new Properties();
		properties.getProperty("");//获取数据
		properties.getProperty("", "a");
		properties.load(new FileInputStream(""));//加载配置文件 .properties 后缀的
		properties.loadFromXML(new FileInputStream(""));
		properties.setProperty("xxx", "xxx");//设置属性字符流属性
		properties.store(new FileOutputStream(""), "");//将设置好的字符流插入到文件之中之后最后一个字符串是 标题
		properties.storeToXML(new FileOutputStream(""), "");
		//weakHashmap ---弱类型 hash 运行gc垃圾回收机制自动回收
		WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(new String("sss"), "sdf");//将尽心垃圾回收  因为因为外部没有强引用了
		//比较key的地址
		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
		identityHashMap.put("123","333");
		identityHashMap.put(new String("123"), "234");//第一个和第二个将是不同的地址
		//java中随便写一个字符串将会自动变成一个常量
		//enmeMap  ---  枚举类型 map
		EnumMap<hehe, String> enumMap = new EnumMap<>(hehe.class);
	}
	enum hehe{
		EEE,BBB,CCC;
	}
	//vector  同步  arraylist
	class myvetor extends Vector<String>{
		//添加数据进入 数组之中
		public void add(int index, String element) {super.add(index, element);}
		public synchronized boolean add(String e) {return super.add(e);}
		public synchronized boolean addAll(Collection<? extends String> c) {return super.addAll(c);}
		public synchronized boolean addAll(int index, Collection<? extends String> c) {return super.addAll(index, c);}
		//添加 元素节点
		public synchronized void addElement(String obj) {super.addElement(obj);}
		//返回向量的容量
		public synchronized int capacity() {return super.capacity();}
		public void clear() {super.clear();}
		public synchronized Object clone() {return super.clone();}
		public boolean contains(Object o) {return super.contains(o);}
		public synchronized boolean containsAll(Collection<?> c) {return super.containsAll(c);}
		//讲述数据中的元素copy到指定的数组之中去
		public synchronized void copyInto(Object[] anArray) {super.copyInto(anArray);}
		//返回指定为止的元素
		public synchronized String elementAt(int index) {return super.elementAt(index);}
		public Enumeration<String> elements() {return super.elements();}
		//将向量的最小元素设置为size
		public synchronized void ensureCapacity(int minCapacity) {super.ensureCapacity(minCapacity);}
		public synchronized String firstElement() {return super.firstElement();}
		//返回第一次出现的位置
		public synchronized int indexOf(Object o, int index) {return super.indexOf(o, index);}
		public int indexOf(Object o) {return super.indexOf(o);}
		//向指定的为止插入指定的数据
		public synchronized void insertElementAt(String obj, int index) {super.insertElementAt(obj, index);}
		public synchronized String lastElement() {return super.lastElement();}
		public synchronized int lastIndexOf(Object o, int index) {return super.lastIndexOf(o, index);}
		public synchronized int lastIndexOf(Object o) {return super.lastIndexOf(o);}
		//返回list迭代器
		public synchronized ListIterator<String> listIterator() {return super.listIterator();}
		public synchronized ListIterator<String> listIterator(int index) {return super.listIterator(index);}
		public synchronized String remove(int index) {return super.remove(index);}
		public boolean remove(Object o) {return super.remove(o);}
		public synchronized boolean removeAll(Collection<?> c) {return super.removeAll(c);}
		public synchronized void removeAllElements() {super.removeAllElements();}
		public synchronized String set(int index, String element) {return super.set(index, element);}
		//将指定的为止设置位指定的值
		public synchronized void setElementAt(String obj, int index) {super.setElementAt(obj, index);}
		public synchronized void setSize(int newSize) {super.setSize(newSize);}
		public synchronized int size() {return super.size();}
	}
	//stack 栈
	class Mystack extends Stack<String>{
		public boolean empty() {return super.empty();}
		//不移除
		public synchronized String peek() {return super.peek();}
		//移除
		public synchronized String pop() {return super.pop();}
		//压栈
		public String push(String item) {return super.push(item);}
		public synchronized int search(Object o) {return super.search(o);}
		
	}
	//tree
	public void method22() {
		
	}
}