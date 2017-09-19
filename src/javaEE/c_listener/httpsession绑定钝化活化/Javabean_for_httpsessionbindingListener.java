package javaEE.c_listener.httpsession绑定钝化活化;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
//判断javabean是否加入到session作用域中还是移出session作用域，动态的使用这个方法
public class Javabean_for_httpsessionbindingListener implements HttpSessionBindingListener{
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override//当对象加入到session作用域的时候自动调用
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getName();
		arg0.getSession();
		arg0.getValue();//放回当前的对象
		
	}

	@Override//当对象从session作用域移出的时候自动调用
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getName();
		arg0.getSession();
		arg0.getValue();//放回当前的对象
		
	}

}
