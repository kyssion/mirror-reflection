package c_java设计模式.b_adapter模式;

import c_java设计模式.b_adapter模式.适配器增强体.BannerPrint;
import c_java设计模式.b_adapter模式.适配器接口.Print;

public class mymain {
	public static void main(String[] args) {
		Print print = new BannerPrint("这个是使用增强体实现的方法");
		print.printWeak();
		print.printStrong();
	}
}
//重点要深入的理解adapet适配其的关键使用方法
