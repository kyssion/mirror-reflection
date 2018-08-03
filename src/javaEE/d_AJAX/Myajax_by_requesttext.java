package javaEE.d_AJAX;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.BufferedInputFilter;

/**
 * Servlet implementation class Myajax_by_requesttext
 */
@WebServlet("/Myajax_by_requesttext")
public class Myajax_by_requesttext extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Myajax_by_requesttext() {
        super();
    }
    //这个方法可以很方便的传送josn数据!!!!!!!!!!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.使用 输入输出流进行交互
		//for_file(request,response);
		//2.使用 printwrite进行交互
		System.out.println("haha");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("123sfdasdfasdf(((sss****(");
		printWriter.close();
	}
	public void for_file(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//1.必须在之前设置相应头格式
		response.setContentType("text/html;charset=utf-8");
		//2.通过response获得一个和前端交互的一个输入流
		OutputStream outputStream = response.getOutputStream();		
		BufferedInputStream bufferedInputStream = null;
		FileInputStream fileInputStream = null;
		//获得文件的根目录-并且转到/txt文件夹下
		//String tinsel= request.getServletContext().getRealPath("/txt");
		String uploaddir = request.getServletContext().getRealPath("/txt");
		System.out.println(uploaddir);
		File file = new File(uploaddir,"123.txt");
		if (file.exists()){
			System.out.println("yse");
			fileInputStream= new FileInputStream(file);
			//使用缓冲流
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte[] b = new byte[1024];int i=0;
			while ((i=bufferedInputStream.read(b))!=-1){
				outputStream.write(b, 0, i);
			}
			outputStream.close();
		}
		outputStream.close();
		fileInputStream.close();
		bufferedInputStream.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
