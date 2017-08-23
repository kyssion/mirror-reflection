package c_java设计模式.b_adapter模式.适配器增强体;

import c_java设计模式.b_adapter模式.本体.Banner;
import c_java设计模式.b_adapter模式.适配器接口.Print;


//在适配器接口中调用要被适配的元素的方法
//这个方法是关键使用这个方法具体的实现了和相关的接口结合 （利用继承和实现相关的接口）
public class BannerPrint extends Banner implements Print{

	public BannerPrint(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		System.out.println("使用增强体1");
		super.showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		System.out.println("使用增强体2");
		super.showWithAster();
	}
	
}
