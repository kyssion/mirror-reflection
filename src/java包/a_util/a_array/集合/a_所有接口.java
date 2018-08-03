package java包.a_util.a_array.集合;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
//集合对象在当容量不够的时候将会发生扩张和扩容的方法
public class a_所有接口 {
	public void method() {
		//Collections---java list 集合的工具类  提供各种list操作
		//arrays  --- java 数组对象的工具类 提供各种数组操作
	}
	//--集合的基础接口  表示  一堆数据的统称此此接口是集合框架的接口--扩展了Iterable接口---所有实现了这个接口的都能使用foreach循环
	Collection<String> collection= new Collection<String>() {
		public boolean add(String e) {return false;}
		//讲一个集合插入进来！！！
		public boolean addAll(Collection<? extends String> c) {return false;}//!
		//清除集合中的所元素！！！
		public void clear() {}
		//检查 o 是否是集合中的元素
		public boolean contains(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}//!
		public boolean isEmpty() {return false;}
		//返回一个迭代器！！！
		public Iterator<String> iterator() {return null;}
		//移除一个元素！！！
		public boolean remove(Object o) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}//!
		//移除集合中移除c集合之外的其他元素！！！
		public boolean retainAll(Collection<?> c) {return false;}//!
		//返回集合中的元素的数量！！！
		public int size() {return 0;}
		//将集合变成array数组
		public Object[] toArray() {return null;}
		//返回一个数组  如果集合中的数量超出 a的长度 就分配一个新的数组 否则将数组 存入 a中并且 返回null
		public <T> T[] toArray(T[] a) {return null;}	
		
	};
	//list--扩展了 collection接口 表示连续存放的数据
	List<String> list = new List<String>() {
		//将数据插入制定的位置！！！
		public void add(int index, String element) {}
		public boolean add(String e) {return false;}
		public boolean addAll(Collection<? extends String> c) {return false;}
		public boolean addAll(int index, Collection<? extends String> c) {return false;}
		public void clear() {}//！！！！！！
		//查找是否存在这个元素！！！！！
		public boolean contains(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}//!
		//获得一个位置中的元素
		public String get(int index) {return null;}//!
		//返回第一个实例
		public int indexOf(Object o) {return 0;}
		public boolean isEmpty() {return false;}//判读集合是否是空的
		public Iterator<String> iterator() {return null;}
		//返回最后一个实例
		public int lastIndexOf(Object o) {return 0;}
		public ListIterator<String> listIterator() {return null;}
		//返回一个从指定位置开始的迭代器
		public ListIterator<String> listIterator(int index) {return null;}
		public String remove(int index) {return null;}
		public boolean remove(Object o) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		public boolean retainAll(Collection<?> c) {return false;}//!
		//在列表中的指定为止设置一个数据
		public String set(int index, String element) {return null;}
		public int size() {return 0;}
		//排序算法 船夫一个 comparator 比较器
		public void sort(Comparator<? super String> c) {List.super.sort(c);}//!
		//????不知到是啥
		public Spliterator<String> spliterator() {return List.super.spliterator();}//!
		//分解list
		public List<String> subList(int fromIndex, int toIndex) {return null;}
		public Object[] toArray() {return null;}
		public <T> T[] toArray(T[] a) {return null;}	
	};
	//set 集合  重写了 collection接口  并且 声明了集合中不许有重复元素组的行为
	Set<String> set = new Set<String>() {
		//如果添加了 重复的元素 add 方法将会返回false
		public boolean add(String e) {return false;}
		public boolean addAll(Collection<? extends String> c) {return false;}
		public void clear() {}
		public boolean contains(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}
		public boolean isEmpty() {return false;}
		public boolean remove(Object o) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		public boolean retainAll(Collection<?> c) {return false;}
		public int size() {return 0;}
		public Iterator<String> iterator() {return null;}
		public Spliterator<String> spliterator() {return Set.super.spliterator();}//!
		public Object[] toArray() {return null;}
		public <T> T[] toArray(T[] a) {return null;}
		
	};
	//sortedSet---声明了用升序排列数组的行为   ---接口 继承了 set 并且指明了
	SortedSet<String> sortedSet = new SortedSet<String>() {
		//------扩展方法
		//返回调序调用组的排序规则 可以设置排序g规则吧???
		public Comparator<? super String> comparator() {return null;}
		//返回第一个元素
		public String first() {return null;}
		//返回排序集合中返回小于toElement的元素
		public SortedSet<String> headSet(String toElement) {return null;}//!
		//返回最后一个元素
		public String last() {return null;}
		public Spliterator<String> spliterator() {return SortedSet.super.spliterator();}
		//返回调序掉用组在from和to之间的元素
		public SortedSet<String> subSet(String fromElement, String toElement) {return null;}//!
		//返回集合对象中大于或者等于form的元素
		public SortedSet<String> tailSet(String fromElement) {return null;}//!
		//set 接口方法
		public boolean add(String e) {return false;}
		public boolean addAll(Collection<? extends String> c) {return false;}
		public void clear() {}
		public boolean contains(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}
		public boolean isEmpty() {return false;}
		public Iterator<String> iterator() {return null;}
		public boolean remove(Object o) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		public boolean retainAll(Collection<?> c) {return false;}
		public int size() {return 0;}
		public Object[] toArray() {return null;}
		public <T> T[] toArray(T[] a) {return null;}
	};
	//NavigableSet接口----返回一?????暂时不考虑
	NavigableSet<String> navigableSet = new NavigableSet<String>() {
		public Comparator<? super String> comparator() {return null;}
		public String first() {return null;}
		public String last() {return null;}
		public int size() {return 0;}
		public boolean isEmpty() {return false;}
		public boolean contains(Object o) {return false;}
		public Object[] toArray() {return null;}
		public <T> T[] toArray(T[] a) {return null;}
		public boolean add(String e) {return false;}
		public boolean remove(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}
		public boolean addAll(Collection<? extends String> c) {return false;}
		public boolean retainAll(Collection<?> c) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		public void clear() {}
		//》=， 《= ，》，《 所给元素的第一个元素
		public String lower(String e) {return null;}
		public String floor(String e) {return null;}
		public String ceiling(String e) {return null;}
		public String higher(String e) {return null;}
		//移除第一个或者最后一个并返回
		public String pollFirst() {return null;}
		public String pollLast() {return null;}
		//
		public Iterator<String> iterator() {return null;}
		public NavigableSet<String> descendingSet() {return null;}
		public Iterator<String> descendingIterator() {return null;}//返回一个相反的迭代器
		//区间选取函数
		public NavigableSet<String> subSet(String fromElement, boolean fromInclusive, String toElement,
				boolean toInclusive) {return null;}
		public NavigableSet<String> headSet(String toElement, boolean inclusive) {return null;}
		public NavigableSet<String> tailSet(String fromElement, boolean inclusive) {return null;}
		
		public SortedSet<String> subSet(String fromElement, String toElement) {return null;}
		public SortedSet<String> headSet(String toElement) {return null;}
		public SortedSet<String> tailSet(String fromElement) {return null;}
		
	};
	//queue--队列
	//Q
	Queue<String> queue = new Queue<String>() {
		//向队列中添加对象
		public boolean add(String e) {return false;}
		//返回队列的头部元素单数不进行移除元素
		public String element() {return null;}
		//将集合添加到队列之中过
		public boolean offer(String e) {return false;}
		//返回队列头部元素不移除元素
		public String peek() {return null;}
		//返回队列头部元素移除元素
		public String poll() {return null;}
		//移除头部元素不返回 元素
		public String remove() {return null;}
		//-----collection接口
		public boolean addAll(Collection<? extends String> c) {return false;}
		//清除集合中的所元素
		public void clear() {}
		//检查 o 是否是集合中的元素
		public boolean contains(Object o) {return false;}
		public boolean containsAll(Collection<?> c) {return false;}
		public boolean isEmpty() {return false;}
		//返回一个迭代器
		public Iterator<String> iterator() {return null;}
		//移除一个元素
		public boolean remove(Object o) {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		//移除集合中除了c集合之外的其他元素
		public boolean retainAll(Collection<?> c) {return false;}
		//返回集合中的元素的数量
		public int size() {return 0;}
		//将集合变成array数组
		public Object[] toArray() {return null;}
		//返回一个数组  如果集合中的数量超出 a的长度 就分配一个新的数组 否则将数组 存入 a中并且 返回null
		public <T> T[] toArray(T[] a) {return null;}	
	};
	//Deque 接口   双向队列  
	//d e k
	Deque<String> deque= new Deque<String>() {
		public boolean add(String e) {return false;}
		public void addFirst(String e) {}
		public void addLast(String e) {}
		//返回类中受否含有这个参数
		public boolean contains(Object o) {return false;}
		public Iterator<String> descendingIterator() {return null;}
		public String element() {return null;}
		public String getFirst() {return null;}
		public String getLast() {return null;}
		public Iterator<String> iterator() {return null;}
		//添加对象
		public boolean offer(String e) {return false;}
		public boolean offerFirst(String e) {return false;}
		public boolean offerLast(String e) {return false;}
		//返回第一个但是不进行移除变量
		public String peek() {return null;}
		public String peekFirst() {return null;}
		public String peekLast() {return null;}
		//返回并且进行移除
		public String poll() {return null;}
		public String pollFirst() {return null;}
		public String pollLast() {return null;}
		public String pop() {return null;}
		public void push(String e) {}
		public String remove() {return null;}
		public boolean remove(Object o) {return false;}
		public String removeFirst() {return null;}
		//移除双向队列中的第一次出现的元素如果成功就返回 true否则返回false
		public boolean removeFirstOccurrence(Object o) {return false;}
		public String removeLast() {return null;}
		//移除双向队列中的最后一次出现的元素如果成功就返回 true否则返回false
		public boolean removeLastOccurrence(Object o) {return false;}
		public int size() {return 0;}
		//
		public boolean addAll(Collection<? extends String> c) {return false;}
		//清除集合中的所元素
		public void clear() {}
		//检查 o 是否是集合中的元素
		public boolean containsAll(Collection<?> c) {return false;}
		public boolean isEmpty() {return false;}
		public boolean removeAll(Collection<?> c) {return false;}
		//移除集合中除了c集合之外的其他元素
		public boolean retainAll(Collection<?> c) {return false;}
		//将集合变成array数组
		public Object[] toArray() {return null;}
		//返回一个数组  如果集合中的数量超出 a的长度 就分配一个新的数组 否则将数组 存入 a中并且 返回null
		public <T> T[] toArray(T[] a) {return null;}	
	};
	//对应有三个抽象类abstractCollection AvstractList abstractqueue abstractSqquentiaList-扩展了前面的list由于顺序访问而不是随机访问
	//map 映射接口
	public void method4(){
		Map<String, String> map=new Map<String, String>(){
			//移除中所有的键值对
			public void clear() {}
			public String compute(String key,BiFunction<? super String, ? super String, ? extends String> remappingFunction) {return Map.super.compute(key, remappingFunction);}
			public String computeIfAbsent(String key, Function<? super String, ? extends String> mappingFunction) {return Map.super.computeIfAbsent(key, mappingFunction);}
			public String computeIfPresent(String key,BiFunction<? super String, ? super String, ? extends String> remappingFunction) {return Map.super.computeIfPresent(key, remappingFunction);}
			//确认是否存在
			public boolean containsKey(Object key) {return false;}
			public boolean containsValue(Object value) {return false;}
			//返回所有条目的set对象
			public Set<Entry<String, String>> entrySet() {return null;}
			//jdk8对应每一个元素都会执行一个foreach语句如果在执行中移除了元素会抛出 异常
			public void forEach(BiConsumer<? super String, ? super String> action) {Map.super.forEach(action);}
			//返回与k相关联的值
			public String get(Object key) {return null;}
			//返回向相关量的值如果为空 就返回默认值 
			public String getOrDefault(Object key, String defaultValue) {return Map.super.getOrDefault(key, defaultValue);}
			//清空环境
			public boolean isEmpty() {return false;}
			//返回由按键构成的set对象
			public Set<String> keySet() {return null;}
			//????
			public String merge(String key, String value,BiFunction<? super String, ? super String, ? extends String> remappingFunction) {return Map.super.merge(key, value, remappingFunction);}
			public String put(String key, String value) {return null;}
			public void putAll(Map<? extends String, ? extends String> m) {}
			// 如果加入的集合没有在原来的映射中  就加入  这个映射并且返回原来的值 
			public String putIfAbsent(String key, String value) {return Map.super.putIfAbsent(key, value);}
			public boolean remove(Object key, Object value) {return Map.super.remove(key, value);}
			public String remove(Object key) {return null;}
			//键值对替换方法
			//查找指定的键值对是否存在然后在进行替换
			public boolean replace(String key, String oldValue, String newValue) {return Map.super.replace(key, oldValue, newValue);}
			//相当于先确认key是否存在 然后在动态的添加 value
			public String replace(String key, String value) {return Map.super.replace(key, value);}
			public void replaceAll(BiFunction<? super String, ? super String, ? extends String> function) {Map.super.replaceAll(function);}
			//返回映射中的键值对的数量
			public int size() {return 0;}
			public Collection<String> values() {return null;}
			
		};
		SortedMap<String,String > sortedMap = new SortedMap<String, String>() {
			//设置和返回  sortedMap 所用拥有的 比较器
			public Comparator<? super String> comparator() {return null;}
			//返回所有目录的条目
			public Set<Entry<String, String>> entrySet() {return null;}
			//返回集合中的第一个建
			public String firstKey() {return null;}
			//返回键值小于 arg 的所有的map对象形成的集合
			public SortedMap<String, String> headMap(String arg0) {return null;}
			public Set<String> keySet() {return null;}
			public String lastKey() {return null;}
			//返回一个区间的rag0<=xxx<arg1
			public SortedMap<String, String> subMap(String arg0, String arg1) {return null;}
			//返回区间  arg0 <=
			public SortedMap<String, String> tailMap(String arg0) {return null;}
			public Collection<String> values() {return null;}
			//扩展了map接口
			public void clear() {}
			public boolean containsKey(Object arg0) {return false;}
			public boolean containsValue(Object arg0) {return false;}
			public String get(Object arg0) {return null;}
			public boolean isEmpty() {return false;}
			public String put(String arg0, String arg1) {return null;}
			public void putAll(Map<? extends String, ? extends String> arg0) {}
			public String remove(Object arg0) {return null;}
			public int size() {return 0;}
		};
		//sortMap
		NavigableMap<String, String> navigableMap=new NavigableMap<String, String>() {
			public Comparator<? super String> comparator() {return null;}
			//返回第一个元素
			public String firstKey() {return null;}
			public String lastKey() {return null;}
			public Set<String> keySet() {return null;}
			public Collection<String> values() {return null;}
			public Set<Entry<String, String>> entrySet() {return null;}
			public int size() {return 0;}
			public boolean isEmpty() {return false;}
			public boolean containsKey(Object key) {return false;}
			public boolean containsValue(Object value) {return false;}
			public String get(Object key) {return null;}
			public String put(String key, String value) {return null;}
			public String remove(Object key) {return null;}
			public void putAll(Map<? extends String, ? extends String> m) {}
			public void clear() {}
			public Entry<String, String> lowerEntry(String key) {return null;}
			//
			public String lowerKey(String key) {return null;}
			public Entry<String, String> floorEntry(String key) {return null;}
			public String floorKey(String key) {return null;}
			public Entry<String, String> ceilingEntry(String key) {return null;}
			public String ceilingKey(String key) {return null;}
			public Entry<String, String> higherEntry(String key) {return null;}
			public String higherKey(String key) {return null;}
			public Entry<String, String> firstEntry() {return null;}
			public Entry<String, String> lastEntry() {return null;}
			public Entry<String, String> pollFirstEntry() {return null;}
			public Entry<String, String> pollLastEntry() {return null;}
			public NavigableMap<String, String> descendingMap() {return null;}
			public NavigableSet<String> navigableKeySet() {return null;}
			public NavigableSet<String> descendingKeySet() {return null;}
			public NavigableMap<String, String> subMap(String fromKey, boolean fromInclusive, String toKey,
					boolean toInclusive) {return null;}
			public NavigableMap<String, String> headMap(String toKey, boolean inclusive) {return null;}
			public NavigableMap<String, String> tailMap(String fromKey, boolean inclusive) {return null;}
			public SortedMap<String, String> subMap(String fromKey, String toKey) {return null;}
			public SortedMap<String, String> headMap(String toKey) {return null;}
			public SortedMap<String, String> tailMap(String fromKey) {return null;}
		};
		//使用map的时候所能提供的相关的了个元素的数组
		Map.Entry<String, String> mEntry = new Entry<String, String>() {
			public String setValue(String value) {return null;}
			public String getValue() {return null;}
			public String getKey() {return null;}
		};
	}
	
	
}