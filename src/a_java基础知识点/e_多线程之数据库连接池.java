package a_java基础知识点;

import java.util.LinkedList;

public class e_多线程之数据库连接池 {

}
//手动实现一个简单的连接池
class myPoolThreadceshi {
	public static void main(String[] args) throws Exception {
		MythreadPool mythreadPool = new MythreadPool(3);
		for (int a = 0; a < 1000; a++) {
			new MythreadforPool(mythreadPool, "" + a).start();
		}
	}
}
class MythreadPool {
	LinkedList<Item> linkedList = new LinkedList<>();
	private int count = 0;

	public MythreadPool(int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
		for (int a = 0; a < this.count; a++) {
			linkedList.add(new Item(a));
		}
	}
	public void add(Item item) {
		if (item != null) {
			synchronized (linkedList) {
				linkedList.add(item);// 添加得到的数据
				linkedList.notifyAll();// 唤醒所有正在等待的元素
			}
		}
	}

	public Item getOne() throws InterruptedException {
		return getOne(800);
	}

	public Item getOne(long timer) throws InterruptedException {
		synchronized (linkedList) {
			if (timer <= 0) {
				while (linkedList.isEmpty()) {
					linkedList.wait();
				}
				return linkedList.removeFirst();
			} else {
				long uptime = System.currentTimeMillis() + timer;// 设置到期时间
				long remindtim = timer;// 设置剩余时间
				while (remindtim < 0 && linkedList.isEmpty()) {
					linkedList.wait(remindtim);
					remindtim = uptime - System.currentTimeMillis();
				}
				if (linkedList.isEmpty() != true) {
					return linkedList.removeFirst();
				} else {
					return null;
				}
			}
		}
	}
}
class Item {
	public int number = 0;

	public Item(int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}
}
class MythreadforPool extends Thread {
	MythreadPool pool = null;

	public MythreadforPool(MythreadPool pool, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.pool = pool;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Item item = null;
		for (int a = 0; a < 10; a++) {
			try {
				while (item == null) {
					item = pool.getOne();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread is :" + Thread.currentThread().getName() + " number is " + item.getNumber());
			pool.add(item);
		}
	}
}