package javaEE.e_JOSN;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javabean.People;
import javabean.People2;

/**
 * Servlet implementation class Myservlet_for_json
 */
@WebServlet("/Myservlet_for_json")
public class Myservlet_for_json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet_for_json() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//用\ 让字符串中可以加入“
		String jso ="{\"name\":\"222\",\"id\":\"234\"}";
		String[] friend ={"wanglihua","cuihuahua"};
		People people = new People();
		people.setId("234");
		people.setName("222");
		people.setIngore("huue");
		people.setFriend(friend);
		//新建一个json类
		Gson gson = new Gson();
		System.out.println(gson.toJson(people));
		GsonBuilder gsonBuilder = new GsonBuilder();//个性化定制json
		gsonBuilder.setPrettyPrinting();//1.格式化json代码
		Gson gson2 = gsonBuilder.create();
		System.out.println(gson2.toJson(people));
		//2 设置值 策略   
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			
			@Override
			public String translateName(Field arg0) {
				//属性 field 获得每一个的值   注意当  注释和这个同时生效的时候，注释掀起作用改变变量的所有名 然后将改变后的参数给予getName()方法
				if(arg0.getName().equals("name")){
				// TODO Auto-generated method stub
					return "123";
				}
				return arg0.getName();
			}
		});
		Gson gson3 = gsonBuilder.create();
		System.out.println(gson3.toJson(people));
		
		
		
		
		//json 反序列
		Gson gson4 = new Gson();
		//1.通过json动态生成 对应的对象
		People people2 = gson4.fromJson(jso, People.class);
		System.out.println(people2.getName());
		//2.json日期
		//创造 带模板的 json 类
		String jString ="{\"name\":\"222\",\"id\":\"234\",\"friend\":[\"wanglihua\",\"cuihuahua\"],\"date\":\"1995-12-12\"}";
		
		//进行日期匹配
		Gson gson5 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		People people3 = new People();
		people3 = gson5.fromJson(jString, People.class);
		System.out.println(people3.getDate().toString());
		
		//json 可以对集合进行 无缝对接
		//1.将带集合的javabean变成 json
		People2 people22 = new People2();
		ArrayList<String> friends = new ArrayList<>();
		friends.add("wangxiaoer");
		friends.add("shangdanhua");
		people22.setFriend(friends);
		people22.setId("wakaka");
		people22.setName("yiiyi");
		Gson gson6 = new Gson();
		System.out.println(gson6.toJson(people22));
		//将带集合的json变成 javabean 反序列换变成list集合
		String jString2 ="{\"name\":\"yiiyi\",\"id\":\"wakaka\",\"friend\":[\"wangxiaoer\",\"shangdanhua\"]}";
		people22 = gson6.fromJson(jString2, People2.class);
		List<String> friends3 =people22.getFriend();
		for (String fString : friends3){
			System.out.println(fString);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
