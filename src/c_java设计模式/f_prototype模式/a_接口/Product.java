package c_java设计模式.f_prototype模式.a_接口;

public interface Product extends Cloneable{
	public abstract void use(String s);
	public abstract Product createClone();
}
