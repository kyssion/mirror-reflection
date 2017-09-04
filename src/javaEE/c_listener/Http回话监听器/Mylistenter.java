package javaEE.c_listener.Http回话监听器;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Mylistenter implements HttpSessionListener,HttpSessionAttributeListener{
	//HttpSessionListener --监听session作用域的创建和销毁的方法
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}
	//在session作用域中添加和删除 修改
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		
		session.getServletContext();//获得上下文
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}
}
