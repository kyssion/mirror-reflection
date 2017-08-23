package javaEE.f_异步.new_async_io;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class Myreadlistener implements ReadListener{
	AsyncContext asynccontext=null;
	ServletInputStream inputStream=null;
	public Myreadlistener(AsyncContext asyncContext,ServletInputStream inputStream){
		this.asynccontext=asyncContext;
		this.inputStream=inputStream;
	}
	public Myreadlistener() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override//当所有的数据读完后怎么办
	public void onAllDataRead() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override//耗时的读取操作
	public void onDataAvailable() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override//当出现错误的时候怎么办
	public void onError(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

}
