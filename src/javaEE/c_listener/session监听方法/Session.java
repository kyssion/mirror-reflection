package javaEE.c_listener.session监听方法;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Session
 *
 */
@WebListener
public class Session implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionIdListener {

    /**
     * Default constructor. 
     */
    public Session() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	//session创建的时候将会自动的添加
         // TODO Auto-generated method stub
    	System.out.println("sessionCreated"+se.getSession()+" "+se.getSource());
    	
    }
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	//session删除的时候将会自动的添加
    	System.out.println("sessionDestroyed"+se.getSession()+" "+se.getSource());
    }


	/**
     * @see HttpSessionIdListener#sessionIdChanged(HttpSessionEvent, String)
     */
    public void sessionIdChanged(HttpSessionEvent se, String oldSessionId)  { 
         // TODO Auto-generated method stub
    	//session'id更改的时候将会自动的添加
    	System.out.println("sessionIdChanged"+se.getSession()+" "+se.getSource());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
        // TODO Auto-generated method stub
    	//session的值进行更新的时候将会自动的进行更改
    	System.out.println("attributeAdded"+se.getSession()+" "+se.getSource());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	//session 的值删除的时候将会自动的进行更改
    	System.out.println("attributeRemoved"+se.getSession()+" "+se.getSource());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	//session的值进行修改的时候将会进行更改
    	System.out.println("attributeReplaced"+se.getSession()+" "+se.getSource());
    }
}
