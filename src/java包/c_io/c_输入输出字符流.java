package java包.c_io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class c_输入输出字符流 {
	//字符输入流
	public void method1() throws FileNotFoundException{
		//1.Reader类--和inputSteam类似
		Reader reader = new Reader() {
			//防止一个输入标志
			public void mark(int readAheadLimit) throws IOException {super.mark(readAheadLimit);}
			//如果支持标记返回true
			public boolean markSupported() {return super.markSupported();}
			public int read() throws IOException {return super.read();}
			public int read(char[] cbuf) throws IOException {return super.read(cbuf);}
			public int read(CharBuffer target) throws IOException {return super.read(target);}
			//表示下一个请求是否等待
			public boolean ready() throws IOException {return super.ready();}
			//跳转到mark标记的为止
			public void reset() throws IOException {super.reset();}
			//忽略几个字节
			public long skip(long n) throws IOException {return super.skip(n);}
			public int read(char[] cbuf, int off, int len) throws IOException {return 0;}
			public void close() throws IOException {}
		};
		//2.fileReader---相当一 FileinputSteam 实现了所有reader方法
		FileReader fileReader  = new FileReader("23123.xx");
		//3.chararrayReader --读入字符  相当于在上面的 基础上添加了 toCharArray()返回数据副本 和 toString() 返回数据字符串获取数据
		CharArrayReader charArrayReader = new CharArrayReader(new char[]{'a','b'});//
		//4.BufferReader  同  输入流  解决每次读入的时候都后触发读取操作的尴尬  设置缓冲流
		BufferedReader bufferedReader = new BufferedReader(new FileReader("xxx.xx"),213);
		
		//5.pushbackReader-----类似
		
	}
	//字符输出流
	public void methed() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("sdf"),"utf-8");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(""), "utf-8");
		//1.Writer
		Writer writer = new Writer() {
			public void write(char[] cbuf, int off, int len) throws IOException {}
			//追加字符到输出流末尾
			public Writer append(char c) throws IOException {return super.append(c);}
			public Writer append(CharSequence csq, int start, int end) throws IOException {return super.append(csq, start, end);}
			public Writer append(CharSequence csq) throws IOException {return super.append(csq);}
			//想输入流中写数据
			public void write(char[] cbuf) throws IOException {super.write(cbuf);}
			public void write(int c) throws IOException {super.write(c);}
			public void write(String str, int off, int len) throws IOException {super.write(str, off, len);}
			public void write(String str) throws IOException {super.write(str);}
			//完成输出转台清空缓冲区
			public void flush() throws IOException {}
			//关闭缓冲区
			public void close() throws IOException {}
		};
		//PrintWriter printWriter = new PrintWriter();
		//2.fileReader---相当一 FileinputSteam 实现了所有reader方法
		FileWriter fileWriter  = new FileWriter("23123.xx");
		//3.chararrayWriter 和  inputbyte 类似
		//4.Bufferwrite  同  输入流  解决每次读入的时候都后触发读取操作的尴尬  设置缓冲流
		
	}
}