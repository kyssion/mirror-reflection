package c_java设计模式.f_prototype模式;

import c_java设计模式.f_prototype模式.a_接口.Product;
import c_java设计模式.f_prototype模式.b_调用复制的类.Manager;
import c_java设计模式.f_prototype模式.c_实现接口的类.MessageBox;

public class mymain {
	public static void main(String[] args) {
		Product product = new MessageBox('*');
		Product product2=new MessageBox('#');
		Manager manager = new Manager();
		manager.register("one", product);
		manager.register("two", product2);
		Product product3 =manager.create("one");
		Product product4 = manager.create("two");
		product.use("hehe");
		product3.use("hehe");
		product2.use("hehe");
		product4.use("hehe");
	}
}
//特点在Manager上和使用clone方法上
