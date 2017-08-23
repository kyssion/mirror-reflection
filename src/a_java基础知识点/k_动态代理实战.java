package a_java基础知识点;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import a_java基础知识点.MyInvocationHandler;
import a_java基础知识点.Myinterface;
import a_java基础知识点.ThisIsMyProxy;

public class k_动态代理实战 {
	public static void main(String[] args){
		MyInvocationHandler myInvocationHandler = new  MyInvocationHandler();
		Myinterface subject = (Myinterface) myInvocationHandler.bind(new ThisIsMyProxy() );
		subject.methodsay();
	}
}
interface Myinterface{
	public void methodsay();
}
class ThisIsMyProxy implements Myinterface{

	@Override
	public void methodsay() {
		// TODO Auto-generated method stub
		System.out.println("heheheeh");
	}
}
class MyInvocationHandler implements InvocationHandler{
	private Object object;
	public MyInvocationHandler() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Object bind(Object object){
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"    "+proxy.getClass().getName());//传递的是调用的方法
		Object object = method.invoke(this.object, args);
		return null;
	}
}