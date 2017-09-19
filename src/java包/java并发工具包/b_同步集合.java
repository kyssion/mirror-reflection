package java包.java并发工具包;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import com.mysql.jdbc.TimeUtil;

public class b_同步集合 {
	
}
class Myclasses{
	public void method() throws InterruptedException{
		//阻塞队列  满足行就进行操作不行就阻塞的队列-
		//阻塞数组----是数组而不是list -- 获得更好的性能--有界
		ArrayBlockingQueue<String> arrayBlockingQueue =
				new ArrayBlockingQueue<>(100,true);//true 是否使用公平锁
		//只有使用这两个方法才能实现阻塞--可以指定超时时间
		arrayBlockingQueue.take();
		arrayBlockingQueue.put("");
		arrayBlockingQueue.offer("");
		arrayBlockingQueue.poll();
		//阻塞链表-----同上只是数组的链表形式---有界
		LinkedBlockingQueue<String> linkedBlockingQueue=
				new LinkedBlockingQueue<>();
		//de ke
		LinkedBlockingDeque<String> linkedBlockingDeque =
				new LinkedBlockingDeque<>();
		//优先级排序队列----阻塞模式 --- 无界
		//pai o rui ti
		PriorityBlockingQueue<String> priorityBlockingQueue=
				new PriorityBlockingQueue<>(100, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return 0;
					}
				});
		//延迟有限队列- 有排序的功能排序的方法是取决于内容的compareto元素  - 队列中的元素在指定的延迟之后才能进行返回  --  注意其中的元素必须实现Delay接口
		DelayQueue<De> delayQueue = new DelayQueue<>(); 
		//转发队列  任何一个put操作必须在take操作之后才能进行----取了数据才能再增加--用于转发
		SynchronousQueue<String> synchronousQueue=
				new SynchronousQueue<>();
		synchronousQueue.take();//取出数据
		//变种转发队列不用获取的人直接进行获取，只要获取的人想要获那么添加的人就不用先加入队列然后在给出而是直接给他--注意这是新特性只用在使用transfer类的方法的时候才有用
		LinkedTransferQueue<String> linkedTransferQueue=
				new LinkedTransferQueue<>();
		linkedTransferQueue.transfer("");//给他等待
		linkedTransferQueue.tryTransfer("");//给他但是不进行等待 -成功返回true 否则false
		linkedTransferQueue.tryTransfer("", 100000,TimeUnit.HOURS);//等待指定的时间
		//首先所有的集合对象使用 这个方法都能编程线程同步的对象
		Collections.synchronizedMap(new HashMap<>());
		//并发map  实现方法  分布加锁 segment 和hashentry
		ConcurrentHashMap<String, String> concurrentHashMap=
				 new ConcurrentHashMap<>();
		//并发双向队列
		ConcurrentLinkedDeque<String> concurrentLinkedDeque=
				new ConcurrentLinkedDeque<>();
		//并发队列
		ConcurrentLinkedQueue<String> concurrentLinkedQueue=
				new ConcurrentLinkedQueue<>();
		//实现sortmap接口类似treemap
		ConcurrentSkipListMap<String, String> treemap=new ConcurrentSkipListMap<>();
		//并发treeset
		ConcurrentSkipListSet<String> treeset= new ConcurrentSkipListSet<>();
		//CopyOnWriteArrayList来做容器。这个类和ArrayList最大的区别就是add(E) 的时候。容器会自动copy一份出来然后再尾部add(E)。
		//解决以便进行数组修改一边进行遍历itertol的时候报错
		CopyOnWriteArrayList<String> copyOnWriteArrayList=
				new CopyOnWriteArrayList<>();
		// 读锁  这个方法其实是但当使用put方法的时候将原来的数组进行一次copy put结束后将引用变成新数组---解决put+get的脏读 问题
		CopyOnWriteArraySet<String> copyOnWriteArraySet=
				new CopyOnWriteArraySet<>();
	}
}
class De implements Delayed{

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
