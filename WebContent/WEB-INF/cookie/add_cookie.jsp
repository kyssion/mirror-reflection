<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = new String("cookie");
	Cookie cookie = new Cookie("key",name);//创建一个cookie制定cookie的名称和他所对应的值
	cookie.setMaxAge(1000000);//设置cookie的超时时间
	response.addCookie(cookie);//向相应头中添加设置好的cookie
%>
</body>
</html>