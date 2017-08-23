package b_面向对象;
import java.io.Serializable;
//java 内存模型
//java 内存分配  栈区存放局部变量  堆区 不连续空间用来放入new出的对象 
//方法区  放入类代码信息 static变量 常量
//注意在java 的内存模型之中所有的 的引用类型都相当于一真
//对java 而言一个类中的方法 常量 静态类型只有一份 所有的类进行通用
//java 的string类型其实是常量  相同的字符串分配的内存地址是相同的
public class a_base implements Serializable{//这个接口标志类会进行序列化序列化
	//Java会对成员变量进行初始化定义
	int a;
	String name;
	//方法
	public void hah(){}
	public a_base(){
		//当函数被new 的时候类将进行的选择性的调用
		//构造函数注意问题
		//1.又返回值但是不能在函数中使用return
		//2.没有声明构造函数的时候将会自动的调用一个无参的构造函数
		//如果声明了将会不进行无参构造函数的声明--无参函数无效了--不会自动的生成
		//名字和类名字相同
	}
}
//当使用对象时 先通过内部的 class 咯爱的人加载类随后进行类的 