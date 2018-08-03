package c_java设计模式.c_TemplateMethod;

import c_java设计模式.c_TemplateMethod.a_底层抽象类.AbstarctDisplay;
import c_java设计模式.c_TemplateMethod.b_抽象类实现类.CharDisplay;
import c_java设计模式.c_TemplateMethod.b_抽象类实现类.StringDisplay;

public class mymain {
	public static void main(String[] args) {
		AbstarctDisplay abstarctDisplay =new CharDisplay('A');
		AbstarctDisplay abstarctDisplay2= new StringDisplay("this is my display");
		abstarctDisplay.display();
		abstarctDisplay2.display();
	}
}
//关键点在模板方法的final 方法display
