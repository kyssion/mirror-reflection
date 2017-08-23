package a_java基础知识点;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Set;

public class l_动态读取配置文件 {
	//实用配置文件进行相关的操作将相关的操作,可以讲相关的数据可以更加简化相关的操作形式
	public void method(){
		Properties properties= new Properties();
		
	}
	class Myproties extends Properties{
		//使用set和get方法将会从输入流中动态的读取/设置一个相关的属性
		public String getProperty(String key) {return super.getProperty(key);}
		public String getProperty(String key, String defaultValue) {return super.getProperty(key, defaultValue);}
		public synchronized Object setProperty(String key, String value) {return super.setProperty(key, value);}
		//将一个输入流是的属性使用相关的属性
		public synchronized void load(Reader reader) throws IOException {super.load(reader);}
		public synchronized void load(InputStream inStream) throws IOException {super.load(inStream);}
		//sava方法已经过时了
		public void save(OutputStream out, String comments) {super.save(out, comments);}
		//将方法保存到相关的属性中----comments 属性列表的描述--(加上注释的部分)
		public void store(Writer writer, String comments) throws IOException {super.store(writer, comments);}
		public void store(OutputStream out, String comments) throws IOException {super.store(out, comments);}
		//使用xml文件进行加载
		public synchronized void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException {super.loadFromXML(in);}
		public void storeToXML(OutputStream os, String comment) throws IOException {super.storeToXML(os, comment);}
		public void storeToXML(OutputStream os, String comment, String encoding) throws IOException {super.storeToXML(os, comment, encoding);}
		//返回参数的数组-返回健值
		public Enumeration<?> propertyNames() {return super.propertyNames();}
		//返回参数值-数组
		public Set<String> stringPropertyNames() {return super.stringPropertyNames();}
		//将属性列表输出到指定的输出流中
		public void list(PrintStream out) {super.list(out);}
		public void list(PrintWriter out) {super.list(out);}
	}
}
