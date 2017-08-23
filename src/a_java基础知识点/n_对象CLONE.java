package a_java基础知识点;

public class n_对象CLONE {
	public static void main(String[] args) {
		qianfuzhi();
	}
	static public void qianfuzhi(){
		//clone 只是潜复制 --- 引用对象只是复制了内存地址并没有进行深层复制--
		Myceshi myceshi = new Myceshi("123123");
		Myclone myclone = new Myclone();
		//myclone.myceshi = myceshi;
		//myclone.a=123;
		Myclone myclone2 = (Myclone) myclone.clone();
		System.out.println(myclone.myceshi+"  "+myclone2.myceshi);
		myclone.myceshi.name="sdf";
		System.out.println(myclone.myceshi.name+"  "+myclone2.myceshi.name);
	}
}
class Myclone implements Cloneable{
	public int a;
	public Myceshi myceshi=new Myceshi("22222");
	public Object clone(){
		Myclone myclone = null;
		try {
			myclone = (Myclone) super.clone();
			myclone.myceshi=(Myceshi) myceshi.clone();//开启深层复制
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myclone;
	}
}
class Myceshi implements Cloneable{
	public String name;
	public Myceshi(String nString) {
		// TODO Auto-generated constructor stub
		name=nString;
	}
	public void say(){
		System.out.println(name);
	}
	public Object clone(){
		Myceshi myceshi = null;
		try {
			myceshi = (Myceshi) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myceshi;
	}
}