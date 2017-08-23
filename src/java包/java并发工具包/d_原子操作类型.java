package java包.java并发工具包;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class d_原子操作类型 {
	public void method(){
		//1.基本类型 int bool long
		AtomicInteger atomicInteger = new AtomicInteger(12);
		atomicInteger.get();
		atomicInteger.set(123);
		atomicInteger.addAndGet(123);//输入新的值和和旧值相加并返回和
		atomicInteger.compareAndSet(0, 2);//
		atomicInteger.getAndIncrement();//原子自增加
		atomicInteger.lazySet(123);//延迟赋值
		atomicInteger.getAndSet(333);//设置新值返回旧值
		//2.数组
		AtomicIntegerArray array= new AtomicIntegerArray(10);
		array.addAndGet(0, 123);
		array.getAndSet(0, 2);
		array.compareAndSet(0, 1, 120);
		//3.引用类型更新
		AtomicReference<String> atomicReference=new AtomicReference<String>("sdf");
		atomicReference.getAndSet("ddd");
	}
}
