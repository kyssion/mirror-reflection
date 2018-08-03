package c_java设计模式.c_TemplateMethod.a_底层抽象类;

public abstract class AbstarctDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	//模版方法---就是让所有继承了这个方法都存在一个实现-----核心
	public final void display(){
		open();
		for (int i=0;i<5;i++){
			print();
		}
		close();
	}
}
