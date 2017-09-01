package a_java基础知识点;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



public class e_多线程进阶 {
	public void method() throws IOException {
		// 关于输入流的问题----输入的数据极可能的一次性输入完 ---继承自 inputsteam outputsteam
		//pai pu te  拷贝输入流
		PipedInputStream pipedInputStream = new PipedInputStream();// 字符管道流
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		pipedInputStream.connect(pipedOutputStream);// 将两个通道进行关联（反过来写也对）
		PipedReader pipedReader = new PipedReader();
		pipedInputStream.read();// 当没有数据的时候将会进行等待操作
		PipedWriter pipedWriter = new PipedWriter();
		pipedOutputStream.write("asdfasdf".getBytes());// 同上
		//ke nai ke te
		pipedReader.connect(pipedWriter);// 将两个通道进行关联（反过来写也对）
		// 管道流实现不同进程之间的通信可以不使用 类似 临时文件的东西
		// ThreadLoacl--线程独立(解决数据的隔离性) ？？？？使用static 此变量的时候
		// 每一个线程拥有一个独立的值--即使是继承的线程 也不会进行同步
		
		ThreadLocal<String> sLocal = new ThreadLocal<>();// 定义自定义变量
		sLocal.set("ssss");// 设置值
		sLocal.get();// 获得值
		sLocal.remove();// 移除值
		//ThreadLocal.set()来实现的，而是通过每个线程中的new 对象 的操作来创建的对象，每个线程创建一个，不是什么对象的拷贝或副本。
		//通过ThreadLocal.set()将这个新创建的对象的引用保存到各线程的自己的一个map中，每个线程都有这样一个map，
		//执行ThreadLocal.get()时，各线程从自己的map中取出放进去的对象，因此取出来的是各自自己线程中的对象，ThreadLocal实例是作为map的key来使用的。 
		// 线程独立 -- 可以让子线程继承父线程的值 方法同上 如果父线程的值发生修改子线程的值将不会发生改变子线程也是如此
		//in h e rui te bo
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		// 重入同步锁 --- 类似 synchronized 但是功能更加强大
		// --实现的原理让程序向下执行当制定的lock做出一些判断是否继续向下执行
		// 解决不同对象不同线程互锁
		
		//瑞恩蠢他
		ReentrantLock lock = new ReentrantLock();// 相当于 synchronized(xxx)
													// 中声明的xxx
		ReentrantLock lock2 = new ReentrantLock(true);// 生成公平锁
														// 满足先来先获得资源的原则--其他的和一般的没有差别
		lock.lock();// 相当于同步代码块中的 {
		lock.unlock();// 相当于同步代码快中的}
		
		//lock锁并不支持锁重入但是 同一个线程多次获得这个锁并不会导致阻塞
		
		// 下边这个方法和wait notify相同 必须在同步代码快中才能使用
		//砍滴神
		Condition condition = lock.newCondition();// 从 lock中获得condition 从而实现
													// wait notify方法 见下面
		try {
			condition.await();// 类似于于 wait() 注意一定要放在
								// lock画出的代码块中否则将会出现问题---让当前的线程以condition进行上锁
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//s ying g nal
		condition.signal();// 类似于于 notify-----解锁一个以condition进行上锁的线程
		condition.signalAll();// 类似于于notifyall----解锁所有以condition上锁的线程
		lock.getHoldCount();// 使用了 lock的总数
		lock.getQueueLength();// 还能被 await的线程数
		lock.getWaitQueueLength(condition);// 被 conditiion await的个数
		lock.hasQueuedThread(new Thread(new Runnable() {
			public void run() {
			}
		}));// 这个线程是否在等待会的lock的执行权
		lock.hasQueuedThreads();// 是否有线程在等待获得lock的执行权
		lock.hasWaiters(condition);// 检查是否有需有正在等待的线程
		lock.isFair();// 判断是否是公平锁
		lock.isHeldByCurrentThread();// 查询当前的线程是否已经获得锁定
		lock.isLocked();// 效果貌似同上----再说
		try {
			lock.lockInterruptibly();// 相应中断的锁 如果当前线程未被中断（interruptibly）则获得锁定，如果已经被中断就抛异常
			lock.tryLock();// 线程尝试使用非阻塞的方式进行获取锁
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 上面类的进化版(加上是read锁还是write锁) 可以实现读读异步 读写 写读 写写异步
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		readWriteLock.readLock().newCondition();
		readWriteLock.readLock().lock();
		readWriteLock.writeLock().lock();
	}

	class MyThreadLocal extends ThreadLocal<String> {
		// 自定义 线程独立类的时候使用 默认初始值
		@Override
		protected String initialValue() {
			// TODO Auto-generated method stub
			Timer timer = new Timer(false);// 声明是否是守护线程
			// timer.schedule(task, delay, period);//1.使用的函数 延迟时间 延迟多长时间运行下一个
			return super.initialValue();
		}
	}
}

class Time {
	// time类的使用的方法结合TimerTask方法进行相关的结合
	public void ceshi() {
		// timerTask类继承了runnable借口，使用的时候需要实现相关的接口，供给timer进行实现

	}
}
//仿ReentrantLock对象的默认实现
class Myreented implements Lock {
	class Sync extends AbstractQueuedSynchronizer {
		private static final long serialVersionUID = 1L;

		@Override // 独占时获取同步状态
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(0, 1)) {// 使用cas设置当前的状态，此方法可以保证原子性
				setExclusiveOwnerThread(Thread.currentThread());// 设置当前拥有独占访问的线程。
				// getExclusiveOwnerThread() 返回由 setExclusiveOwnerThread 最后设置的线程；如果从未设置，则返回
				// null。
				return true;
			}
			return false;
		}

		@Override // 独占式释放同步状态，等待获取同步状态的将有机会获取同步状态
		protected boolean tryRelease(int arg) {
			if (getState() == 0) {// 获得当前的同步状态
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);// 设置当前的同步状态
			return true;
		}

		ConditionObject newCondition() {
			return new ConditionObject();// 返回一个condition 每一个condition都包含一个condition队列
		}

		@Override // 共享式获取同步状态，返回值大于零表示获取成功，反之获取失败
		protected int tryAcquireShared(int arg) {
			return super.tryAcquireShared(arg);
		}

		@Override // 共享式释放同步状态
		protected boolean tryReleaseShared(int arg) {
			return super.tryReleaseShared(arg);
		}

		@Override // 判断当前的同步器是否在独占模式下被占用
		protected boolean isHeldExclusively() {
			return super.isHeldExclusively();
		}

		@Override
		public String toString() {
			return super.toString();
		}
	}
	private Sync sync=new Sync();
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquire(1);//独占的获取锁，这个方法将会调用重写的tryacquire();方法
	}
	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return sync.tryAcquire(1);
	}
	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		sync.acquireInterruptibly(1);
	}
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}
	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		sync.release(0);
		
	}
	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return sync.newCondition();
	}
}
class MytimeTaks extends TimerTask {
	@Override
	public void run() {

	}
}

// 解决不同对象不同线程相互锁住
class oneeee {
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition conditionone = reentrantLock.newCondition();
		Condition conditionTwo = reentrantLock.newCondition();
		Thread one = new Mythreadone(reentrantLock, conditionone, "one");
		Thread two = new MythreadTwo(reentrantLock, conditionone, "two");
		one.start();
		two.start();
	}
}

class Mythreadone extends Thread {
	ReentrantLock reentrantLock = null;
	Condition condition = null;

	public Mythreadone(ReentrantLock reentrantLock, Condition condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;
	}

	@Override
	public void run() {
		reentrantLock.lock();
		for (int a = 0; a < 10000; a++) {
			condition.signalAll();
			System.out.println(a + "   " + Thread.currentThread().getName());
			try {
				condition.await();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// this.reentrantLock.unlock();
		reentrantLock.unlock();
	}
}

class MythreadTwo extends Thread {
	ReentrantLock reentrantLock = null;
	Condition condition = null;

	public MythreadTwo(ReentrantLock reentrantLock, Condition condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;
	}

	@Override
	synchronized public void run() {

		reentrantLock.lock();
		for (int a = 0; a < 10000; a++) {
			condition.signalAll();
			System.out.println(a + "   " + Thread.currentThread().getName());
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.reentrantLock.unlock();
	}
}

// 使用同步锁也能实现
class Mythreadone2 extends Thread {
	ReentrantLock reentrantLock = null;
	Condition condition = null;

	public Mythreadone2(ReentrantLock reentrantLock, Condition condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;
	}

	@Override
	public void run() {
		synchronized (reentrantLock) {

			for (int a = 0; a < 10000; a++) {
				reentrantLock.notify();
				System.out.println(a + "   " + Thread.currentThread().getName());
				try {
					reentrantLock.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// this.reentrantLock.unlock();
		}
	}
}

class MythreadTwo2 extends Thread {
	ReentrantLock reentrantLock = null;
	Condition condition = null;

	public MythreadTwo2(ReentrantLock reentrantLock, Condition condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;

	}

	@Override
	public void run() {
		synchronized (reentrantLock) {
			for (int a = 0; a < 10000; a++) {
				reentrantLock.notify();
				System.out.println(a + " " + Thread.currentThread().getName());
				try {
					reentrantLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

// 多线程控制实现--- 三线程顺序自增方法
class one {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock reentrantLock = new ReentrantLock();
		ReentrantLock reentrantLock2 = new ReentrantLock();
		ArrayList<Condition> conditionone = new ArrayList<>();
		conditionone.add(reentrantLock.newCondition());
		conditionone.add(reentrantLock.newCondition());
		conditionone.add(reentrantLock.newCondition());
		Thread one = new Mythreadone3(reentrantLock, conditionone, "one");
		Thread two = new MythreadTwo3(reentrantLock, conditionone, "two");
		Thread three = new MythreadThree(reentrantLock, conditionone, "three");
		one.start();
		two.start();
		three.start();
	}
}
class Mythreadone3 extends Thread {
	ReentrantLock reentrantLock = null;
	ArrayList<Condition> condition = null;

	public Mythreadone3(ReentrantLock reentrantLock, ArrayList<Condition> condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;
	}

	@Override
	public void run() {
		reentrantLock.lock();
		for (int a = 0; a < 10000; a++) {
			System.out.println(a + "   " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				condition.get(1).signal();
				condition.get(0).await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// this.reentrantLock.unlock();
		reentrantLock.unlock();
	}
}

class MythreadTwo3 extends Thread {
	ReentrantLock reentrantLock = null;
	ArrayList<Condition> condition = null;

	public MythreadTwo3(ReentrantLock reentrantLock, ArrayList<Condition> condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;

	}

	@Override
	public void run() {
		this.reentrantLock.lock();
		try {
			this.condition.get(1).await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < 10000; a++) {
			try {
				System.out.println(a + " " + Thread.currentThread().getName());
				this.sleep(1000);
				this.condition.get(2).signal();
				this.condition.get(1).await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.reentrantLock.unlock();
	}
}

class MythreadThree extends Thread {
	ReentrantLock reentrantLock = null;
	ArrayList<Condition> condition = null;

	public MythreadThree(ReentrantLock reentrantLock, ArrayList<Condition> condition, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.reentrantLock = reentrantLock;
		this.condition = condition;
	}

	@Override

	public void run() {
		reentrantLock.lock();
		try {
			this.condition.get(2).await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < 10000; a++) {
			System.out.println(a + "   " + Thread.currentThread().getName());
			try {
				this.sleep(1000);
				condition.get(0).signal();
				condition.get(2).await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.reentrantLock.unlock();
	}
}

//使用 pip的时候相关的数据共享流数据运输的问题
class MySocket {
	public static void main(String[] args) throws IOException {
		PipedOutputStream outputStream = new PipedOutputStream();
		PipedInputStream inputStream = new PipedInputStream();
		outputStream.connect(inputStream);
		Mythread1 one = new Mythread1(inputStream);
		Mythread2 two = new Mythread2(outputStream);
		one.start();
		two.start();
	}
}

class Mythread1 extends Thread {
	PipedInputStream inputStream;

	public Mythread1(PipedInputStream pipedInputStream) {
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
				outputStream.flush();//强制刷新 否则输入流将会在共享数组满了或者超时一秒中的时候进行读取
				sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



