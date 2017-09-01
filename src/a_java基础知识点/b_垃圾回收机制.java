package a_java基础知识点;

public class b_垃圾回收机制 {
	@SuppressWarnings("unused")
	public static void main(String[] arg){
		//对象回收机制的触发方法
		//1.
		String name="123";
		name=null;//触发空置的效果 java gc垃圾回收机制将会自动的回收空值的java 对象
		//2.
		System.gc();//使用函数 手动的触发垃圾回收系统
		//finalize(); 子对象内部进行声明
		//需要显示地调用垃圾回收方法(System.gc())，并且需要有new出来的尚未被销毁的匿名
		//对象的存在（调用其它语言暂不作考虑），finalizze()方法才会被调用
		//虽然这个请求机制提供给程序员一个启动 GC 过程的机会，但是启动由 JVM负责。JVM可以拒绝这个请求，所以并不保证这些调用都将执行垃圾回收。启动时机的选择由JVM决定，并且取决于堆内存中Eden区是否可用。JVM将这个选择留给了Java规范的实现，不同实现具体使用的算法不尽相同。
	}
}
/*
 * 
 * 引用分为
 * 强引用 -- gc 垃圾回收机制不进行回收 
 * 软引用-- 内存不够的时候进行回收
 * 弱引用-- 立即回收
 * 虚引用-- 用于跟踪对象的回收状态
 *
 */
//java 从1.7开始启动自动关闭资源的方法
class Myautoclose implements AutoCloseable{
	//继承这个借口并且在使用的过程使用try-catch 语句将会自动的调用close方法进行资源的关闭
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}






