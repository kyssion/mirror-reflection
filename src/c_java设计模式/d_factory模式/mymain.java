package c_java设计模式.d_factory模式;

import c_java设计模式.d_factory模式.抽象工厂和抽象实例.Factory;
import c_java设计模式.d_factory模式.接口实现类.IDCard;
import c_java设计模式.d_factory模式.接口实现类.IDCardFactory;

public class mymain {
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		IDCard idCard = (IDCard)factory.create("小王");
		idCard.use();
	}
}
//重点思想在使用工厂方法动态生成相关的实例---不用在类中进行new对象了
