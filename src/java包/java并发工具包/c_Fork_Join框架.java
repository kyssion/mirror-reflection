package java包.java并发工具包;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;



public class c_Fork_Join框架 {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		//forkJoinPool.execute(null);//异步不返回结果
		MyForkOne myForkOne = new MyForkOne(0, 100);
		//forkJoinPool.invoke(myForkOne);//同步返回结果
		Future<Integer> future= forkJoinPool.submit(myForkOne);//异步返回结构
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Method() {
		MyForkOne myForkOne = new MyForkOne(0, 100);
		myForkOne.cancel(true);//取消join过程
		myForkOne.complete(12);//强制完成这次的更改
		myForkOne.completeExceptionally(new Exception());//强制抛出指定的异常
		myForkOne.getException();//返回引发的异常
		myForkOne.invoke();
		if(myForkOne.isCompletedAbnormally())//判断是否引发了异常
		{
		    System.out.println(myForkOne.getException());
		}
	}
}
//fork/join==实现将队列中的数据进行分个从而操作相关的数据进行并发编程
//rui ka si zi 
//ForkJoinTark 有两个抽象类 (递归)RecursiveTask（有返回值的） RecursiveAction无返回值的
class MyForkOne extends RecursiveTask<Integer>{//一般使用forkjoinTask的实现类
	private static final long serialVersionUID = 1L;
	private int start;
	private int end;
	private int SPEED=3;
	public MyForkOne(int one,int two) {
		// TODO Auto-generated constructor stub
		this.start=one;
		this.end=two;
	}
	@Override
	protected Integer compute() {
		int sum =0;
		if (end-start<this.SPEED) {
			for (int a=start;a<=end;a++) {
				sum +=a;
			}
		}else {
			int middle = (start+end)/2;
			MyForkOne myForkOne = new MyForkOne(start, middle);
			MyForkOne myForkOne2= new MyForkOne(middle+1, end);
			//fork异步执行
			Future<Integer> future=myForkOne.fork();//执行子程序 这个方法将会自动的调用compute方法
			Future<Integer> future2=myForkOne2.fork();
			//myForkOne.invoke();
			//int one= myForkOne.join();//等待返回相关的数据
			//int two = myForkOne2.join();
			
			//fork()--执行新的部分 join等待返回结果
			myForkOne.fork();
			myForkOne.join();
			try {
				sum=future.get()+future2.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sum;
	}
	
}
class MyForkTwo extends RecursiveAction{//一般使用forkjoinTask的实现类
	private static final long serialVersionUID = 1L;

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		return ;
	}
	
}




