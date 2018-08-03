package a_java基础知识点;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
//运用反射方法进行解析注解
public class h_解析注解 {}
@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface CeshiTwo {
	String value() default "this is my first";
}
@CeshiTwo("hehhehe")
class ThisisCeshe{
	@CeshiTwo("methid anntation")
	public  void  name() {
		System.out.println("this is my first");
	}
}
class CeshiOne {
	public static void main(String[] args) {
		try {
			//1.解析类上面的注解第一种方法
			//使用类加载起进行处理注解
			Class class1 =Class.forName("ThisisCeshe");
			//定义在类上的注解是否存在
			Boolean isexit=class1.isAnnotationPresent(CeshiTwo.class);
			if(isexit==true){
				//获得在 上面定义的注解实例
				CeshiTwo ceshiTwo= (CeshiTwo) class1.getAnnotation(CeshiTwo.class);
				System.out.println(ceshiTwo.value());
			}
			//2.查找方法上面的注解第一种方法 --直接查找相关注解
			Method[] methods = class1.getMethods();//获得类中的所有方法
			for(Method method :methods){//遍历method 数组  找到相关的方法
				if(method.isAnnotationPresent(CeshiTwo.class)){//当methde 从在相关的方法
					System.out.println(method.getAnnotation(CeshiTwo.class).value());
				}
			}
			//2. 想找到所有的类 通过所有的类 查找类有关的所有注解方法 在从得到的注解数组进行解析查找自己需要的方法
			for(Method method : methods){
				Annotation[] annotations =  method.getAnnotations();
				for (Annotation annotation:annotations){
					if (annotation instanceof CeshiTwo){
						CeshiTwo ceshiTwo = (CeshiTwo) annotation;//----将注解强制转换就能直接使用了
						System.out.println(ceshiTwo.value());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//使用反射加 自定意注解初始化类
class AAAAA {
	public static void main(String[] args) {
		AAAAA o = new AAAAA();
		try {
			Myceshijkl myceshi = o.getMycehshi();
			myceshi.say();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Myceshijkl getMycehshi() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> myceshiclass = Myceshijkl.class;
		Myceshijkl myceshi = new Myceshijkl();
		for (Field field : myceshiclass.getDeclaredFields()) {
			field.setAccessible(true);
			for (Annotation annotation : field.getAnnotations()) {
				if (annotation instanceof SetInfo) {
					if (field.getName().startsWith("name")) {
						field.set(myceshi, ((SetInfo) annotation).name());
					} else if (field.getName().startsWith("age")) {
						field.set(myceshi, ((SetInfo) annotation).age());
					} else if (field.getName().equals("frind")) {
						ArrayList<String> arrayList = new ArrayList<>();
						for (String name : ((SetInfo) annotation).friend()) {
							arrayList.add(name);
						}
						field.set(myceshi, arrayList);
					}
				}
			}
		}
		for (Method method : myceshiclass.getMethods()) {
			int a = 0;
			for (Annotation annotation : method.getAnnotations()) {
				if (annotation instanceof SetInfo) {
					method.invoke(myceshi, ((SetInfo) annotation).name());
					continue;
				}
			}
			if (method.getName().equals("setAge")) {
				Object[] objects = new Object[method.getParameterCount()];
				for (Parameter parameter : method.getParameters()) {
					for (Annotation annotation : parameter.getAnnotations()) {
						objects[a] = ((SetInfo) annotation).age();
					}
				}
				method.invoke(myceshi, objects);
			}
		}

		return myceshi;
	}
}

class Myceshijkl {
	@SetInfo(name = "liyueli")
	private String name1;
	@SetInfo(age = 123)
	private int age1;
	@SetInfo(friend = { "xiaowang", "xiaoli", "xiaozhang" })
	public ArrayList<String> frind;
	public String name;
	public int age;

	@SetInfo(name = "jishuya")
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(@SetInfo(age = 123) int age) {
		this.age = age;
	}

	public Myceshijkl() {
		// TODO Auto-generated constructor stub
	}

	public String[] friends2;

	public void setFriend() {
		@SetInfo(friend = { "one", "two", "three" })
		String[] Friends = null;
		this.friends2 = Friends;
	}

	public void say() {
		System.out.println("--------------------------------------");
		System.out.println("name is :" + this.name);
		System.out.println("age is :" + this.age);
		System.out.println("name1 is :" + this.name1);
		System.out.println("age1 is :" + this.age1);
		System.out.println("friend is :");
		for (int a = 0; a < this.frind.size(); a++) {
			System.out.println("*****" + this.frind.get(a));
		}
		System.out.println("friends2 is :");
		if (friends2 == null) {
			return;
		}
		for (int a = 0; a < this.friends2.length; a++) {
			System.out.println("*****" + this.friends2[a]);
		}
	}
}

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface SetInfo {
	public String name() default "number";

	public int age() default 12;

	public String[] friend() default {};

	public enum YEAR {
		one, two, three
	};

	public YEAR[] year() default { YEAR.one };
}


