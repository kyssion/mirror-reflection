package javaEE.b_filter.使用配置文件的方法;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//实用配置文件的方法
public class Myfilter implements Filter{
	public void destroy() {}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {}
	public void init(FilterConfig arg0) throws ServletException {}
}
