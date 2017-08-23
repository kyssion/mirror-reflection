package java包.java流api和函数式编程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class a_函数式 {
	public static void main(String[] args) {
		
	}
}
class ceshi{
	public void ceshi(){
		//声明形成流
		 //数组
	    String[] strArr = new String[]{"aa","bb","cc"};
	    Stream<String> streamArr = Stream.of(strArr);
	    Stream<String> streamArr2 = Arrays.stream(strArr);
	    //集合
	    List<String> list = new ArrayList<>();
	    Stream<String> streamList = list.stream();
	    Stream<String> streamList2 = list.parallelStream();//并行执行

	    //generator 生成无限长度的stream
	    Stream.generate(Math::random);
	    // iterate 也是生成无限长度的Stream，其元素的生成是重复对给定的种子值调用函数来生成的
	    Stream.iterate(1, item -> item + 1);
		//流的惰性操作
	    /*
	    Stream的使用分为两种类型：

	    Intermediate,一个Stream可以调用0到多个Intermediate类型操作，每次调用会对Stream做一定的处理，返回一个新的Stream，这类操作都是惰性化的（lazy），就是说，并没有真正开始流的遍历。 
	    常用操作：map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel

	    Terminal,一个Stream只能执行一次terminal 操作，而且只能是最后一个操作，执行terminal操作之后，Stream就被消费掉了，并且产生一个结果。 
	    常用操作：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny
		*/
	    /********** Intermediate **********/
	  //filter 过滤操作
	  streamArr.filter(str -> str.startsWith("a"));
	  //map 遍历和转换操作
	  streamArr.map(String::toLowerCase);
	  //flatMap 将流展开
	  List<String> list1 = new ArrayList<>();
	  list1.add("aa");list1.add("bb");
	  List<String> list2 = new ArrayList<>();
	  list2.add("cc");list2.add("dd");
	  Stream.of(list1,list2).flatMap(str -> str.stream()).collect(Collectors.toList());  
	  //limit 提取子流
	  streamArr.limit(1);
	  //skip 跳过
	  streamArr.skip(1);
	  //peek 产生相同的流，支持每个元素调用一个函数
	  streamArr.peek(str-> System.out.println("item:"+str));
	  //distinct 去重
	  Stream.of("aa","bb","aa").distinct();
	  //sorted 排序
	  Stream.of("aaa","bb","c").sorted(Comparator.comparing(String::length).reversed());
	  //parallel 转为并行流,谨慎使用
	  streamArr.parallel();
	  /********** Terminal **********/
	//forEach
	streamArr.forEach(System.out::println);
	//forEachOrdered 如果希望顺序执行并行流，请使用该方法
	streamArr.parallel().forEachOrdered(System.out::println);
	//toArray 收集到数组中
	streamArr.filter(str -> str.startsWith("a")).toArray(String[]::new);
	//reduce 聚合操作
	streamArr.reduce((str1,str2) -> str1+str2);
	//collect 收集到List中
	streamArr.collect(Collectors.toList());
	//collect 收集到Set中
	streamArr.collect(Collectors.toSet());
	//min 取最小值？
	IntStream.of(1,2,3,4).min();
	Stream.of("1","2").min(String::compareTo);
	//max 取最大值？
	IntStream.of(1,2,3,4).max();
	Stream.of("1","2").max(String::compareTo);
	//count 计算总量？
	streamArr.count();
	//anyMatch 判断流中是否含有匹配元素
	boolean hasMatch = streamArr.anyMatch(str -> str.startsWith("a"));
	//allMatch 判断流中是否全部匹配
	boolean hasMatch1 = streamArr.allMatch(str -> str.startsWith("a"));
	//noneMatch 判断流中是否全部不匹配
	boolean hasMatch11 = streamArr.noneMatch(str -> str.startsWith("a"));
	//findFirst 找到第一个就返回
	streamArr.filter(str -> str.startsWith("a")).findFirst();
	//findAny 找到任意一个就返回
	streamArr.filter(str -> str.startsWith("a")).findAny();
	}
	public void method(){
		//使用函数式编程和函数引用式编程
		B bbB= new B();
		//1.传统的函数是编程
		A a = ()->System.out.println("this is a");
		//使用函数代替上面的东西
		A bA=B::method;  //使用静态的方法
		A a2= bbB::method2;//使用静态的方法
		A a3=this::method3s;//在当前的方法上进行引用 同理可以使用super
		AA<String> aa =bbB::<String>me;//使用泛型的时候
		//构造参数 String::new  和数组参数  int[]::bew
	}
	public void method3s(){
		
	}
}
interface AA<T>{
	public void method(T t);
}
interface A{
	public void hehe();
}
class B<T>{
	public void me(T t){
		System.out.println("this is t");
	}
	public  void  method2(){
		System.out.println("Yes2");
	}
	static void method(){
		System.out.println("Yes");
	}
}



