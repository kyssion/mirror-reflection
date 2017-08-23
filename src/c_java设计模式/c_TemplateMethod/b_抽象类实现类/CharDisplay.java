package c_java设计模式.c_TemplateMethod.b_抽象类实现类;

import c_java设计模式.c_TemplateMethod.a_底层抽象类.AbstarctDisplay;

public class CharDisplay extends AbstarctDisplay{
	private char ch;
	public CharDisplay(char ch) {
		// TODO Auto-generated constructor stub
		this.ch=ch;
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.print("<<");
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(this.ch);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println(">>");
	}

}
