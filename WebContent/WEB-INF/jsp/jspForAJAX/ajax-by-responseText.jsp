<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			} else {
				alert(xmlhttp.readyState + "  " + xmlhttp.status);
			}
		}
		//向后台的servlet传输数据
		/* xmlhttp.open("POST","Myajax_by_requesttext",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("fname=Henry&lname=Ford");  */
		//使用get方法发送请求     解决 浏览器通过url地址相同的缓存问题
		xmlhttp.open("GET", "Myajax_by_requesttext?a="+new Date().getTime(),
				true);
		xmlhttp.send();
	}
</script>
</head>
<body>

	<div id="myDiv">
		<h2>使用 AJAX 修改该文本内容</h2>
	</div>
	<button type="button" onclick="loadXMLDoc()">修改内容</button>

</body>
</html>