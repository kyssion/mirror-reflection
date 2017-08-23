package c_java设计模式.e_Singleton模式;

public class mymain {
	public static void main(String[] args) {
		System.out.println("start.");
		Singleton obj1=Singleton.getsingleton();
		Singleton obj2=Singleton.getsingleton();
		if(obj1==obj2){
			System.out.println("这两个实例相同");
		}
		else{
			System.out.println("这两个实例不相同");
		}
		System.out.println("end.");
	}
}
