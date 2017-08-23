package javaEE.c_listener.httpsession绑定钝化活化;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
//钝化,活化处理。。。。。一定要是想serivalizeable 序列化接口--当tomcat服务器重启等情况的时候session作用域的变量会自动的变成文件存放在服务器中的过程叫做敦化
public class javabean_for_httpsessionactivationListener implements HttpSessionActivationListener,Serializable{
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

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getSession();//获得session
		//被活化后
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//将要被敦化
	}

}
