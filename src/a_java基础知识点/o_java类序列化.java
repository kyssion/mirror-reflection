package a_java基础知识点;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class o_java类序列化 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		XUliehua xUliehua = new XUliehua();
		xUliehua.arrayList.add(new xulie2("1"));//可以
		xUliehua.arrayList.add(new xulie2("2"));
		//自动完成深层复制
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("d://heheh.text")));
		objectOutputStream.writeObject(xUliehua);
		objectOutputStream.close();
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("d://heheh.text")));
		xUliehua = (XUliehua) objectInputStream.readObject();
		for (xulie2 string : xUliehua.arrayList){
			System.out.println(string.ssss);
		}
	}
}
class XUliehua implements Serializable{
	public ArrayList<xulie2> arrayList = new  ArrayList<>();
	String  heheh = "sdf";
	public void say(){
		System.out.println(heheh);
	}
}
class xulie2 implements Serializable{
	String ssss="ttttt";
	public xulie2(String  sss) {
		// TODO Auto-generated constructor stub
		ssss=sss;
	}
}