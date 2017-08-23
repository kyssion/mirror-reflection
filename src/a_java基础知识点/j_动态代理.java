package a_java基础知识点;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

import org.xml.sax.HandlerBase;

public class j_动态代理 {
	//代理类的特征 
		/*
		 * 1.代理类 是public final 而不是  abstract
		 * 2.所有代理类都是 proxy的子类 扩展名成 为$proxy？？加上数字
		 * 3.代理类创建的是实例的接口
		 * 4.代理类 将会实现所在的接口 所以他的实现类使用getIntance将会返回他所实现的相关接口
		 * 			getmethod 将会返回他的相关的方法数组
		 * 5. proxy.isProxyClass 方法将会判断是否是使用代理方法创建的累
		 * 6.代理类有一个 参数（接口 InvocationHandler 的实现）的公共构造方法 用于设置代理实例的调用处理程序。并非必须使用反射 API 才能访问公共构造方法，通过调用 Proxy.newInstance 方法
		 * 	（将调用 Proxy.getProxyClass 的操作和调用带有调用处理程序的构造方法结合在一起）也可以创建代理实例。 
		 * */     
	public static void main(String[] args) {}
	public void methodProxy(){
		Proxy.getInvocationHandler(new HandlerBase());//返回指定实例的调用处理程序
		Proxy.getProxyClass(new Integer(12).getClass().getClassLoader(), null);//返回代理类的实例对象并向其提供接口数组
		Proxy.newProxyInstance(new ClassLoader() {//新建一个代理接口
		}, null	, Proxy.getInvocationHandler(new IncompatibleClassChangeError()));
		// 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
		//相当于Proxy.getProxyClass(loader, interfaces).getConstructor(new Class[] { InvocationHandler.class }).newInstance(new Object[] { handler });
                  
	}
	public void  methodInvocationHandler(){
		 InvocationHandler in = new   InvocationHandler(){
			 // 在代理实例上处理方法调用并返回结果依赖注入的根本方法--相当于代理的方法而已
			@Override//接口中第一个参数实际上是 生成代理类的实例 第二个参数是在代理类实际中使用的时候调用的函数 第三个是参数
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		 };
	}
}
