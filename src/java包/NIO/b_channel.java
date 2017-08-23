package java包.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class b_channel {
	public void method() throws IOException, InterruptedException {
		// 通道 channel --由各种流获取的通道 DatagramSocket fileInputSstream FileOutStream
		// RndomAccessFile ServerSocket Socket
		// 当使用 Files(下面的一个类的时候)将会返回一个seekableChannel 是filechannel实现的一个接口
		// 这些是Java NIO中最重要的通道的实现：
		// FileChannel
		// DatagramChannel
		// SocketChannel
		// ServerSocketChannel
		// FileChannel 从文件中读写数据。
		// DatagramChannel 能通过UDP读写网络中的数据。
		// SocketChannel 能通过TCP读写网络中的数据。
		// ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

		FileInputStream inputStream = new FileInputStream("sdf");
		FileChannel channel = inputStream.getChannel();// 获取输入流
		channel.tryLock();//获得锁
		channel.lock();//为通道上锁
		channel.wait();
		// fileChannel.map(mode, position, size);
		channel.position();
		channel.position(1000);
		// fileChannel.open(path, options)
		// fileChannel.truncate(100);
		ByteBuffer b = ByteBuffer.allocate(100);
		channel.read(b);// 讲文件流中的字节读到 b中
		channel.write(b);// 将缓冲区的b写入到字节中
		channel.close();//关闭连接
		// Java
		// NIO开始支持scatter/gather，scatter/gather用于描述从Channel（译者注：Channel在中文经常翻译为通道）中读取或者写入到Channel的操作。
		// 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
		// 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel
		// 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
		// scatter /
		// gather经常用于需要将传输的数据分开处理的场合，例如传输一个由消息头和消息体组成的消息，你可能会将消息体和消息头分散到不同的buffer中，这样你可以方便的处理消息头和消息体。
		// 分散器是channel的新特性 其本质上是双缓冲
		ByteBuffer b2 = ByteBuffer.allocate(100);
		ByteBuffer b3 = ByteBuffer.allocate(100);
		ByteBuffer[] buffers = { b, b2, b3 };
		channel.read(buffers);// 读入多个数组
		channel.write(buffers);// 写入多个数组
		channel.truncate(1000);// 截取文件的大小身故不封将会自动的进行截取
		channel.force(true);// 将通道里尚未写入磁盘的数据强制写到磁盘上。出于性能方面的考虑，操作系统会将数据缓存在内存中，所以无法保证写入到FileChannel里的数据一定会即时写到磁盘上。要保证这一点，需要调用force()方法。force()方法有一个boolean类型的参数，指明是否同时将文件元数据（权限信息等）写到磁盘上。
		// 通道
		RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		long position = 0;
		long count = fromChannel.size();// 返回文件的大小
		toChannel.transferFrom(fromChannel, count, position);// 讲其他通道的channel中的数据传递到filechanne中
		fromChannel.transferTo(position, count, toChannel);// 讲filechannel中的数据传递到file中
		// 注意!!!!!
		// 此外要注意，在SoketChannel的实现中，SocketChannel只会传输此刻准备好的数据（可能不足count字节）。因此，SocketChannel可能不会将请求的所有数据(count个字节)全部传输到FileChannel中。

	}
}
