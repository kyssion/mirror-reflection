package b_面向对象;
//java中继承只能继承个也就是说 一个只能有一个父类 但是接口却可以有多个接口
public interface d_interface{ 
	//注意这个方法可以不进行书写---java自动认为这个方法是static final方法
	static final int myint=123;  //接口中不能有普通数据成员，只能够有静态的不能被修改的数据成员,static表示全局，final表示不可修改，可以不用static final 修饰，会隐式的声明为static和final
	public void method1();  //接口中的方法一定是抽象方法，所以不用abstract修饰 并且关键字只能是 public
	public void method2();  //接口中不能赋予方法的默认行为，即不能有方法的具体实现
	//接口中和已有静态的实现方法
	public static  void  method3(){
		
	}
	
	//java8 的新特性在接口中使用默认的方法
	default public void m(){
		
	}
}