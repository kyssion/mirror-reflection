package javaEE.f_异步;

import javax.servlet.AsyncContext;

public class Myrunnable implements Runnable{
	private AsyncContext asyncContext = null;
	public Myrunnable(AsyncContext asyncContext){
		this.asyncContext=asyncContext;
		//能获取 request 和response
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5*1000);
			System.out.println("睡醒了");
			//异步请求界面。。。注意相应的页面要保证session=fale 防止创建新的session对象
			//asyncContext.dispatch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
