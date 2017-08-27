package java包.java并发工具包;

import java.util.concurrent.*;

public class a_同步对象并发工具类 {
	public void one() throws InterruptedException {
		// 信号量同步工具 和ReentrantLock类似
		Semaphore semaphore = new Semaphore(1); // 声明同步工具锁
												// 声明初始化的时候有几个信号量
												// （还有一个可选的boolean类型参数表示是否使用顺序访问）
		semaphore.acquire(); // 获得一个信号量默认是1 如果总量不足一的时候竟会停止 //只用当这个线程的标记达到了相关的标记量之后才会运行，否则一直阻塞
		semaphore.release(); // 释放许可证表示释放许可证的数目默认是1
		semaphore.tryAcquire(0,123, TimeUnit.DAYS);//设置等待时间超过等待时间线程状态将致为interrupted
	}
	public void two() throws InterruptedException {
		// 事件计数器共享类 -- 创建的时候声明一个时间计数器 （可以设置超时时间等效果）当计数器为零的时候await（）的线程可以进行运行
		CountDownLatch countDownLatch = new CountDownLatch(10);
		countDownLatch.countDown();// 让计数器加1
		countDownLatch.await();// 进行等待...countDownLathch--计数器减一
		countDownLatch.getCount();//返回当前的计数器
	}
	public void three() throws InterruptedException, BrokenBarrierException {
		// 这个方法是先按照 await的线程的数量进行操作的方法
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("htht");
			}
		});
		// 这个方法不会释放锁
		cyclicBarrier.await();// 将会将这个线程进行等待之 当等待的数量够了构造函数传入的等待值之后将会让等待的线程继续执行下去
		cyclicBarrier.reset();// 重新计数
	}
	public void exchange() throws InterruptedException {
		// 实现线程中的数据缓冲传递方法
		Exchanger<String> exchanger = new Exchanger<>();
		// 只有一个方法实现 实现两头通信
		String string = exchanger.exchange("xxx");
		//String string2= exchanger.exchange(x, timeout, unit);
	}
	// 指定线程执行类----线程池
	public void fout() {
		// Java 一共提供了四种线程池
		// Java通过Executors(Exector),ExecutoyService(除了前面的使用了shutdown())scheduleExecutor(提供了线程调度)提供四种线程池，分别为：
		// newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		// newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
		// newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
		// newSingleThreadExecutor
		// 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
			// 下一个需要指定大小
			// ExecutorService executorService2=Executors.newFixedThreadPool(10,
			// threadFactory);
			// ExecutorService
			// executorService2=Executors.newScheduledThreadPool(corePoolSize,
			// threadFactory)
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		executorService.shutdown();//停止向线程组中插入任务
		executorService.shutdownNow();//终止线程中所有的任务
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});// 将一个线程加入到线程池中
			// 类似execute方法当成功的时候将会放回一个结果----最后一个参数否则null
		Future<String> future = executorService.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		}, "sfsdf");
	}
	public void four() {
		// 并发集合
		// 1.并发队列
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
		// 2.
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		// 3.
		// fockjoin 框架
	}
}
// 介绍使用submit的用法当时用这个方法的时候
// 可以传入一个实现了cellable接口的方法然后线程会执行这个方法并且将这个方法作为一个实现了run方法的线程等同处理
class mymain {
	public static void main2(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<Myceshi> future = executorService.submit(new Runnable() {
			// 使用future方法接受返回值 还可已使用 一个带时间参数的重构方法
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while (i < 10) {
					System.out.println(i);
					i++;
					try {
						Thread.currentThread().sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, new Myceshi());
		System.err.println(future.get().call());
		executorService.shutdown();
	}
}
class Myceshi {
	public Integer call() throws Exception {
		System.err.println("ok");
		return 0;
	}

}
class Myceshi2 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.err.println("ok");
		return 0;
	}

}
class Myclass {
	public void method() {
		// 线程池
		// Java 一共提供了四种线程池
		// Java通过Executors(Exector),ExecutoyService(除了前面的使用了shutdown())scheduleExecutor(提供了线程调度)提供四种线程池，分别为：
		// newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		// newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
		// newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
		// newSingleThreadExecutor
		// 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
		// ---------------------------
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		// -----------------------------------
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
	}
}
