package c_java设计模式.g_Builder.抽象类声明组件;

//声明组件-进行相关的组件生成声明
public abstract class Builder {
	public abstract void makeTitile(String title);
	public abstract void makeString(String str);
	public abstract void makeItem(String[] items);
	public abstract void close();
	public abstract String getResult();
}
