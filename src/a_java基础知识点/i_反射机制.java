package a_java基础知识点;

import java.io.File;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;

class CeshiInFanshe{
	public void methodone(){}
	public void methodtwo(){}
}
public class i_反射机制 {
	public static void main(String[] args){}
	//class 类的反射方法
	public void methodForClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, NoSuchFieldException{
		//class 类
		i_反射机制 i=new i_反射机制();
		//制定类名称 是否运行静态代码块 和指定类加载器
		//Static Class forName(String name, boolean initialize, ClassLoader loader)
		Class<?> class1 = Class.forName("a_java基础知识点.i_反射机制");
		Class<?> class2 = Class.forName("a_java基础知识点.i_反射机制");
		Class<?> class3 = i.getClass();
		Class<?> class4 = CeshiInFanshe.class;
		//--返回成员枚举类型 如果不是枚举类型返回 null
		class1.getEnumConstants();
		//---class 类强制转化方法
		class1.asSubclass(class2);//将class1转化成class2
		class1.cast(i);// 讲 i强制转化成 class1所表示的实现类
		//--获得classloader
		ClassLoader acClassLoader = class1.getClassLoader();
		//--类的继承和实现接口  获取父对象 和实现的接口
		class3=class1.getSuperclass();//获取父对象
		Class<?>[] classes=class2.getInterfaces();//获得接口数组
		//--返回变量名称
		String string = class1.getName();//返回类名称
		//--返回变量的包
		Package string2 =class1.getPackage();//返回变量的包类
		//--返回资源
		URL rUrl = class1.getResource("xx");//返回给定名称所属的资源
		InputStream string3 = class1.getResourceAsStream("xxx");//将给定的资源变成输入流
		//--使用构造函数
		CeshiInFanshe ceshi = (CeshiInFanshe)class4.newInstance();//使用构造函数实例化一个对象
		//--构造函数
		Constructor<?> constructor = class1.getConstructor(Integer.class,String.class);//参数为变长数组 -返回带传入class 类参数的构造函数
		Constructor<?>[] constructors = class1.getConstructors();//返回这个class所含有的所有方法--不包括继承的方法--只能使用自己定义的构造方法
		//--反射注解相关
		
		Annotation annotation = class1.getAnnotation(hehehe.class);//返回当前类中是否存在出传入的注解 有的时候将会进行返回相应的注解
		//class1.isAnnotationPresent(Ceshi2.class);//判断是否存在一个注解
		Annotation[] annotations = class1.getAnnotations();//返回类中所有的注解包括继承的
		Annotation[] annotations2= class1.getDeclaredAnnotations();//f返回类中直接继承的元素
		
		//--成员变量
		Field field =class1.getDeclaredField("xixi");//返回变量名称为 field 的直接成员变量名称
		Field field2= class1.getField("xxixi");//返回变量名称包括父元素的成员变量
		Field[] fields=class1.getDeclaredFields();//返回所有直接的成员变量
		Field[] fields2 = class1.getFields();//返回所有的成员变量 包括父类进行继承的变量
		//--成员方法
		Method method = class1.getDeclaredMethod("xx", Integer.class);//返回名称为xx 参数为后面的变长数组的直接成员方法
		Method method2 = class1.getMethod("x", Integer.class);//上面方法 处理继承版
		//----判断方法
		boolean b = class1.isArray();
		class1.isAnnotation();
		class1.isAnnotationPresent(hehehe.class);//如果类中存在 这个借口返回true
		class1.isAnonymousClass();//?????当底层类是匿名类的时候返回 true
		class1.isAssignableFrom(class2);//返回 class1 是否和 class2实现的借口相同 或者是他的父类
		class1.isInstance(new Integer(12));//返回class1 是否和 传入的对象！！！！ 赋值兼容
		class1.isInterface();//是否是接口		
		//--
		class1.getModifiers();//返回类类型 public或者其他
	}
	//classLoadder --class类的底层
	public void methodForClassLoad(){}
	//---java.lang.reflect---java的反射包
	public void methodForRelect() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		Class<?> class1 = this.getClass();
		//AccessibleObject是 Method Fielt Construction的一个父类-都实现了此类的方法
		AccessibleObject accessibleObject = null;
		accessibleObject.isAnnotationPresent(hehehe.class);//判断这个类是否实现了hehehe这个接口
		accessibleObject.getAnnotation(hehehe.class);
		accessibleObject.getAnnotations();
		accessibleObject.setAccessible(true);//!!!---设置当前东西的访问性--- 设置为true的时候将可以实现对私有变量的
		//accessibleObject.setAccessible(new String(){"1"}, flag);
		//construction 注解类型---  注解表示构造方法生成的类型
		Constructor<?> constructor = (Constructor<Integer>) new Integer(12).getClass().getConstructor(Integer.class);
		constructor=class1.getConstructor(Integer.class,String.class);
		//---有关注解的方法---继承自父类
			//特殊的注解方法
		Annotation[][] annotation = constructor.getParameterAnnotations();//返回二维数组 第一维表示构造函数 第二位表示 注释类型--因为一个类可能有多个构造函数
		Annotation[] annotations3=constructor.getAnnotations();
		constructor.getDeclaringClass();//表明生成这个对象所对应的类
		constructor.getName();//	返回构造函数的名称
		//---构造函数参数
		Class<?>[] class1s = constructor.getParameterTypes();//返回由构造函数的参数组成的数组
		//直接调用
		Integer integer =(Integer) constructor.newInstance(12);//使用构造方法创造一个新的实例
		//field -- 成员变量反射类----这个参数必须通过 class类进行加载加载之后才能对其操作--因为要保证他有意义
		Field field = class1.getField("heheh");
		Field[] file=class1.getFields();//获得参数数组
		field.get(new ThisisCeshe());//返回object 传入一个得出field对象的class的实例才能对其使用 取出实例中的对应的field对象 --存在基本类型的那一坨方法
		field.getType();//返回一个class 对象表明这个字段的类型
		field.getName();//返回这个字段的名字
		field.set(new Integer(12), 123);//在前一个对象中 加入 后一个变量到field指定的变量上 --存在基本类型的那一坨方法
		int a=field.getModifiers();//返回参数类型--public或者其他
		//method --方法
		Method method = class1.getMethod("methodForClassLoad", null);//获得class类中的method方法
		//---反射相关的和上面的相同
		Class<?> class2 = method.getDeclaringClass();//返回这个方法类的对象
		String name = method.getName();//返回方法名称
		Annotation[][] annotations = method.getParameterAnnotations();//返回一个注解的二维数组 --同上面
		Annotation[] annotations2=method.getAnnotations();
		Class<?>[] class3 = method.getParameterTypes();//返回参数数组
		Class<?> class4 = method.getReturnType();//返回返回值数组
		int count=method.getParameterCount();//返回参数的数量
		Parameter[] parameters=method.getParameters();//返回参数列表
		parameters[0].getName();
		parameters[0].getType();//返回类型的class数组
		//参数类型没有注入 参数
		method.invoke(new ThisisCeshe(), null);//类似 FIeld的get方法--调用指定的实例的一个此method指定的方法
		int aa = class1.getModifiers();//返回参数类型表示方法
		//Array 反射类
		//创建一个第二个参数是边长参数的组 第一个参数是指定类型的数组
		Array[][] arrays=(Array[][]) Array.newInstance(Integer.class, 100,100);
		Array.get(arrays, 0);//返回制定对象索引的值 注意只能返回一维 并且返回的对象是object类型---相关  函数还有getint等基本类型
		Array.set(arrays, 0, new Integer(12));//将指定的类型传递到数组指定的位置中
		//Annotation
	}
}
@interface hehehe{
	String value() default "";
}

class myclassLoad extends ClassLoader{
	//BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，
	//Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
	//App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。
	//4）Custom ClassLoader
	//属于应用程序根据自身需要自定义的ClassLoader，如tomcat、jboss都会根据j2ee规范自行实现ClassLoader
	//加载过程中会先检查类是否被已加载，检查顺序是自底向上，从Custom ClassLoader到BootStrap ClassLoader逐层检查，
	//只要某个classloader已加载就视为已加载此类，保证此类只所有ClassLoader加载一次。而加载的顺序是自顶向下
	//，也就是由上层来逐层尝试加载此类。
	@Override
	protected Class<?> findClass(String arg0) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(arg0);
	}
}