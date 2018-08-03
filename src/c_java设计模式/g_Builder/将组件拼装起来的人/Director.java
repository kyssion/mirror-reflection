package c_java设计模式.g_Builder.将组件拼装起来的人;

import c_java设计模式.g_Builder.抽象类声明组件.Builder;
//拼装者指定组件按照指定的顺兴执行相关的操作
public class Director {
	private Builder builder=null;//传入需要的组件
	public Director(Builder builder){
		this.builder=builder;
	}
	public void construct(){
		builder.makeTitile("this is title");
		builder.makeItem(new String[]{
				"item one","item two"
		});
		builder.makeString("this is string");
		builder.makeItem(new String[]{
				"item three","item four"
		});
		builder.close();
	}
}
