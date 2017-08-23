package java包.java流api和函数式编程;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.regex.Pattern;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class c_stream流 {
	// 1.简介
	public void method1() {
		// steam流使用内部迭代方法-普通方法使用的大致都是外部迭代方法
		// 外部迭代通常意味着顺序代码。顺序代码只能由一个线程执行。
		// 流被设计为并行处理元素。
		// 以下代码并行计算列表中奇整数的平方和。
		// 中间业务终端业务
		// 流支持两种类型的操作:
		// 中间操作
		// 终端操作
		// 中间操作也称为惰性操作。
		// 终端操作也称为急切操作。
		// 惰性操作不处理元素，直到在流上调用热切操作。
		// 流上的中间操作产生另一流。
		// Streams链接操作以创建流管道。
		// 在下面的代码中filter()和map()都是惰性操作。 而reduce()是急切的操作。
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.parallelStream().filter(n -> n % 2 == 1).map(n -> n * n).reduce(0, Integer::sum);
		System.out.println(sum);
	}
	//2.简介2
	public void method2(){
		//1.
		//所有流接口从继承自AutoCloseable接口的BaseStream接口继承。--BaseStream 见下面
		//如果流基于可关闭的数据源（例如文件I/O通道），那么我们可以使用try-with-resources语句创建流，以使其自动关闭。
		//2.
		//Stream<T> 接口表示元素类型T的流。
		//流<Student> 表示学生对象流。
		//Stream <T>接口包含诸如filter()，map()，reduce()，collect()，max()，min()等。
		//当使用原始类型时，我们可以使用三个专门的流接口，称为IntStream，LongStream和DoubleStream。
		//这些接口提供了处理原始值的方法。
		//对于其他基本类型，例如float，short，byte，我们仍然可以使用三个专用流接口。
	}
	class MYBaseStream<T,S extends BaseStream<T, S>> implements BaseStream<T,S>{
		//T -流的类型元素
		//S实现 BaseStream -类型的流
		public Iterator<T> iterator() {return null;}//返回一个元素迭代流
		public Spliterator<T> spliterator() {return null;}//返回一个可并行的元素迭代流
		public boolean isParallel() {return false;}//返回这个流是否正在执行并行
		public S sequential() {return null;}//返回一个等价的连续流
		public S parallel() {return null;}//返回一个 并行流
		public S unordered() {return null;}//返回无序流如果流已经是无序的就返回自身
		public S onClose(Runnable closeHandler) {return null;}
		public void close() {}//关闭流
	}
	class MyStream<T> implements Stream<T>{
//		static {
//			Stream.of(1,2,3,4);//生成一个流
//			Stream.empty();//返回一个空的流
//			Stream.concat(null, null);//将两个流合并成一个新的流
//			//无限流
//			Stream.iterate(0, null);//传入一个方法  一个参数返回一个值
//			Stream.generate(null);//不传入参数返回一个值
//		}
		//结果集状态转换方法
		public Iterator<T> iterator() {return null;}//
		public Spliterator<T> spliterator() {return null;}
		public boolean isParallel() {return false;}
		public Stream<T> sequential() {return null;}
		public Stream<T> parallel() {return null;}
		public Stream<T> unordered() {return null;}
		public Stream<T> onClose(Runnable closeHandler) {return null;}
		public void close() {}
		//
		public Stream<T> filter(Predicate<? super T> predicate) {return null;}
		public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {return null;}
		public IntStream mapToInt(ToIntFunction<? super T> mapper) {return null;}
		public LongStream mapToLong(ToLongFunction<? super T> mapper) {return null;}
		public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {return null;}
		public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {return null;}
		public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {return null;}
		public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {return null;}
		public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {return null;}
		public Stream<T> distinct() {return null;}
		public Stream<T> sorted() {return null;}
		public Stream<T> sorted(Comparator<? super T> comparator) {return null;}
		public Stream<T> peek(Consumer<? super T> action) {return null;}
		public Stream<T> limit(long maxSize) {return null;}
		public Stream<T> skip(long n) {return null;}
		public void forEach(Consumer<? super T> action) {}
		public void forEachOrdered(Consumer<? super T> action) {}
		public Object[] toArray() {return null;}
		public <A> A[] toArray(IntFunction<A[]> generator) {return null;}
		public T reduce(T identity, BinaryOperator<T> accumulator) {return null;}
		public Optional<T> reduce(BinaryOperator<T> accumulator) {return null;}
		public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {return null;}
		public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {return null;}
		public <R, A> R collect(Collector<? super T, A, R> collector) {return null;}
		public Optional<T> min(Comparator<? super T> comparator) {return null;}
		public Optional<T> max(Comparator<? super T> comparator) {return null;}
		public long count() {return 0;}
		public boolean anyMatch(Predicate<? super T> predicate) {return false;}
		public boolean allMatch(Predicate<? super T> predicate) {return false;}
		public boolean noneMatch(Predicate<? super T> predicate) {return false;}
		public Optional<T> findFirst() {return null;}
		public Optional<T> findAny() {return null;}
		
	}
	//3.java 可选操作---优雅的控制流操作
	public  void  method3(){
		 Optional<String> empty  = Optional.empty();
		 System.out.println(empty);
		 Optional<String> str = Optional.of("www.w3cschool.cn");
		 System.out.println(str);
		 String nullableString = ""; 
		 Optional<String> str2  = Optional.of(nullableString);
		 System.out.println(str2);
	}
	//4.流的创建方法
	public void method4(){
		//1.使用Stream接口的()从单个值和多个值创建顺序流。
		Stream<String> stream = Stream.of("13","2222");
		//2.使用 Stream.Builder<T> 创建流。---builder 类的使用方法
		Stream<String> stream2  = Stream.<String>builder().add("XML").add("Java") .add("CSS").build();
		//3.IntStream范围--LongStream
		IntStream oneToFive  = IntStream.range(1, 6);//生成1-5的数字流
		//IntStream oneToFive  = IntStream.rangeClosed(1, 5);
		oneToFive.forEach(System.out::println);
		//4.使用empty()静态方法从Stream接口以创建空的顺序流。
		 Stream<String> stream3  = Stream.empty();
	}
	//5.函数流使用函数生成所需要的流
	public void method5(){
		//两种静态方法从Stream接口从函数生成无限流。iterate()方法创建顺序有序流。generate()方法创建一个顺序无序流。
		//IntStream，LongStream和DoubleStream包含iterate()和generate()方法，它们采用特定于其原始类型的参数生成值。
		//!!!---可以使用java8 特有的脚本化方法这个方法---只要传入符合指定形式的相关其他类的方法就行了---注意了此时这个方法将会可以共享类中的变参数的
		Stream<Integer> stream=Stream.iterate(10, x->x+1);//IntUnaryOperator 有参方法---迭代通过前一个参数进行迭代出来的方法
		Stream<Integer> stream3=Stream.generate(()->123);//IntSupplier 方法  无参方法--- 使用数据生成函数
		//---使用随即流
		new Random().ints().limit(5).forEach(System.out::println);
		///java.util.Random类提供ints()，longs()和doubles()分别返回无限IntStream，LongStream和DoubleStream。以下代码从从Random类的ints()方法返回的IntStream中打印了五个随机int值:
		 IntStream.generate(new Random()::nextInt).limit(5)
		    		.forEach(System.out::println);//随即流可以作为相关流的生成方法参数
	
		 //--------使用随即流的时候可能会使用的相关方法-----------------
		 Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1) .limit(10);//保留前十个值
		 Stream.iterate(2L, n  ->  n  + 1).skip(100).forEach(System.out::println);//跳过前100个值
	}
	//6.集合流---从数组和集合创建流
	public void method6(){
		//1.从数组中间型创建流  java.util.Arrays类包含用于从数组创建顺序流的stream（）方法。
		Stream<String> stream = Arrays.stream(new String[]{"safd","sdfsdf"});
		//2.从集合中获取流--Collection接口包含stream()和parallelStream()方法，它们分别从Collection创建顺序流和并行流。
		 Set<String> names = new HashSet<>(); 
		 names.add("XML");
		 names.add("Java");
		 Stream<String> sequentialStream  = names.stream();//获得一个顺序流
		 sequentialStream.forEach(System.out::println);
		 Stream<String> parallelStream = names.parallelStream();//获得一个并行流
		 parallelStream.forEach(System.out::println);
	}
	//7.从字符串中获得流
	public void method7(){
		//1.字符串转字符流
		//CharSequence接口的chars()返回一个IntStream，它的元素是表示字符的int值。
		//我们可以在String，StringBuilder和StringBuffer上使用chars()方法。
		//以下代码从字符串创建字符流，过滤掉所有数字和空格，然后打印剩余的字符：
		 String str = "5 123,123,qwe,1,123, 25";
		 str.chars()
		 		.filter(n ->  !Character.isDigit((char)n) &&   !Character.isWhitespace((char)n))//过滤掉所有的数字和空格
		    			.forEach(n ->  System.out.print((char)n));
		 //2.Regex流
		 String str2 = "XML,CSS,HTML"; 
		 Pattern.compile(",")
		    	.splitAsStream(str)//  正则分割成字符流
		    		.forEach(System.out::println);
	}
	//8.文件流
	public void method8(){
		//来自Java 8的java.io和java.nio.file包添加了许多方法来支持使用流的I/O操作。
		//我们可以从文件中读取文本作为字符串流。流中的每个元素表示一行文本。
		//我们还可以使用流从JarFile读取JarEntry，我们可以读取目录中的条目作为Path流。
		//----------------------自动关闭
		//调用stream上的close()方法将关闭底层文件。
		//或者，我们可以在try-with-resources语句中创建流，以便自动关闭底层文件。
		//----nio 方面的东西
		 Path path = Paths.get("./Main.java");
		 try (Stream<String> lines = Files.lines(path)) {
		      lines.forEach(System.out::println);
		 } catch (IOException e) {
		      e.printStackTrace();
		 }
	}
	//9.....流操作
	public void method9(){
		//1.流 Peek---窥视方法
		//我们可以使用Stream <T>接口的窥探（Consumer<？super T>action）方法调试流。
		//IntStream，LongStream和DoubleStream还包含一个peek()方法，它接受IntConsumer，LongConsumer和DoubleConsumer作为参数。
		//我们可以使用带有peek()方法的lambda表达式来记录元素。
		//peek()----用在流中-取出的数据对流没有影响只是讲数据复制出来
		int sum = Stream.of(1, 2, 3, 4, 5)
		        .peek(e -> System.out.println("Taking integer: " + e))
		        .filter(n -> n % 2 == 1)
		        .peek(e -> System.out.println("Filtered integer: " + e))//对流中的元素进行相关的窥视
		        .map(n -> n * n).peek(e -> System.out.println("Mapped integer: " + e))
		        .reduce(0, Integer::sum);
		System.out.println("Sum = " + sum);
		//2.流 ForEach--- 对流中的元素进行迭代的从而输出相关数据进行相关的操作
		//-----   需要一个迭代函数 方法中只有一个参数参数为本次流进行迭代使用的数据
		//forEach()方法不保证操作的顺序应用流中的每个元素。
		//forEachOrdered()方法按元素的顺序执行操作由流定义。此方法可能会减慢并行流中的处理速度。
		Stream.of(1,2,3,4,5,6).forEach(e->System.out.println(e));
	}
	//10.流过滤器----
	public void method10(){
		//filter是一个接受元素并返回布尔值的函数。--true 将会将数据加入到流中
		Stream.of(1,2,3,4,5).filter(x->x>10);
	}
	//11.流映射器
	public void method11(){
		//1.map----接收一个元素将这个元素进行转化成另一个元素
		//映射操作对每个元素应用函数以产生另一流。
		//输入和输出流中的元素数量是相同的。
		//该操作不修改输入流的元素。
		//您可以使用Stream <T>接口的以下方法之一对流应用地图操作：
		//<R> Stream<R> map(Function<? super T,? extends R> mapper)
		//DoubleStream  mapToDouble(ToDoubleFunction<? super T> mapper)
		//IntStream     mapToInt(ToIntFunction<? super T> mapper)
		//LongStream    mapToLong(ToLongFunction<? super T> mapper)
		Stream.of(1,2,3,4,5).map(x->x+1);
		//2.流flatMap --- 一对多进行映射 接收一个数据返回一个流java讲新的流加入到这个流中
		//Streams map()操作创建一个一对一映射。
		//streams flatMap()支持一对多映射。 它将每个元素映射到流，然后将流的流平面化为流。
		//下面的代码映射了三个数字的流：1,2和3，以产生包含数字及其下一个数字的流。 输出流应为1,2,2,3,3,4。
		Stream.of(1,2,3,4,5).flatMap(x->Stream.of(1,2,3,4));
		 Stream.of("XML", "Java",  "CSS")
	        .map(name  ->  name.chars())
	        .flatMap(intStream ->  intStream.mapToObj(n ->  (char)n))
	        .forEach(System.out::println); 
		//代码将字符串映射到String类的chars()方法的IntStream返回。
		//map()方法的输出是 Stream< IntStream> 。
		 //flatMap()方法将Stream<IntStream> 映射到Stream <Stream>字符>>，最后，将其平坦化以生成
	}
}
