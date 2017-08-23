
package a_java基础知识点;

import java.util.ArrayList;

public class d_泛型 {//适用的时候类型无关的时候
	
}
//定义泛型类  T 代表一个引用类型   ---可以使用界表示法---
//extends扩展表示泛型只能是继承类或者子类的元素---下界  注意不能使用impletes（接口）
// super表示只有他的父类是可以接受的----上界
//	当不同的泛型拥有不同的T或者V   的时候其实是不同的类型
//  当要确认一个变量是个泛型的类或者子类的时候只能使用instanceof ThisisT<?>（这种表示形式）--引申相同的类名不同的T代表不同的类  ？代表通配符
//泛型中的<T>不同或者T不能进行相互转化 就不能及进行枪支转化

//jvm虚拟机 的实现原理是使用了先擦除属性 然后将属性 加进泛型 并且同时出现了一个object类型的方法 --为了能匹配输入  随后 进行桥接方法---
//也就是说---- 在编译成字节码的时候会存在一个相同名称的object 类但是 jvm虚拟机会自动处理
// 比如说  --object sfsf（） String sfsf（）----正常写会出错但是属性擦除不会出错
//泛型可以导致模糊性错误  当使用 T he v 的类型相同的时候  此函数两个拥有相同值的构造方法将会发生命名错误 比如说 T V 类型都是 string
//----泛型的限制  不能实例化参数  ----其实本质山就是 new 的对象不能是泛型 就是 不能 new T（）；
//----对数组的限制  不能实例化泛型数组   其次不能声明 泛型组成的数组
class ThisisT<T extends Father,V>{
	//注意泛型不能是基本类型只能是引用类型  但是java 的自定装箱机制会将基本类型变成引用类型
	//因为引用类型 不能是基本类型 意味着 声明 泛型的时候不能使用引用类型
	public ThisisT(T heh) {}
	public ThisisT(V v){}
	public ThisisT(T t,V v){
		//
		t.thisisFatherMehthod();
	}
	//? 通配符  其实和T所带表的意义是是相同的 但是 ? 通配符是为了解决   函数 内部的方法调用 泛型类的时候所采用的因为泛型类中不能使用除了已经声明的泛型之外的字母
	//其余的 T等是一样的方法
	public void method(ArrayList<?> arrayList){//这样这个方法就能接受除了T V 类型之外的其他类型
		
	}
}
class Father {
	public void thisisFatherMehthod(){}
}
interface Mother<T extends ArrayList<T>>{
	public void ThisisMatherMethod();
}
//--继承或者 实现的接口 终不能写extends等语句  具体的实现需要在新的类名称中写 官方属于叫做声明值的传递
//继承泛型类  ---
class  Ceshi<T extends ArrayList<T>> implements Mother<T>{

	@Override
	public void ThisisMatherMethod() {
		// TODO Auto-generated method stub
		
	}
	
}
//继承泛型接口
class Ceshi2<T extends Father, V> extends ThisisT<T,V>{

	public Ceshi2(T heh) {
		super(heh);
		// TODO Auto-generated constructor stub
	}
	
}
//继承泛型类外加泛型接口
class Ceshi3<M extends ArrayList<M>, V, T extends Father> extends ThisisT<T,V> implements Mother<M>{

	public Ceshi3(T heh) {
		super(heh);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ThisisMatherMethod() {
		// TODO Auto-generated method stub
		
	}
}
class BBB<T>{
	public T say() {
		return null;
	}
}
class AAA extends BBB<Integer>{//范型继承可以是已知的类型使用使用已知了型可以在前面不加上属性，但是如果前面加上属性将导致后面的类型变成未知
	@Override
	public Integer say() {
		// TODO Auto-generated method stub
		return 123;
	}
}


