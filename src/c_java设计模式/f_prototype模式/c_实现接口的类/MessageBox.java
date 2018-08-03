package c_java设计模式.f_prototype模式.c_实现接口的类;

import c_java设计模式.f_prototype模式.a_接口.Product;

public class MessageBox implements Product{
	private char decochar;
	public MessageBox(char ch) {
		// TODO Auto-generated constructor stub
		this.decochar=ch;
	}
	@Override
	public void use(String s){
		int length=s.getBytes().length;
		for (int i=0;i<length+4;i++){
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar+" "+s+" "+decochar);
		for (int i=0;i<length+4;i++){
			System.out.print(decochar);
		}
		System.out.println("");;
	}
	@Override
	public Product createClone() {
		Product product=null;
		try {
			product=(Product) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}
