package javaEE.c_listener.Servlet上下文监听器;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistenter implements ServletContextListener,ServletContextAttributeListener{
	//ServletContextListener-接口实现的方法-主要监听ServletContext的创建和删除web应用生命周期方法
	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		//删除的时候触发的方法
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//创建的时候触发的方法
	}
	//ServletContextAttributeListener-接口实现的方法 主要监听application作用域属性的增删改查
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		
	}
}
