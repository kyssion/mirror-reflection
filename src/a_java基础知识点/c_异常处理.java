package a_java基础知识点;

import java.io.*;

public class c_异常处理 {
	//首先自定以异常类  必须带一个带有String参数类型的构造参数
	class ChushulingException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//自定义异常函数必须要有一个带string类型的构造函数
		public ChushulingException(String msg) {
			super(msg);
		}
	}
	class ChushufuException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ChushufuException(String msg) {
			super(msg);
		}
	}
	class Numbertest {//在定义的方法中显示的抛出异常类
		public int shang(int x, int y) throws ChushulingException, ChushufuException {
			if (y < 0) {
				throw new ChushufuException("您输入的是" + y + ",规定除数不能为负数!");// 抛出异常
			}
			if (y == 0) {
				throw new ChushulingException("您输入的是" + y + ",除数不能为0!");
			}
			int m = x / y;
			return m;
		}
	}
	class Rt001 {
		public void oo() {
			Numbertest n = new Numbertest();
			// 使用try - catch 语句    finally
			try {
				System.out.println("商=" + n.shang(1, -3));
			} catch (ChushulingException yc) {
				System.out.println(yc.getMessage());
				yc.printStackTrace();
			} catch (ChushufuException yx) {//出现错误的时候执行的语句
				System.out.println(yx.getMessage());
				yx.printStackTrace();
			} catch (Exception y) {
				System.out.println(y.getMessage());
				y.printStackTrace();
			} finally {
				System.out.println("finally!");
			} //// finally不管发没发生异常都会被执行
		}
	}
	/*
	 * [总结]
	 * 
	 * 1.自定义异常:
	 * 
	 * class 异常类名 extends Exception { public 异常类名(String msg) { super(msg); } }
	 * 
	 * 2.标识可能抛出的异常:
	 * 
	 * throws 异常类名1,异常类名2
	 * 
	 * 3.捕获异常: try{} catch(异常类名 y){} catch(异常类名 y){}
	 * 
	 * 4.方法解释 getMessage() //输出异常的信息 printStackTrace() //输出导致异常更为详细的信息 
	 */
	//引申 java7--- 自动关闭资源  --- 待关闭的资源必须实现AutoCloseable或者Closeable接口  实现其中的close()方法
	class Auto implements AutoCloseable{
		@Override
		public void close() throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//之后 当使用try-catch-finally 将会自动的添加 关闭资源的方法
	public void hehe() {
		//高级资源自动关闭写法
		try(
				InputStream inputStream = new FileInputStream("sdfsdf");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
		){
			bufferedReader.lines();
		}catch (Exception e){

		}

		try {
			Auto ceshi = new Auto();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//之后将会自动的调用ceshi的close方法
}