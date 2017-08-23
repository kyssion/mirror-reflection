package c_java设计模式.g_Builder;

import c_java设计模式.g_Builder.将组件拼装起来的人.Director;
import c_java设计模式.g_Builder.抽象类声明组件.Builder;
import c_java设计模式.g_Builder.组建类的实现.MyStringBuilder;

public class Mymain {
	public static void main(String[] args) {
		Builder builder = new MyStringBuilder();
		Director director = new Director(builder);
		director.construct();
		System.out.println(builder.getResult());
	}
}
