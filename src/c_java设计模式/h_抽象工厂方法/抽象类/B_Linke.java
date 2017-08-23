package c_java设计模式.h_抽象工厂方法.抽象类;
//实现抽象类的第一个接口
public abstract class B_Linke extends A_Item {
	protected String url=null;
	public B_Linke(String caption,String url) {
		super(caption);
		// TODO Auto-generated constructor stub
		this.url=url;
	}
}
