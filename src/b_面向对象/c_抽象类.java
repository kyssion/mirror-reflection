package b_面向对象;
/*
 * 抽象类只是可以进行new对象但是要实现相关的方法 相当于匿名类而已 本质上不能进行new对象的 其他的和普通类相同
 * 由抽象方法的类只能定义成抽象类
 * 抽象类不能被实例化 能使用new 但是new出来的对象必须事项抽象方法 依旧是说抽象类如果想要实例化就需实现抽象方法
 * 抽象类只能用来继承 
 * 抽象方法子类必须继承否则 子类还是抽象类
 * 修饰标记符不能使用private
 * 
 * */
//抽象类（abstract class）的定义方式如下： 
public abstract class c_抽象类 {//至少有一個抽象方法
	public int t; // 普通数据成员
	public abstract void hehe();
	public abstract void method1(); // 抽象方法，抽象类的子类在类中必须实现抽象类中的抽象方法
	public abstract void method2();
	public void method(){// 非抽象方法
		//抽象类中可以赋予非抽象方法方法的默认行为，即方法的具体实现
	}
}


