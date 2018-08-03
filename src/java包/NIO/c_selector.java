package java包.NIO;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class c_selector {
	public void method() throws IOException {
		// Selector（选择器）是Java
		// NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个单独的线程可以管理多个channel，从而管理多个网络连接。
		// 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
		// 开启了一个selector通道
		Selector selector = Selector.open();// 创建一个selector通道
		SocketChannel channel = new Socket().getChannel();
		channel.configureBlocking(false);// 使用非阻塞模式
		SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);
		/*
		 * 注意register()方法的第二个参数。这是一个“interest集合”，
		 * 意思是在通过Selector监听Channel时对什么事件感兴趣。可以监听四种不同类型的事件： 1.Connect 2.Accept
		 * 3.Read 4.Write
		 * 通道触发了一个事件意思是该事件已经就绪。所以，某个channel成功连接到另一个服务器称为“连接就绪”。一个server socket
		 * channel准备好接收新进入的连接称为“接收就绪”。一个有数据可读的通道可以说是“读就绪”。等待写数据的通道可以说是“写就绪”。
		 * 
		 * 这四种事件用SelectionKey的四个常量来表示： 1.SelectionKey.OP_CONNECT
		 * 2.SelectionKey.OP_ACCEPT 3.SelectionKey.OP_READ
		 * 4.SelectionKey.OP_WRITE 如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来 int
		 * interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
		 */
		// 当向Selector注册Channel时，register()方法会返回一个SelectionKey对象。这个对象包含了一些你感兴趣的属性：
		// 1.interest集合
		// 2.ready集合
		// 3.Channel
		// 4.Selector
		// 附加的对象（可选）
		// select 集合
		// 1.
		// 就像向Selector注册通道一节中所描述的，interest集合是你所选择的感兴趣的事件集合。可以通过SelectionKey读写interest集合，像这样：
		int interestSet = selectionKey.interestOps();
		boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
		int isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
		int isInterestedInRead = interestSet & SelectionKey.OP_READ;
		int isInterestedInWrite = interestSet & SelectionKey.OP_WRITE;
		// 用“位与”操作interest 集合和给定的SelectionKey常量，可以确定某个确定的事件是否在interest 集合中。
		// 2.ready 集合是通道已经准备就绪的操作的集合。在一次选择(Selection)之后，你会首先访问这个ready set。
		int readySet = selectionKey.readyOps();
		// 可以用像检测interest集合那样的方法，来检测channel中什么事件或操作已经就绪。
		selectionKey.isAcceptable();
		selectionKey.isConnectable();
		selectionKey.isReadable();
		selectionKey.isWritable();
		// 3.
		// Channel + Selector
		// 从SelectionKey访问Channel和Selector很简单。如下：
		Channel channel1 = selectionKey.channel();
		Selector selector1 = selectionKey.selector();
		// 附加的对象
		// 可以将一个对象或者更多信息附着到SelectionKey上，这样就能方便的识别某个给定的通道。例如，可以附加
		// 与通道一起使用的Buffer，或是包含聚集数据的某个对象。使用方法如下：
		selectionKey.attach(new Integer(123));
		Object attachedObj = selectionKey.attachment();
		// 还可以在用register()方法向Selector注册Channel的时候附加对象。如：
		SelectionKey key = channel.register(selector, SelectionKey.OP_READ, new Integer(123));
		// ------通过Selector选择通道
		// 一旦向Selector注册了一或多个通道，就可以调用几个重载的select()方法。这些方法返回你所感兴趣的事件（如连接、接受、读或写）已经准备就绪的那些通道。换句话说，如果你对“读就绪”的通道感兴趣，select()方法会返回读事件已经就绪的那些通道。
		int a = selector.select();// 阻塞到至少有一个通道在你注册的事件上就绪了。int值表示有多少通道已经就绪
		int b = selector.select(1000);// select(long
										// timeout)和select()一样，除了最长会阻塞timeout毫秒(参数)。
		int c = selector.selectNow();// 不会阻塞，不管什么通道就绪都立刻返回（译者注：此方法执行非阻塞的选择操作。如果自从前一次选择操作后，没有通道变成可选择的，则此方法直接返回零。）。
		// 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，然后可以通过调用selector的selectedKeys()方法，访问“已选择键集（selected
		// key set）”中的就绪通道。
		// Selector提供选择已经就绪的任务的能力：Selector会不断轮询注册在其上的Channel，如果某个Channel上面发生读或者写事件，这个Channel就处于就绪状态，会被Selector轮询出来，然后通过SelectionKey可以获取就绪Channel的集合，进行后续的I/O操作。
		Set<SelectionKey> selectedKeys = selector.selectedKeys();
		// 当像Selector注册Channel时，Channel.register()方法会返回一个SelectionKey
		// 对象。这个对象代表了注册到该Selector的通道。可以通过SelectionKey的selectedKeySet()方法访问这些对象。
		selectedKeys = selector.selectedKeys();
		Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
		while (keyIterator.hasNext()) {
			SelectionKey key2 = keyIterator.next();
			if (key.isAcceptable()) {
				// a connection was accepted by a ServerSocketChannel.
			} else if (key.isConnectable()) {
				// a connection was established with a remote server.
			} else if (key.isReadable()) {
				// a channel is ready for reading
			} else if (key.isWritable()) {
				// a channel is ready for writing
			}
			keyIterator.remove();
		}
		// keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
		// SelectionKey.channel()方法返回的通道需要转型成你要处理的类型，如ServerSocketChannel或SocketChannel等。
		// 其他
		selector.wakeup();// 其他线程唤醒使用select阻塞的线程
		selector.close();// 关闭线程
	}
}
