package javaEE.a_servlet.解决中文乱码;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class 解决中文乱码
 */
@WebServlet("/解决中文乱码")
public class 解决中文乱码 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.解决请求中的中文乱码
		String string=new String(request.getParameter("").getBytes("字符编码"),"想要的编码");
		//2.解决相应头上的中文乱码--推荐
		request.setCharacterEncoding("UTF-8");
	}
}
