package c_java设计模式.e_Singleton模式;

public class Singleton {
	private static Singleton singleton= new Singleton();
	private Singleton(){}
	public static Singleton getsingleton(){
		return singleton;
	}
}
