package c_java设计模式.h_抽象工厂方法.抽象类;
//最底层的抽象类
public abstract class A_Item {
	protected String caption=null;
	public A_Item(String caption) {
		// TODO Auto-generated constructor stub
		this.caption=caption;
	}
	public abstract String makeHTML();
}
