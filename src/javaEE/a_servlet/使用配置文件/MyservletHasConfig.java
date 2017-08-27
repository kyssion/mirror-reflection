package javaEE.a_servlet.使用配置文件;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
//当使用不需要注解的方法进行配置的时候 -- 需要集成httoservlet这个类
public class MyservletHasConfig extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("MyJsp.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	//request的所有方法
	abstract class  myrequest implements HttpServletRequest,ServletRequest{
		//使用request作用域的方法
		public Object getAttribute(String arg0) {return null;}
		public Enumeration<String> getAttributeNames() {return null;}
		public void removeAttribute(String arg0) {}
		public void setAttribute(String arg0, Object arg1) {}
		//获得url请求的方法
		public String getParameter(String arg0) {return null;}
		public Map<String, String[]> getParameterMap() {return null;}
		public Enumeration<String> getParameterNames() {return null;}
		public String[] getParameterValues(String arg0) {return null;}
		//获得输入流的方法
		public BufferedReader getReader() throws IOException {return null;}
		public ServletInputStream getInputStream() throws IOException {return null;}
		//request转发
		//forward和include
		public RequestDispatcher getRequestDispatcher(String arg0) {return null;}
		//request字符串请求的方法
		public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {}
		public String getCharacterEncoding() {return null;}
		//获得cookie
		public Cookie[] getCookies() {return null;}
		//获得请求的方法
		public String getMethod() {return null;}
		//获得session
		public HttpSession getSession() {return null;}
		public HttpSession getSession(boolean arg0) {return null;}
		//获得servlet上下文
		public ServletContext getServletContext() {return null;}
		//------请求方法-------
		public int getContentLength() {return 0;}
		public long getContentLengthLong() {return 0;}
		public String getContentType() {return null;}
		public DispatcherType getDispatcherType() {return null;}
		public String getLocalAddr() {return null;}
		public String getLocalName() {return null;}
		public int getLocalPort() {return 0;}
		public Locale getLocale() {return null;}
		public Enumeration<Locale> getLocales() {return null;}
		public String getServerName() {return null;}
		public int getServerPort() {return 0;}
		
		//获得上下文地址???
		public String getContextPath() {return null;}
		public long getDateHeader(String arg0) {return 0;}
		public String getHeader(String arg0) {return null;}
		public Enumeration<String> getHeaderNames() {return null;}
		public Enumeration<String> getHeaders(String arg0) {return null;}
		public int getIntHeader(String arg0) {return 0;}
		//获得相对路径
		public String getRequestURI() {return null;}
		//获得绝对路径
		public StringBuffer getRequestURL() {return null;}
		public String getRequestedSessionId() {return null;}
		//获得请求的参数
		public String getQureString() {return null;}
		//???
		public String getServletPath() {return null;}
		public boolean isRequestedSessionIdFromCookie() {return false;}
		public boolean isRequestedSessionIdFromURL() {return false;}
		public boolean isRequestedSessionIdFromUrl() {return false;}
		public boolean isRequestedSessionIdValid() {return false;}
		public boolean isUserInRole(String arg0) {return false;}
	}
	//response所有的方法
	class myresponse implements HttpServletResponse,ServletResponse{
		//cookie获取
		public void addCookie(Cookie arg0) {}
		//重定向
		public void sendRedirect(String arg0) throws IOException {}
		//设置http报头方法
		public void flushBuffer() throws IOException {}
		public int getBufferSize() {return 0;}
		public String getCharacterEncoding() {return null;}
		public String getContentType() {return null;}
		public Locale getLocale() {return null;}
		public ServletOutputStream getOutputStream() throws IOException {return null;}
		public PrintWriter getWriter() throws IOException {	return null;}
		public boolean isCommitted() {return false;}
		public void reset() {}
		public void resetBuffer() {}
		public void setBufferSize(int arg0) {}
		public void setCharacterEncoding(String arg0) {}
		public void setContentLength(int arg0) {}
		public void setContentLengthLong(long arg0) {}
		public void setContentType(String arg0) {}
		public void setLocale(Locale arg0) {}
		public void addDateHeader(String arg0, long arg1) {}
		public void addHeader(String arg0, String arg1) {}
		public void addIntHeader(String arg0, int arg1) {}
		public boolean containsHeader(String arg0) {return false;}
		public String encodeRedirectURL(String arg0) {return null;}
		public String encodeRedirectUrl(String arg0) {return null;}
		public String encodeURL(String arg0) {return null;}
		public String encodeUrl(String arg0) {return null;}
		public String getHeader(String arg0) {return null;}
		public Collection<String> getHeaderNames() {return null;}
		public Collection<String> getHeaders(String arg0) {return null;}
		public int getStatus() {return 0;}
		public void sendError(int arg0) throws IOException {}
		public void sendError(int arg0, String arg1) throws IOException {}
		public void setDateHeader(String arg0, long arg1) {}
		public void setHeader(String arg0, String arg1) {}
		public void setIntHeader(String arg0, int arg1) {}
		public void setStatus(int arg0) {}
		public void setStatus(int arg0, String arg1) {}
	}
	//session
	class mysession implements HttpSession{
		//session 常用方法
		public void invalidate() {}//????
		public void removeAttribute(String arg0) {}
		public void removeValue(String arg0) {}
		public void setAttribute(String arg0, Object arg1) {}
		public Object getAttribute(String arg0) {return null;}
		public String[] getValueNames() {return null;}
		public void setMaxInactiveInterval(int arg0) {}
		//其他方法
		public Enumeration<String> getAttributeNames() {return null;}
		public long getCreationTime() {return 0;}
		public String getId() {return null;}
		public long getLastAccessedTime() {return 0;}
		public int getMaxInactiveInterval() {return 0;}
		//获得上下文信息application
		public ServletContext getServletContext() {return null;}
		public HttpSessionContext getSessionContext() {return null;}
		public Object getValue(String arg0) {return null;}
		public boolean isNew() {return false;}
		public void putValue(String arg0, Object arg1) {}
	}
	//application
	abstract class myapplication implements ServletContext{
		public void removeAttribute(String arg0) {}
		public void setAttribute(String arg0, Object arg1) {}
		public Object getAttribute(String arg0) {return null;}
		public Enumeration<String> getAttributeNames() {return null;}
		//获得在web.xml文件中配置的文件的属性  详情见web.xml
		public String getInitParameter(String arg0) {return null;}
		//获得init的初始化参数列表
		public Enumeration<String> getInitParameterNames() {return null;}
		//在全局作用于中加入相关的属性
		public boolean setInitParameter(String arg0, String arg1) {return false;}
		//添加过滤器
		public Dynamic addFilter(String arg0, Class<? extends Filter> arg1) {return null;}
		public Dynamic addFilter(String arg0, Filter arg1) {return null;}
		public Dynamic addFilter(String arg0, String arg1) {return null;}
		//添加监听器
		public void addListener(Class<? extends EventListener> arg0) {}
		public void addListener(String arg0) {}
		public <T extends EventListener> void addListener(T arg0) {}
		
		public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, Class<? extends Servlet> arg1) {return null;}
		public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, Servlet arg1) {return null;}
		public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, String arg1) {return null;}
		public <T extends Filter> T createFilter(Class<T> arg0) throws ServletException {return null;}
		public <T extends EventListener> T createListener(Class<T> arg0) throws ServletException {return null;}
		public <T extends Servlet> T createServlet(Class<T> arg0) throws ServletException {return null;}
		public void declareRoles(String... arg0) {}
		public ClassLoader getClassLoader() {return null;}
		
		public ServletContext getContext(String arg0) {return null;}
		
		public String getContextPath() {return null;}
		public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {return null;}
		public int getEffectiveMajorVersion() {return 0;}
		public int getEffectiveMinorVersion() {return 0;}
		public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {return null;}
		public FilterRegistration getFilterRegistration(String arg0) {return null;}
		public Map<String, ? extends FilterRegistration> getFilterRegistrations() {return null;}
		public JspConfigDescriptor getJspConfigDescriptor() {return null;}
		public int getMajorVersion() {return 0;}
		public String getMimeType(String arg0) {return null;}
		public int getMinorVersion() {return 0;}
		public RequestDispatcher getNamedDispatcher(String arg0) {return null;}
		public String getRealPath(String arg0) {return null;}
		
		//实现相关的url转发
		public RequestDispatcher getRequestDispatcher(String arg0) {return null;}
		
		public URL getResource(String arg0) throws MalformedURLException {return null;}
		public InputStream getResourceAsStream(String arg0) {return null;}
		public Set<String> getResourcePaths(String arg0) {return null;}
		public String getServerInfo() {return null;}
		public Servlet getServlet(String arg0) throws ServletException {return null;}
		public String getServletContextName() {return null;}
		public Enumeration<String> getServletNames() {return null;}
		public ServletRegistration getServletRegistration(String arg0) {return null;}
		public Map<String, ? extends ServletRegistration> getServletRegistrations() {return null;}
		public Enumeration<Servlet> getServlets() {return null;}
		public SessionCookieConfig getSessionCookieConfig() {return null;}
		public String getVirtualServerName() {return null;}
		public void log(Exception arg0, String arg1) {}
		public void log(String arg0, Throwable arg1) {}
		public void log(String arg0) {}
		public void setSessionTrackingModes(Set<SessionTrackingMode> arg0) {}
		
	}
}
