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
	Cookie[] cookies=request.getCookies();
	for (Cookie c : cookies){
		c.getName();//获得制定cookie的名称
		c.getValue();//获得制定cookie的值
	}
%>
</body>
</html>