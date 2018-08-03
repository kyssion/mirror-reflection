package javaEE.f_异步;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class My_asycn_servlet
 */
@WebServlet(urlPatterns="/my_asycn_servlet",asyncSupported=true)
public class My_asycn_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public My_asycn_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决逻辑处理的时候耗时操作阻塞进程的问题
		//启动一个AsyncContext开始进行异步操作
		AsyncContext asyncContext = request.startAsync();
		//设置异步操作超时时长
		asyncContext.setTimeout(60*1000);
		//开始进行异步操作
		asyncContext.start(new Myrunnable(asyncContext));
		System.out.println("异步正在执行");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
