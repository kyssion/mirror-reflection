package a_java基础知识点;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 源注解
 * @target-- 		声明注解的对象范围  
 * 				construction	构造函数 
 * 				FIeld 			域
 * 				LOCAL_VARIABLE 	用于描述局部变量
 * 				METHOD			用于描述方法
 * 				PACKAGE			用于描述包
 * 				PARAMETER		用于描述参数
 * 				TYPE			用于描述类、接口(包括注解类型) 或enum声明
 * @Retention-- 	声明注解的保留范围
 * 				SOURCE			在源文件中有效（即源文件保留）
 *				CLASS			在class文件中有效（即class保留）
 *　　			RUNTIME			在运行时有效（即运行时保留）
 * @Documented --注解的文档的化 
			  用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。
 * @Inherited --注解的继承化   元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了
			  @Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。				
 * 注意：@Inherited annotation类型是被标注过的class的子类所继承。类并不从它所实现的接口继承annotation，方法并不从它所重载的方法继承annotation。
　　当@Inherited annotation类型标注的annotation的Retention是RetentionPolicy.RUNTIME，则反射API增强了这种继承性。如果我们使用
   java.lang.reflect去查询一个@Inherited annotation类型的annotation时，反射代码检查将展开工作：检查class和其父类，直到发现指定
   的annotation类型被发现，或者到达类继承结构的顶层。
 * 
 * */
public class g_注解 {}
//1.系统内置注解
class 内置注解 extends Object{
	//1. overide 注解 ---用于修饰此方法覆盖了父类的方法
	@Override
	public String toString() {return super.toString();}
	//2. @Deprecated---用于修饰已经过时的方法--编译器会对使用他 或者 子类继承或者重写的时候发出警告
	@Deprecated
	public void deprecateMethod(){}
	//3. ---用于对警告进行忽略 --
	/*
	 * ------------------------警告参数
 *  							1.deprecation：使用了不赞成使用的类或方法时的警告；
　　　　							2.unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型;
　　　　							3.fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
　　　　							4.path：在类路径、源文件路径等中有不存在的路径时的警告;
　　　　							5.serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告;
　　　　							6.finally：任何 finally 子句不能正常完成时的警告;
　　　　							7.all：关于以上所有情况的警告。 
	 * */
	@SuppressWarnings("all")
	public void  suporessWarning(){}
}
//自定义注解  --
//-----使用元注解--注解的注解 用于自定义注解
//！！！！！当注解中存在数据的时候可以使用{}括起来 从而可以同时为注解设置多个属性值
@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE})//表明注解所属的对象的范围
/*
 *@Target说明了Annotation所修饰的对象范围
 *			1.CONSTRUCTOR:			用于描述构造器
　　　　		2.FIELD:				用于成员变量
　　　　		3.LOCAL_VARIABLE:		用于描述局部变量
　　　　		4.METHOD:				用于描述方法
　　　　		5.PACKAGE:				用于描述包
　　　　		6.PARAMETER:			用于描述参数
　　　　		7.TYPE:					用于描述类、接口(包括注解类型) 或enum声明　 
 * 
 */
@Retention(RetentionPolicy.CLASS)//声明注解保留的生命周期
/*	属性----
 * 		-----RetentionPolicy+
 *　			1.SOURCE:在源文件中有效（即源文件保留） 		源代码注解
　　　　		2.CLASS:在class文件中有效（即class保留） 	编译注解
　　　　		3.RUNTIME:在运行时有效（即运行时保留） 		运行时注解---自动注入运行文件
 * 
 * 
 */
@Documented
//　@Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，
//因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。
@Inherited
//声明注解类的可继承性---注意这个方法的子类只能是使用使用 extends继承的  并且只用在类级别定义注解才能被继承  方法上的不能进行继承的才能使用
//@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
//当@Inherited annotation类型标注的annotation的Retention是RetentionPolicy.RUNTIME，则反射API增强了这种继承性。如果我们使用java.lang.reflect去查询一个@Inherited annotation类型的annotation时，
//反射代码检查将展开工作：检查class和其父类，直到发现指定的annotation类型被发现，或者到达类继承结构的顶层。
@interface 自定义注解{
	//自定义注解的曾原变量必须无参数无异常 并且成员函数必须使用public 或者 default --默认方法 没有使用方法的时候
	public enum Color{RED,YELLOW}
	public String value() default "";//注意非基本元素默认值不能是 null 必须加上默认属性否则会报错
	//当成员只有一个的时候 必须定义为 value 并且在使用的时候可以省略 value="值"直接省略
	//可以定义多个值
	public Color[] getColor() default {Color.RED,Color.YELLOW};//声明方法中的参数类型 --就是注解中的变量
	/*
	 * 		第一,只能用public或默认(default)这两个访问权修饰
　　			第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean基本数据类型和 
				String,Enum,Class,annotations等数据类型,以及这一些类型的数组
　　			第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号
	 */
}


