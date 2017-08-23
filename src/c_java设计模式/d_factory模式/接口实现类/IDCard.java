package c_java设计模式.d_factory模式.接口实现类;

import c_java设计模式.d_factory模式.抽象工厂和抽象实例.Product;

public class IDCard extends Product{
	private String ower;
	public IDCard(String ower) {
		// TODO Auto-generated constructor stub
		this.ower=ower;
	}
	
	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("使用"+ower+"的id卡");
	}
	public String getOwner(){
		return this.ower;
	}
	
}
