package javaEE.a_servlet.使用注解;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
					注解要注意 	
			asyncSupported：		声明Servlet是否支持异步操作模式。
　　			description：　　  	Servlet的描述。
　　			displayName：     		Servlet的显示名称。
　　			initParams：        		Servlet的init参数。
　　			name：　　　　    		Servlet的名称。
　　			urlPatterns：　　  	Servlet的访问URL。
　			value：　　　       		Servlet的访问URL。   ---- 
			相当于在web。xml中配置，，，如配置默认参数-在web.xml中也有相同的参=进行操作
*/
@WebServlet("/MyservletNoconfig")
public class MyservletNoconfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyservletNoconfig() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//!!!!!---1.servlet init parameters 定义在<servlet>内 Servlet init parameters 取值方法 ：
		getServletConfig().getInitParameter("Test");
		//!!!!!---2.context init parameters 定义在<web-app>内context init parameters 取值方法：
		getServletContext().getInitParameter("Test");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
