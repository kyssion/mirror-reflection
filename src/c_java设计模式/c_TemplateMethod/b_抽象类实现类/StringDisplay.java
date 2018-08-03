package c_java设计模式.c_TemplateMethod.b_抽象类实现类;

import c_java设计模式.c_TemplateMethod.a_底层抽象类.AbstarctDisplay;

public class StringDisplay extends AbstarctDisplay{
	private String string;
	public StringDisplay(String string) {
		// TODO Auto-generated constructor stub
		this.string=string;
	}
	private void printLine(){
		System.out.print("+");
		for (int i=0;i<string.length();i++){
			System.out.print("-");
		}
		System.out.println("+");
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for (int i=0;i<5;i++){
			System.out.println("|"+this.string+"|");
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		printLine();
	}
	
}
