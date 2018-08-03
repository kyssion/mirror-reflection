package java包.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.Field;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class a_顶层接口 {
	//ServerSocketChannel-SocketChannel
	public void method() throws IOException{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//开启一个ServerSocketChannel
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));//绑定监听的端口
		serverSocketChannel.configureBlocking(false);//使用非自塞模式
		while(true){
		    SocketChannel socketChannel =
		            serverSocketChannel.accept();//使用了非阻塞模式
		    //do something with socketChannel...
		    break;
		}
		SocketChannel socketChannel = SocketChannel.open();//代开socketChannel
		//当制定为非阻塞模式的时候就可以进行异步的操作了
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));//指定发送的ip和端口
		ByteBuffer buf = ByteBuffer.allocate(48);//声明缓存的大小
		int bytesRead = socketChannel.read(buf);//香气中读取数据
		String newData = "New String to write to file..." + System.currentTimeMillis();
		buf.clear();//清空数据
		buf.put(newData.getBytes());//写入数据指正移动
		buf.flip();//转换模式-----指明指针的位置
		while(buf.hasRemaining()) {
			socketChannel.write(buf);
		}
		socketChannel.close();
		
		//DatagramChannel--UDP协议
		DatagramChannel channel = DatagramChannel.open();//打开一个DatagramChannel
		channel.socket().bind(new InetSocketAddress(9999));//绑定相关的端口
		ByteBuffer buf2 = ByteBuffer.allocate(48);
		buf.clear();
		channel.receive(buf);//DatagramChannel专有方法receive()方法会将接收到的数据包内容复制到指定的Buffer. 如果Buffer容不下收到的数据，多出的数据将被丢弃。
		String newData2 = "New String to write to file..." + System.currentTimeMillis();
		buf2 = ByteBuffer.allocate(48);
		buf2.clear();
		buf2.put(newData.getBytes());
		buf2.flip();
		int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));//发送数据 指定到特定的网址无状态连接
		//使用PIP实现两个线程之间channel的管道通信
		Pipe pipe = Pipe.open();
		Pipe.SinkChannel sinkChannel = pipe.sink();//打开写管道
		String newData3 = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf3 = ByteBuffer.allocate(48);
		buf3.clear();
		buf3.put(newData.getBytes());
		buf3.flip();
		while(buf.hasRemaining()) {
			sinkChannel.write(buf);//相关道中写入数据--之所以使用死循环是因为有的时候数据可可能在一定的时候没有完全性诶入道相关的数据中
		}
		Pipe.SourceChannel sourceChannel = pipe.source();
		ByteBuffer buf4 = ByteBuffer.allocate(48);
		int bytesRead5 = sourceChannel.read(buf);//读数据
	}
	//4.path 接口和files类 --替代原来的file类
	public void four() throws IOException{
		Path path= new Path() {
			//讲path属性转化成URi地址
			public URI toUri() {return null;}
			public Path toRealPath(LinkOption... options) throws IOException {return null;}
			//讲nio转化成一般的io输入操作
			public File toFile() {return null;}
			//转化成绝对定位
			public Path toAbsolutePath() {return null;}
			public Path subpath(int beginIndex, int endIndex) {return null;}
			
			public boolean startsWith(String other) {return false;}
			public boolean startsWith(Path other) {return false;}
			public boolean endsWith(String other) {return false;}
			public boolean endsWith(Path other) {return false;}
			
			public Path resolveSibling(String other) {return null;}
			public Path resolveSibling(Path other) {return null;}
			//为相对路径加上other中指定的绝对路径
			public Path resolve(String other) {return null;}
			public Path resolve(Path other) {return null;}
			
			public Path relativize(Path other) {return null;}
			public WatchKey register(WatchService watcher, Kind<?>[] events, Modifier... modifiers) throws IOException {return null;}
			public WatchKey register(WatchService watcher, Kind<?>... events) throws IOException {return null;}
			public Path normalize() {return null;}
			public Iterator<Path> iterator() {return null;}
			public boolean isAbsolute() {return false;}
			
			public Path getRoot() {return null;}
			public Path getParent() {return null;}
			public int getNameCount() {return 0;}
			public Path getName(int index) {return null;}
			public FileSystem getFileSystem() {return null;}
			public Path getFileName() {return null;}
			public int compareTo(Path other) {return 0;}
		};
		
		
		
		OutputStream outputStream = new FileOutputStream("");
		//files 类 定义一个文件的属性
		Files.copy(path,outputStream);//指定文件拷贝方法
		Files.createDirectory(path, new FileAttribute<String>() {

			@Override
			public String name() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String value() {
				// TODO Auto-generated method stub
				return null;
			}
		});//??不懂创建文件目录
		//Files.createFile(path, attrs)创建文件同上
		Files.delete(path);//删除文件
		Files.exists(path, null);//文件是否存在
		//files相关属性判断类---有许多 is 比如判断是否是一个文件或者判断是否是一个目录等等
		Files.isDirectory(path, null);
		//files 放法的newxxxxx方法将会返回一些输入流 或者缓冲区暂不讨论
		//StandardOpenOption.APPEND;//---这个枚举用来为nio的读取输入流定义新的方法
		
	}
	
}