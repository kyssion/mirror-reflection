package java包.a_util.a_array.集合;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class d_比较器 {
	public void method(){
		Comparator<String> comparator = new Comparator<String>() {
			//自定以排序规则使用的排序器 让o1<o2返回小于零 大于返回大于零 等同于返回等于零
			public int compare(String o1, String o2) {return 0;}
			//自定以  equal 比较的方法
			public boolean equals(Object obj) {return super.equals(obj);}
			//放回此比较器的颠倒形式
			public Comparator<String> reversed() {return Comparator.super.reversed();}
			//jdk新增后续比较器 -- 再议
			public Comparator<String> thenComparing(Comparator<? super String> other) {
				return Comparator.super.thenComparing(other);}
			public <U> Comparator<String> thenComparing(Function<? super String, ? extends U> keyExtractor,
					Comparator<? super U> keyComparator) {
				return Comparator.super.thenComparing(keyExtractor, keyComparator);}
			public <U extends Comparable<? super U>> Comparator<String> thenComparing(
					Function<? super String, ? extends U> keyExtractor) {
				return Comparator.super.thenComparing(keyExtractor);}
			public Comparator<String> thenComparingDouble(ToDoubleFunction<? super String> keyExtractor) {
				return Comparator.super.thenComparingDouble(keyExtractor);}
			public Comparator<String> thenComparingInt(ToIntFunction<? super String> keyExtractor) {
				return Comparator.super.thenComparingInt(keyExtractor);}
			public Comparator<String> thenComparingLong(ToLongFunction<? super String> keyExtractor) {
				return Comparator.super.thenComparingLong(keyExtractor);}
		};
	}
}