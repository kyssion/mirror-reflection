package java包.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class a_buffer {
	public void bytebuffer() throws IOException {
		// buffer 是缓冲区 相关的实现类有byte 插入 都变了( float int long mapped short)+buffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);// 使用这个声明一个缓冲区
														// 数字表示缓冲区的大小(字节)
		buffer.array();// 如果缓冲区是基于数组的就返回数组的引用
		buffer.arrayOffset();// 返回该缓冲区的缓冲区的第一个元素的背衬数组中的偏移量（可选操作）。如果此缓冲区由数组支持，则缓冲区p对应于数组索引p
								// + arrayOffset（）。
		buffer.capacity();// 设置缓冲区的大小
		buffer.flip();// 反转-读写转换讲position设置为0 limit设置为刚才的position--从读模式编程写模式
						// limit编程capition position变成0
		buffer.hasArray();// 如果缓冲区读写是基于数组的就返回true
		buffer.isDirect();// 如果缓冲区是io是定向的也就是可以直接对缓冲区进行操作的就返回true
		buffer.isReadOnly();// 如果缓冲区是只读的就返回true
		buffer.limit(100);// 设置缓冲区的界限为100字节返回缓冲区的引用
		buffer.limit();// 返回缓冲区的引用
		buffer.mark();// 标记位置
		buffer.reset();// 讲position重置成mark的位置
		buffer.position();// 返回当前位置
		buffer.position(100);// 设置当前位置是100
		buffer.remaining();// 返回还可以存入数据的值
		
		buffer.rewind();// 让positon变成0 意味着可以进行重读操作
		
		buffer.clear();// 清空缓冲区 --- 不保留未读的数据
		
		buffer.compact();// 清空缓冲区--- 保留未读的数据
		buffer.hasRemaining();//缓冲区是否还有空间在position和limit之间
		buffer.equals(buffer);// 当满足下列条件时，表示两个Buffer相等：
								// 1.有相同的类型（byte、char、int等）。
								// 2.Buffer中剩余的byte、char等的个数相等。
								// 3.Buffer中所有剩余的byte、char等都相同。
		buffer.compareTo(buffer);// compareTo()方法比较两个Buffer的剩余元素(byte、char等)，
									// 如果满足下列条件，则认为一个Buffer“小于”另一个Buffer：
									// 1.第一个不相等的元素小于另一个Buffer中对应的元素 。
									// 2.所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。
		// ---相关的实现方法 会实现相应的给和put方法
		buffer.get();// 方法的重构 无参数 - 返回当前位置的字节
						// byte数组 返回byte数组的字节 --可以指定起点和终点
						// int 类型 返回指定 位置的字节
		byte b = 0;
		buffer.put(b);// 方法对缓冲区进行赋值 一个字节 在当前位置上为他赋值
						// 字节数组 - 可以传入起始位置和终止位置
						// 传入bytebuffer
						// 出入整形和byte 在指定的位置上传入
		buffer.asCharBuffer();// 讲buffer转化成相关的流
		buffer.putChar('a');// ---相同类型的虼蚤方法
		buffer.getInt();//
		
		
		//写入buffer
		Channel channel ;
		FileChannel fi = null;
		//channel 读写操作
		fi.read(buffer);
		fi.write(buffer);
	}
}
