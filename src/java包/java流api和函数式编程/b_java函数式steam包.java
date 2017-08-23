package java包.java流api和函数式编程;

import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class b_java函数式steam包 {
	public void methodone(){
		
	}
}
class MYBaseStream<T,S extends BaseStream<T, S>> implements BaseStream<T,S>{
	//T -流的类型元素
	//S实现 BaseStream -类型的流
	public Iterator<T> iterator() {return null;}//返回一个元素迭代流
	public Spliterator<T> spliterator() {return null;}//返回一个可并行的元素迭代流
	public boolean isParallel() {return false;}//返回这个流是否正在执行并行
	public S sequential() {return null;}//返回一个等价的连续流
	public S parallel() {return null;}//返回一个 并行流
	public S unordered() {return null;}
	public S onClose(Runnable closeHandler) {return null;}
	public void close() {}//关闭流
}
//Basestream<Double,DoubleStream> 的专业化
class MydoubleStream implements DoubleStream{
	public boolean isParallel() {return false;}//是否支持并行
	public DoubleStream unordered() {return null;}
	public DoubleStream onClose(Runnable closeHandler) {return null;}
	public void close() {}
	static{
		DoubleStream.of(1,2,3,4);//生成一个流
		DoubleStream.empty();//返回一个空的流
		DoubleStream.concat(null, null);//将两个流合并成一个新的流
		//无限流
		DoubleStream.iterate(0, null);//传入一个方法  一个参数返回一个值
		DoubleStream.generate(null);//不传入参数返回一个值
	}
	//过滤器-true将会包含在新流中  使用流时候的过滤器 里面的方法有一个返回boolean类型的方法使用函数式编程方法
	public DoubleStream filter(DoublePredicate predicate) {return null;}
	//转换器-将当前的值进行转换转换成需要的值--
	public DoubleStream map(DoubleUnaryOperator mapper) {return null;}
	//转换器- 上面的升级版 --讲元素转换成其他类型的流
	public <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper) {return null;}
	//转换器 -- 转换成int类型
	public IntStream mapToInt(DoubleToIntFunction mapper) {return null;}
	//转换器 --- 转换成long 类型
	public LongStream mapToLong(DoubleToLongFunction mapper) {return null;}
	//迭代器  --- 接收一个参数将一个新的流返回会原来的流中
	public DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {return null;}
	//去重操作 --- 使用 compare进行去重
	public DoubleStream distinct() {return null;}
	//排序操作 使用compare 进行排序操作
	public DoubleStream sorted() {return null;}
	//窥视方法---对流中的元素进行相关的窥视---是同步的线程安全
	public DoubleStream peek(DoubleConsumer action) {return null;}
	//从流中从开始规定长度的流
	public DoubleStream limit(long maxSize) {return null;}
	//从流中跳过指定的流的长度
	public DoubleStream skip(long n) {return null;}
	//迭代方法--- 流中的元素依次的传入 forEach中的 方法里 --并不会保证顺序处理--为了牺牲性能
	public void forEach(DoubleConsumer action) {}
	//迭代方法---- 同上当时保证是并行顺序执行的元素
	public void forEachOrdered(DoubleConsumer action) {}
	//将流变成一个数组进行返回
	public double[] toArray() {return null;}
	// 汇聚函数 ---  不可变汇聚 函数  sum(),max()和count()。注意：sum方法不是所有的Stream对象都有的，只有IntStream、LongStream和DoubleStream是实例才有。
	//归纳函数 --- 函数传入的数据第一个参数是不停进行迭代的元素第二个参数是这个这个时候的返回值
	//左边的第一个参数是初始值    后面的每次进行迭代的时候使用的方法集合
	public double reduce(double identity, DoubleBinaryOperator op) {return 0;}
	//默认将第一个值作为初始值的元素
	public OptionalDouble reduce(DoubleBinaryOperator op) {return null;}
	// 汇聚函数可变汇聚 函数----  使用 collector
	//public <R, A> R collect(Collector<? super T, A, R> collector){
	//	return null;
	//};
	public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
		//例子
	    //List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
	    //collect(() -> new ArrayList<Integer>(),//生成一个新的  list
	    //(list, item) -> list.add(item),//向第一个生成的list中添加相关的数据
	    //(list1, list2) -> list1.addAll(list2));//在并发的时候使用,指明并发的时候分解的两个线程将进行怎样的合并
		return null;}
	//流集合操作方法
	public double sum() {return 0;}
	public OptionalDouble min() {return null;}
	public OptionalDouble max() {return null;}
	public long count() {return 0;}
	public OptionalDouble average() {return null;}
	//
	public DoubleSummaryStatistics summaryStatistics() {return null;}
	//流状态判断
	//存在一个满足
	public boolean anyMatch(DoublePredicate predicate) {return false;}
	//所有的都满足
	public boolean allMatch(DoublePredicate predicate) {return false;}
	//没有满足
	public boolean noneMatch(DoublePredicate predicate) {return false;}
	//从流中返回第一个
	public OptionalDouble findFirst() {return null;}
	//从流中随机返回一个
	public OptionalDouble findAny() {return null;}
	//将这个Double流封转成 Stream<Double>流
	public Stream<Double> boxed() {return null;}
	//将 这个流进行赋值
	public DoubleStream sequential() {return null;}
	public DoubleStream parallel() {return null;}
	public OfDouble iterator() {return null;}
	public java.util.Spliterator.OfDouble spliterator() {return null;}
}
class Mycollectors{
	public void method(){
	
	}
}
class MyCollector<T, A, R> implements Collector<T, A, R>{
	//T——输入元素来减少操作的类型
	//A——可变的积累减少操作的类型(通常是作为一个实现细节隐藏)
	//R——减少操作的结果类型
	public Supplier<A> supplier() {return null;}//一个函数,折叠一个值到一个可变结果容器。
	public BiConsumer<A, T> accumulator() {return null;}//
	public BinaryOperator<A> combiner() {return null;}
	public Function<A, R> finisher() {return null;}//执行最终的转换从中间积累类型 A R最终结果类型。
	public Set<java.util.stream.Collector.Characteristics> characteristics() {return null;}//返回一个 Set Collector.Characteristics表明特征的收集器。
	//static <T,A,R> Collector<T,A,R>	of(Supplier<A> supplier, BiConsumer<A,T> accumulator, BinaryOperator<A> combiner, Function<A,R> finisher, Collector.Characteristics... characteristics)
	//返回一个新的 Collector supplier,所描述的 accumulator combiner, finisher函数。
	//   characteristics 表明这个集合使用的集合类型
	//CONCURRENT
	//表明该收集器并发,这意味着结果容器可以支持同时蓄电池函数被调用相同的结果从多个线程的容器。
	//IDENTITY_FINISH
	//表明,修整器函数恒等函数,可以省略。
	//UNORDERED
	//表明集合操作不承诺保护遇到的顺序输入元素。
}