package java包.c_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.time.Year;
import java.util.Enumeration;

//实现文件拷贝  实现两个输入输出流---
//----read 方法使用的时候需要注意  byte[] 可能会读得多了---以后再考虑
public class b_输入输出字节流 {
	// 输入流 java输入输出流是阻塞机制的 当没有数据输入的时候将会一只坚挺端口知道指定的输入流有数据才能进行相应只有读到末尾才能返回-1
	public void methedForInputSteam() throws IOException {
		// 1. inputSteam ---
		InputStream inputStream = new InputStream() {
			// 返回当前可读取的输入字节
			public int available() throws IOException {
				return super.available();
			}

			// 关闭字节流
			public void close() throws IOException {
				super.close();
			}

			// 输入流在当前的为止放入标记这个标记在读入 readlimit 个字节的时候都有效
			public synchronized void mark(int readlimit) {
				super.mark(readlimit);
			}

			// 如果流支持 mark或者reset 就返回true
			public boolean markSupported() {
				return super.markSupported();
			}

			// 读入一个字节 如果没有要读的数据的时候将会返回 -1;
			public int read(byte[] b, int off, int len) throws IOException {
				return super.read(b, off, len);
			}

			public int read(byte[] b) throws IOException {
				return super.read(b);
			}

			// 将输入的指针重置位当前的标记
			public synchronized void reset() throws IOException {
				super.reset();
			}

			// 忽略 n个字节 返回实际输入的个数
			public long skip(long n) throws IOException {
				return super.skip(n);
			}

			// 读入下一个字节 并返回他的整数形式 如果没有需要读的就返回-1
			public int read() throws IOException {
				return 0;
			}
		};
		FileInputStream fileInputStream = new FileInputStream(new File(""));
		// 2.fileInputSteam 继承了 inputsteam 使用文件作为源 但是没有实现 mark--reset; 传入文件目录 或者file类
		// 3.ByteArrayInputSteam 使用字节数组作为源 实现了 mark--reset 实现了mark 和 reset方法 默认的reset
		// 方法默认指针是 reset
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] { 1 }, 0, 10);// byte 数组 起始为止
																										// 读入的字节数目
		// 5. 创建文件缓冲流 将文件输入进行缓冲 本质上是一种对输入流的风封装升级 减少io次数提升性能 其他方法和之前无差别
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("xx.txt"), 2134);// 最后一个参数便是缓冲区大小
		// 6.PushbackInputStream 实现数据流偷窥回滚的方法 本质上是一种对输入流的风封装升级 多了一些方法
		PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("hehe"), 2334);// 定义的和buffer
																												// 类似
		int b = 12;
		try {
			// 注意当缓冲区满了的时候竟会抛出异常
			pushbackInputStream.unread(b);// 向输入流中回退 b 的低字节
			pushbackInputStream.unread(new byte[] { 1, 2 });// 向输入流中回退 一个字节数组
			pushbackInputStream.unread(new byte[] { 1 }, 2, 3);// 想输入流中回退 自己数组从2开始的3位
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 7.SequencelnputSteam 允许使用多种 输入流载入 重写集合属性
		SequenceInputStream sequenceInputStream = new SequenceInputStream(new Enumeration<InputStream>() {
			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				// 表示集合是否还有数据
				return false;
			}

			@Override
			public InputStream nextElement() {
				// TODO Auto-generated method stub
				// 返回一个集合输入流
				return null;
			}
		});
		// 8.DataInputSteam ---实现了DataInput 接口 扩展了 FilerInputSteam 扩展了 InputSteam
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("hhe"));
		try {
			dataInputStream.readInt();// --扩展方法 扩展读取固定数据的类型--从流中读取一个相关整形的字节
			// 这个方法有配套的方法入readbyte等
			dataInputStream.readLine();// 读取一行
			dataInputStream.readUTF();// 与机器无关将一个utf的字符读入
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 7.FilterInputStream 装了所有的inputsteam 方法不能用
		// 8.ObjectInputstream 对象流 读取一个对象 对象必须继承一个序列化接口 其实扩充了随机流
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("xxx.xx"));
		try {
			objectInputStream.readObject();// 从中读出一个序列化对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 输出流
	public void methodOut() throws FileNotFoundException, IOException {
		// 1.outputSteam
		OutputStream outputStream = new OutputStream() {
			// 关闭输入流
			public void close() throws IOException {
				super.close();
			}

			// 刷新输入流--强行将数据刷新 从而让输入流不用等待缓冲区满了再进行读取---PipedInputStream和PipedOutputStream例子见下
			public void flush() throws IOException {
				super.flush();
			}

			// 向文件中写数据
			public void write(int b) throws IOException {
			}

			public void write(byte[] b, int off, int len) throws IOException {
				super.write(b, off, len);
			}

			public void write(byte[] b) throws IOException {
				super.write(b);
			}
		};
		// 2.FileOutPutsteam 实现接口方法 大体类似向文件中写数据
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("sd.xxx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.ByteArrayOutputStream
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1234);// 创建一个byte输入流 并定义缓冲区大小
		byteArrayOutputStream.reset();// 清空缓冲区
		byteArrayOutputStream.write(12);// 写入整形的低八位
		byteArrayOutputStream.write(new byte[] { 1, 2, 3 }, 0, 2);// 写入整形数组
		try {
			// 将缓冲区的内容写入 文件中
			byteArrayOutputStream.writeTo(new FileOutputStream("xxx.xxx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.bufferOutputstream 通过减少实际写数据的次数提高性能 有flush 和 write 方法
		try {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("xx.xx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5.dataoutputsteam
		DataOutputStream dataOutputStream;
		try {
			dataOutputStream = new DataOutputStream(new FileOutputStream("xxx.xxx"));
			dataOutputStream.writeInt(12);// --扩展的方法 写入输入流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 6.objectOutputStream
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("xxx.xxx"));
		objectOutputStream.writeObject(null);// 向流中写入一个 object
	}

	// 随机输入流
	public void method() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("xx.xx", "rw");// 第一个传参数可是是file 类型或者 绝对路径 第二个属性是读写要求
		randomAccessFile.close();// 关闭文件
		randomAccessFile.length();// 获取文件长度
		randomAccessFile.read();// ---基本方法 可以read所有的类型
		byte[] bs = new byte[23];
		randomAccessFile.readFully(bs);// 读取讲一个数组填满的数据
		randomAccessFile.readLine();// 读取一行
		randomAccessFile.write(12);// 写同read 几乎可写入所有的基本类
		randomAccessFile.seek(123);// 定位读写位置
		randomAccessFile.setLength(10);// 设置文件长度
		randomAccessFile.skipBytes(10);// 跳过几个字节

	}
}

class MySocket {
	public static void main(String[] args) throws IOException {
		PipedOutputStream outputStream = new PipedOutputStream();
		PipedInputStream inputStream = new PipedInputStream();
		outputStream.connect(inputStream);
		Mythread one = new Mythread(inputStream);
		Mythread2 two = new Mythread2(outputStream);
		one.start();
		two.start();
	}
}

class Mythread extends Thread {
	PipedInputStream inputStream;

	public Mythread(PipedInputStream pipedInputStream) {
		// TODO Auto-generated constructor stub
		this.inputStream = pipedInputStream;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		byte[] bs = new byte[10000];
		try {
			while (inputStream.read(bs) != -1) {
				String string = new String(bs);
				System.out.println(string);
			}
			// while(true) {
			// System.out.println("true");
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Mythread2 extends Thread {
	PipedOutputStream outputStream;

	public Mythread2(PipedOutputStream outputStream) {
		// TODO Auto-generated constructor stub
		this.outputStream = outputStream;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int a = 0;
		while (true) {
			try {
				outputStream.write(("" + a).getBytes());
				outputStream.flush();
				sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}