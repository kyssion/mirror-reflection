package a_java基础知识点;

import java.util.concurrent.atomic.AtomicInteger;
//java 中线程是嵌套的
//线程状态有  创建 就绪状态 运行状态 阻塞状态 终止状态
public class e_多线程 {// 一个类的同一个方法被不同的类锁调用
	@SuppressWarnings({ "unused", "static-access", "deprecation" })
	public void method() throws InterruptedException {
		// 基础类-声明线程 1.传入 runnable方法 第二种 继承扩展 thread 并且重写 run 方法  Thread类继承实现了runnable接口
		Runnable runnable = new Runnable() {
			// 多线程的伴随借口
			public void run() {
			}
		};
		Thread thread = new Thread(runnable, "one");// 最后一个参数是线程名称
		Thread teThread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "123");// 第一个参数传入的线程名称
		thread.join(100);// 线程联合 当线程使用 join 将会暂停手上的线程转而去执行
							// join线程的方法 当join中线程的方法实现完成后将会自动执行原来主线程中的方法
							// 内部实现wait方法会释放锁
		thread.join();// 等待要加入的线程执行完再执行 ---join 内部实现wait方法 会释放锁 作用等待线程对象销毁(sleep 方法将会到之相关的县城被占用)
						//当前的线程等待thread线程
		thread.isAlive();// 判断线程是否终止 true 没有终止
		thread.run();// 线程的入口点
		thread.start();// 调用线程润方法启动 默认调用thread 中的run 方法
		thread.sleep(100);// 线程进行休眠
		thread.getPriority();// 返回线程的优先级
		thread.setPriority(8);// 设置线程的抢占优先级
		thread.getState();//获得指定线程的状态  new-创建 runnable-运行 terminated-销毁 TiMED_WAITING-（sleep等待状态) blocked-（等待锁状态） waiting-（使用wait之后的状态）
		// 使用同一个类的不同线程间的通信---同一类中的不同方法在同一个类中被调用
		// !!!!!!!!!wait 方法 必须和 synchxxx关键字一起使用否则会抛出
		// 异常java.lang.IllegalMonitorStateException
		// 精确的解释 休眠正在调用的当前线程 唤醒一个调用过这个的当前线程
		// 注意有this运算符的时候其实是对当前类进行操作作用于调用这个类的线程
		this.wait();// ---将当前类进行休眠--应当在循环中使用这个方法因为需要循环检测
		// 指的是调用这个方法的一个线程进行休眠而其他的不惊醒休眠
		this.wait(10000);// 只进行休眠1s
		this.notify();// ---唤醒当前的类被wait的一个线程(调用方法的对象不会停止)
		// 是的是当前调用对象的所有线程中 唤醒其中的一个
		this.notifyAll();// --唤醒当前的类被wait的所有线程---注意是占用的类
		thread.yield();// ---放弃当前资源让其他任务去占用cpu时间并不是结束当前的运行
		thread.interrupt();// 终止sleep--改变线程状态 wait的对象会抛出 异常----改变Thread.isTnterrupted();的状态
		Thread.interrupted();//静态方法 会制标识位为false 测试线程是否停止 --使用后将会改变状态 ---这个方法只有一个使用的方法就是使用sleep+interupted抛出异常
		thread.isInterrupted();// 测试线程是否终止使用后 不会改变标识位 讲不会改变状态-判断是否使用了interrupted
		//interrupted 是作用于当前线程，isInterrupted 是作用于调用该方法的线程对象所对应的线程。（线程对象对应的线程不一定是当前运行的线程。例如我们可以在A线程中去调用B线程对象的isInterrupted方法。）
		//当一个线程处于中断状态时，如果再由wait、sleep以及jion三个方法引起的阻塞，那么JVM会将线程的中断标志重新设置为false，并抛出一个InterruptedException异常，然后开发人员可以中断状态位“的本质作用-----就是程序员根据try-catch功能块捕捉jvm抛出的InterruptedException异常来做各种处理，比如如何退出线程。
		//地门
		thread.setDaemon(true);// 将会变成一个守护线程 守护线程将会在外部的线程结束时候自动的结束
		// 线程结束的方法 推荐使用 return 结束这个函数的run方法就可以了 使用stop可能会发生不可预料的结果
		// 过时方法 不推荐使用了---但是这个个方法只是使用暂停但是没有释放暂停的方法
		thread.suspend();
		thread.resume();
		//线程组--几乎没什么用就是就是个线程的简单包装
		thread.activeCount();
		ThreadGroup threadGroup = new ThreadGroup("sdf");
		threadGroup.activeGroupCount();//返回线组中的活动线程组的数量
		thread.activeCount();//	返回线程中相同线程组中的线程数量;
		threadGroup.activeCount();//返回这个线程组中的相同线程的数量
		//Thread 表示使用的当前的线程
		//如果线程是通过实现Runnable接口来实现的，则不是Thread类，不能直接使用Thread.xxxxx，
		Thread.currentThread();// 获得当前正在使用的cpu线程
		Thread.activeCount();
		Thread.interrupted();
		Thread.holdsLock(new String());//如果當前線程在指定的對象上保持監視器鎖此方法返回true。
		Thread.yield();
		Thread.interrupted();
	}
	@SuppressWarnings("unused")
	public void method2() {
		// 主线程的线程的默认优先级是5 main 是主线程-当前正所处在的线程组的名称
		Thread thread = Thread.currentThread();// 获得当前正在使用的cpu线程
	}
}

class mythread2 extends Thread {
	public mythread2() {
		super();
	}
	// 重写了run 方法就会进行自动启动
	@Override
	public void run() {
		super.run();
	}
}
// 当 多线程的时候如果出现了异常 锁会自动的释放
// 同步锁只只是对加了同步的部分进行的同步
class Ceshi5 {
	// 函数定义了这个关键字表示 同步方法 将会使用互斥锁 争夺类的资源互斥--!!!!!!但是要保证同的线程使用的是相同的类引用
	// 当函数被分装好没办法进行操作的时候 可以使用 同步代码块进行处理
	// synchronized 只能修饰 方法 而且方法不具有继承性 也就是说如果子类重写了这个方法 并且没有在动态的加上
	// synchronized的时候将会 重写的方法将不会有继承性
	// 这个方法 会导致线程中所有的 同步方法 和同步代码块都不进行相互冲突
	//wo le ti e
	volatile int a;// 声明变量的值是从共有堆()中 取得的数据 而不是 从私用堆中 jvm在server模式下  为实现效率没有同步共有私有堆的数据--死记着
	//thing kui nai zi di
	synchronized public void call(String s) {
		// 这个方法加上的是对象同步锁(就是使用不同的线程调用相同的对象) 对于不同的对象 他们之间的synchronized 是没有区别的
		System.out.print("{" + s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("}");
		call2();// 锁重入 --可以调用方法中其他 加上 synchronized 的方法
		//锁重入可以同步synchronized方法或者synchronized(this){}代码块 或者 相同对象的synchronized(xx){}代码块
	}

	synchronized public static void call3(int a) {
	}// 当给静态类加上 同步方法的时候 将会给整个类加上加持 加上的不是对象锁而是class类锁 因为静态方法 全局位以可以通过类名直接使用
	// 因为使用的锁是不同的 所以 静态同步的对象同步将会表现位异步
	// 锁重入 --- 在加锁的方法中可以调用方法内部其他线程没有调用的加synchronized的方法
	// 锁重入也可以发生在父元素的方法中

	synchronized public void call2() {
		//其实这个的实现是默认使用当前的
	}

	public void call3() {
		// 同步代码块 参数串入需要进行调用的引用- 从而保证锁调用的对象!!是被同步的
		synchronized (this) {
		} // 同步代码块中的参数是指定到底是将哪个类作为监视对象---同步哪个实现类中的对象
		// 此函数中除了同步代码块之外的所有方法都是并行的 代码块中的是同步的---所以 当发生竞争的时候代码将会先运行其他的东西然后在运行此方法
		// 当一个同步代码块被运行的时候 此函数中其他同步代码块将会被阻塞
		synchronized (new Object()) {
		}
		// 当同步代码块中的类是可以跨引用的 也就是说不同的类实例使用使用同步代码块中的一个属性将会保持同步
	}
}

// join方法示例
class ClassRom implements Runnable {

	Thread thread1, thread2;

	public ClassRom() {
		// TODO Auto-generated constructor stub
		thread1 = new Thread(this, "one");
		thread2 = new Thread(this, "two");
		thread1.start();
	}

	@SuppressWarnings("static-access")
	public void run() {
		// TODO Auto-generated method stub
		if (thread1.currentThread() == thread1) {
			System.out.println("等待2执行完");
			try {
				// 是讲当前的cpu资源送给join的方法 当join的线程执行完后再会回来去执行这个方法
				// 如果join没有start将会自动的认为已经执行完成
				thread2.start();
				thread2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2已经执行完");
		} else if (Thread.currentThread() == thread2) {
			System.out.println("2正在执行");
			try {
				thread2.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2执行完");
		}
	}
}

// 实现多个线程 之间 访问公共变量的方法
// 记住要保证 多线程的问题 需要考虑到每一步的原子性问题
class Mythread extends Thread {
	// 这个只是解决了共享内存的问题
	volatile public static int count = 0;// static 加上 volatile 实现同步变量 实现变量的可见性
	// jvm虚拟机如果运行在 服务器模式下 虚拟机将会 通过工作内存进行随便的拿来不管有没有别人正在使用改变数值
	// volatile将会强制使用最新的变量--相当于给变量加上互斥锁
	// 这个解决了重复赋值的问题
	//原子性加可见性
	//我 了 太 e
	volatile AtomicInteger aaAtomicInteger = new AtomicInteger(10);// 声明原子性的变量可以实现原子性

	synchronized public static void add() { // static 加上 synchronized 实现 class
											// 类级别的同步变量
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}

	@Override
	public void run() {
		super.run();
		add();
	}
	//使用线程组
	public static void main2(String[] args) {
		System.out.println("A处线程：" + Thread.currentThread().getName() + ", 所属线程："
				+ Thread.currentThread().getThreadGroup().getName() + ", 组中有线程组数量："
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup("新的组");
		System.out.println("B处线程：" + Thread.currentThread().getName() + ", 所属线程："
				+ Thread.currentThread().getThreadGroup().getName() + ", 组中有线程组数量："
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tg);
		for (int i = 0; i < tg.length; i++)
			System.out.println("第一个线程组名称为：" + tg[i].getName());
	}

}
