package java包.a_util.a_array.集合;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class c_迭代器 {
	public void method(){
		// yi t rui te
		Iterator<String> iterator = new Iterator<String>() {
			//对于集合中每个未处理的元素执行action指定的动作
			public void forEachRemaining(Consumer<? super String> action) {Iterator.super.forEachRemaining(action);}
			public boolean hasNext() {return false;}
			public String next() {return null;}
			//移除当前元素  如果在执行next()方法之前使用会抛出异常
			public void remove() {Iterator.super.remove();}
		};
		//所有的list对象都实现了这个方法
		ListIterator<String> listIterator = new ListIterator<String>() {
			//在当前元素的后面返回这个元素
			public void add(String e) {}
			//后面是否有元素
			public boolean hasNext() {return false;}
			//逆向遍历链表的时候前面是否存在元素
			public boolean hasPrevious() {return false;}
			public String next() {return null;}
			//返回下一个元素的索引
			public int nextIndex() {return 0;}
			//返回前一个元素
			public String previous() {return null;}
			//返回钱一个元素的索引
			public int previousIndex() {return 0;}
			public void remove() {}
			//讲值付给当前元素
			public void set(String e) {}
		};
		//Spliterator -- jdk8新增迭代器  用于并行迭代  和新概念流
		Spliterator<String> spliterator= new Spliterator<String>(){
			//返回 该实例的特征编码
			public int characteristics() {return 0;}
			//估计剩余的元素数 如果估计不到 返回 Long.MAX_VALUE
			public long estimateSize() {return 0;}
			//讲action引用的数据源中未处理的每一个元素--java8 函数式接口
			public void forEachRemaining(Consumer<? super String> action) {Spliterator.super.forEachRemaining(action);}
			//返回 此使用的比较器
			public Comparator<? super String> getComparator() {return Spliterator.super.getComparator();}
			//若果调用的视频里特然投入是sized就返回剩余元素 否则返回 false
			public long getExactSizeIfKnown() {return Spliterator.super.getExactSizeIfKnown();}
			//如果 int 类型传递了 特征值就返回true
			public boolean hasCharacteristics(int characteristics) {return Spliterator.super.hasCharacteristics(characteristics);}
			//在迭代器上执行 action 如果有下一个元素就返回 true
			public boolean tryAdvance(Consumer<? super String> action) {return false;}
			//如果可以就返回分割调用的spliteratpr 返回对分割后的视频里特然投入引用    源 spliterator 会执行迭代程序的一部分 返回的会执行另一部分
			public Spliterator<String> trySplit() {return null;}
		};
	}
}