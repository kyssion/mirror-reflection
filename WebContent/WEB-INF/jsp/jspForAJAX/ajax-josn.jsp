<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<script>
			function loadXMLDoc() {
				
				var myxmlhttprequest;
				if(window.XMLHttpRequest) {
					myxmlhttprequest = new XMLHttpRequest();
				} else {
					myxmlhttprequest = new ActiveXObject("Microsoft.XMLHTTP");
				}
				myxmlhttprequest.onreadystatechange = function() {
					if(myxmlhttprequest.readyState == 4 && myxmlhttprequest.status == 200) {
						document.getElementById("myDiv").innerHTML = myxmlhttprequest.responseText;
						var js=myxmlhttprequest.responseText;
						//前端接受后端发来的json必须用eval解析！！！！！！  注意这个是用来解析  json字符串的！！！eval只接受字符串
						var obj = eval("(" + js + ")");
						//alert(js)
						document.getElementById("name").innerHTML = obj.name;
						document.getElementById("id").innerHTML = obj.id;
						
					}
					alert(myxmlhttprequest.readyState + " " + myxmlhttprequest.status);
				}
				myxmlhttprequest.open("GET", "Ceshi_json?time="+new Date().getTime(), true);
				myxmlhttprequest.send();

			}
		</script>
	</head>

	<body>

		<div id="myDiv">
			<h2>使用 AJAX 修改该文本内容</h2></div>
		<button type="button" onclick="loadXMLDoc()">修改内容</button>
		<div id="name"></div><br />
		<div id="id"></div><br />
	</body>

</html>