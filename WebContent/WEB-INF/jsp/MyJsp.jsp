<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
        jsp相关标签命令的使用方法
					jsp指令标识
		一.page指令--为整个页面的定义的属性
				1.language	-定义jsp页面使用的语言目前只能使用java
				2.extends	-指jsp页面(tomcat服务器在后台编译成的java类的继承类)没用
				3.import	------引用包
				4.pageEncoding- 用于指定文件的编码也就是页面的编码格式 -使用utf-8
				5.contentType-指定页面的mine类型和字符编码用于显示网页内容
				6.sesion - 指定这个页面是否支持session属性
				7.buffer- 指定页面使用out属性输出流缓冲区的大小
				8.autoflush- 指定当页面的缓冲区满的时候是否自动的输出缓冲区的内容
				9.iserrorpage- 定义页面是否是一个用来处理错误的页面
				10.errorPage-用来指定处理当前页面错误的页面
		二.include指令 <%@ include file="xxx"%> 讲一个页面导入进来]
		三.taglib  <%@ taglib prefix="x" uri="" %> 加入第三方标签文件的位置 prefix表示前缀 uri表示标签文件存放的位置
		四.<%! %>-使用这个框住的表示全局变量 没有!-表示嵌入的代码脚本
 -->

<!-- jsp 七大动作指令   默认内置不用使用taglib 编译指令 -->
	<!-- 转发到hellow.jsp处 -->
	<jsp:forward page="hellow.jsp">
		<jsp:param value="123" name="sss" /><!-- 为url参数加入数值 -->
	</jsp:forward>
	<!-- 动态导入一个标签 -->
	<jsp:include page="MyJsp.jsp">
		<jsp:param value="sadf" name="sdf" /><!-- 在导入页面中使用 getparamet可以获取这个参数 -->
	</jsp:include>
	<!-- 创建一个javabean 实例 名字为123--  beanname + type(和class可以属性相同) ==id>-->
	<jsp:useBean id="myjsp" class="javaEE.Myjavabean" scope="session"><!-- 还存在两个属性beanname(完整类名)和type(bean类型)这两个等于class属性 -->
		<!--
				为添加的属性进行赋值
			name-表示一个在javabean范围内的对象实例-通常和javabean标签的id属性相同
			property- 	属性赋值-当使用*的时候 将会自动加request中的请求参数按照Javabean中的参数的名称意义对应的赋值
								当使用是一个字符串的时候就将会讲request中的和字符串相同的属性进行赋值
								当使用param属性的时候将会讲param字符串和request中相应的值进行匹配
								value 指定这个属性的默认值-不能喝param属性连用
		-->
		<jsp:setProperty property="" name="" param="" value="" />
	</jsp:useBean>
	<!-- 将名称为name中字符串的java的property参数的进行输出-->
	<jsp:getProperty property="" name="" />
	<!-- jsp九大内置对象 -->
	<%
		//javax.servlet.ServletContext 		--	application 	配置 tomcat服务器默认参数  getinitparament ---2资源共享 attribute
		//javax.servlet.ServletConfig		--	config 			获取jsp或者servlet的参数  方法getinitparameter
		//javax.servlet.jsp.jspwriter  		-- 	out				jsp页面的输入流
		//javax.servlet.jsp.pagecontext 	-- 	jsp				上下文
		//---session requrest responce javax.servlet.http.httpservlet....
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is my Jsp
</body>
</html>
