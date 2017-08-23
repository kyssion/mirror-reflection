package java包.java并发工具包;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.jmx.snmp.tasks.ThreadService;


public class e_线程池和Executor框架 {

}

// 1.线程池的使用
class UserThreadPool {
	// 线程池中存在一个核心队列线程数 corePoolSiese--核心线程数量 maximumPoolSize---最大线程数量
	// blockingQueue --工作等待队列
	// 过程如果有新的工作加入到 会看看是否达到核心线程数 没有开辟新的线程否则加入工作队列
	// 如果工作队列没有满就加入 否则扩张线程数
	// 当达到最大线程数的时候还没有能加入就跑出异常
	public void ceshi() throws InterruptedException, ExecutionException {
		int corePoolSize = 12;//核心线程大小
		int maximumPoolSize=20;//最大线程数大小
		BlockingQueue<Runnable> workQueue = 
				new ArrayBlockingQueue<>(100);//线程组使用的工作队列
		//工作队列可以使用多种阻塞队列 LInkBlockingQueue synchronousQueue PriorityBlockingQueue
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return null;
			}
		};//指定生成工厂方法的策略
		class MyHandle implements RejectedExecutionHandler{
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				
			}
		}
		RejectedExecutionHandler handler =  new MyHandle();// 指定生成的饱和策略AborPolicy-直接抛出异常 CallerRunsPolicy-只调用所有者的线程来执行人物 DiscardOldest-丢弃队列中最后一个任务来执行这个人物 DiscardPolicy-不处理丢掉
		long keepAliveTime =1000;//人物结束后工作线程的保留时间
		TimeUnit unit =TimeUnit.DAYS;
		ThreadPoolExecutor threadPoolExecutor=
				new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,threadFactory, handler);
		threadPoolExecutor.prestartAllCoreThreads();//启动所有线程  默认的方法是动态的进行分配
		//提交要执行的任务
		threadPoolExecutor.execute(new Thread());//不带返回值的运行方法
		Future<?> future = threadPoolExecutor.submit(new Thread());//带返回值的运行方法
		Future<String> sss=threadPoolExecutor.submit(new Thread(),"sdf");//传入的第二个参数是返回值
		//threadPoolExecutor.submit(task);传入一个实现cellable借口的兑现是想上面的方法
		sss.get();//住线程将会等待返回结果
		sss.cancel(true);//取消等待  true标记是否结束线程
		sss.isCancelled();//判断这个任务是否被取消
		sss.isDone();//判断任务是否执行完成
		
		//关闭线程//调用所有的线程依次interrupt方法
		threadPoolExecutor.shutdown();//只是加上标然后尝试中断所有想中断的线程
		List<Runnable> list= threadPoolExecutor.shutdownNow();//将线程的状态设置成SHOP然后尝试中断所有的
		threadPoolExecutor.isShutdown();//只要调用上面的任意一个都会返回true
		threadPoolExecutor.isTerminated();//只有所有的线程都关闭
		threadPoolExecutor.isTerminating();//是否有线程在终止中
		threadPoolExecutor.getTaskCount();//获得线程池中需要执行的线程数量
		threadPoolExecutor.getCompletedTaskCount();//获得线程池中已完成的线程数量
		threadPoolExecutor.getLargestPoolSize();//获得线程池中曾经创建过的最大的线程池数量
		threadPoolExecutor.getPoolSize();//获得线程池中线程的数量
		threadPoolExecutor.getActiveCount();//获取活动线程数量
	}
}
//2.Executor框架线程池的框架
class Executor{
	//1.executor框架主要由3部分组成 （1）任务 Runnable 或者 callabe接口（2）任务执行接口 Executor ExecutorService --实现类 ThreadPoolExecutor ScheduledThreadPoolExecutor
	//（3） 异步计算结果 Future -实现类 FutureTask
	public void one () {
		//使用executor创建 三种ThreadPoolExecutor -- FixedThreadPool SingleThreadExecutor CachedThreadPool
		ExecutorService onExecutor = Executors.newFixedThreadPool(10, null);//创建一个指定工作线程大小的线程组
		ExecutorService two = Executors.newSingleThreadExecutor(null);//创建单一线程组成的线程组
		ExecutorService three = Executors.newCachedThreadPool(null);//创建一个自增加的线程组
		
		//两种scheduledThread
		Executors.newScheduledThreadPool(10);//包含多个线程的线程池
		Executors.newSingleThreadScheduledExecutor(null);//只包含一个线程的系统
		
	}
						
}
// 1.手动实现一个线程池
class Mythread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int a = 0; a < 5; a++) {
			System.out.println("one");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class ThreadPoolcreate {
	public static void main(String[] args) throws InterruptedException {
		ThreadPool<Thread> threadPool = new DefaultThreadPool<>(1);
		threadPool.execute(new Thread(new Mythread()));
		while (threadPool.getJobSize() != 0) {
			Thread.currentThread().sleep(1000);
		}
		threadPool.shutdown();
		System.out.println("all end");
	}
}

interface ThreadPool<Job extends Runnable> {
	// 将一个需要执行的线程添加线程池中并执行
	public void execute(Job job);

	// 关闭线程池
	public void shutdown();

	// 添加指定数量的线程池中的工作线程
	public void addWorker(int number);

	// 减少工作线程的数量
	public void removeWorker(int number);

	// 返回正在等待执行的任务数量
	public int getJobSize();
}

// 简易的线程组
class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	private int MAX_WORKER_NUMBER = 10;// 设置最大线程数量
	private int DEFAULT_WORKER_NUMER = 5;// 设置默认线程数量
	private int MIN_WORKER_NUMBER = 1;// 设置最小线程数量
	private final LinkedList<Job> jobs = new LinkedList<>();// 设置传入需要运行的线程
	private final ConcurrentLinkedQueue<Worker> workers = new ConcurrentLinkedQueue<>();// 设置线程的工作队列
	private int WORKER_NUMBER = this.DEFAULT_WORKER_NUMER;
	private AtomicInteger workid = new AtomicInteger();// 设置工作线程的编号

	public DefaultThreadPool() {
		// TODO Auto-generated constructor stub
		this.initallWorker(WORKER_NUMBER);
	}

	public DefaultThreadPool(int num) {
		WORKER_NUMBER = num > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER : num < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER : num;
		this.initallWorker(WORKER_NUMBER);
	}

	private void initallWorker(int num) {
		Worker worker;
		Thread thread;
		for (int i = 0; i < num; i++) {
			worker = new Worker();
			workers.add(worker);
			thread = new Thread(worker, "threadPool-" + workid.incrementAndGet());// 加一
			thread.start();
		}
	}

	@Override
	public void execute(Job job) {
		// TODO Auto-generated method stub
		if (job != null) {
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notifyAll();
			}
		}
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		for (Worker worker : workers) {
			worker.shutdown();
		}
	}

	@Override
	public void addWorker(int number) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if (number + this.WORKER_NUMBER > MAX_WORKER_NUMBER) {
				number = MAX_WORKER_NUMBER - this.WORKER_NUMBER;
			}
			initallWorker(number);
			this.WORKER_NUMBER += number;
		}
	}

	@Override
	public void removeWorker(int number) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if (number >= this.WORKER_NUMBER) {
				throw new IllegalArgumentException("beyone work number");
			}
			int count = 0;
			while (count < number) {
				Worker worker = workers.remove();
				worker.shutdown();
				count++;
			}
			this.WORKER_NUMBER -= count;
		}
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return jobs.size();
	}

	class Worker implements Runnable {
		private volatile boolean running = true;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (running) {
				Job job = null;
				synchronized (jobs) {
					while (jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							Thread.currentThread().interrupt();
							e.printStackTrace();
						}
					}
					job = jobs.removeFirst();
				}
				if (job != null) {
					job.run();
				}
			}
		}

		public void shutdown() {
			this.running = false;
		}
	}
}
