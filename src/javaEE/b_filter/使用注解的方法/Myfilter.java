package javaEE.b_filter.使用注解的方法;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*
					注解要注意 
			asyncSupport-是否支持异步 
			displayName-改filter的显示名称  
			displayType-指定改filter对那种方法的请求进行过虑 (forward async error forward include request)
			initparam-filter的默认参数  
			servletNames -- 指定只对指定的servlet进行过虑
			name-servlet的名称 urlpatterner-处理的url   
			---- 相当于在web。xml中配置，，，如配置默认参数
			具体的方法和在xml文件中进行配置的效果是一样的
*/
@WebFilter("/Myfilter" )
public class Myfilter implements Filter {
    public Myfilter() {}
	public void destroy() {}
	@Override//过滤进行过滤的时候实现的的方法
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//FilterChain 实现接口的转发
		arg2.doFilter(arg0, arg1);
	}
	@Override//接口进行初始化的接口
	public void init(FilterConfig arg0) throws ServletException {
		//FilterConfig-接口实现相关的接口配置信息
		arg0.getFilterName();//获取过滤器的名称
		arg0.getInitParameter("");//获取过滤器初始化的参数
		arg0.getInitParameterNames();//获取过滤器所有的初始化名称
		arg0.getServletContext();//获得接口的上下文参数
	}
}
