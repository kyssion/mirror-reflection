package c_java设计模式.b_adapter模式.本体;

public class Banner {
	private String string;
	public Banner(String string){
		this.string =string;
	}
	public  void showWithParen(){
		System.out.println("("+this.string+")");
	}
	public void showWithAster(){
		System.out.println("*"+this.string+"*");
	}
}
