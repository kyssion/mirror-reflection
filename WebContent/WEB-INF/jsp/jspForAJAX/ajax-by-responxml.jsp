<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
	function loadXMLDoc() {
		var xmlhttp;
		var txt, x, i;
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				xmlDoc = xmlhttp.responseXML;
				txt = "";
				xmlDoc = xmlhttp.responseXML;
				txt = "";
				for (i=0 ;i<xmlDoc.getElementsByTagName("book").length;i++){
					alert(i);
					var book = xmlDoc.getElementsByTagName("book").item(i);
					//循环遍历取出表单中的数据 nodevalue 和data  childNodes---子节点
					txt=txt+book.getElementsByTagName("name")[0].firstChild.nodeValue+"  "+book.getElementsByTagName("pc")[0].firstChild.data+"<br>";
				}
				 document.getElementById("myDiv").innerHTML=txt;
				 
			}
				alert(xmlhttp.readyState + "  " + xmlhttp.status);
			
		}
		xmlhttp.open("GET", "books.xml", true);
		xmlhttp.send();
	}
</script>
</head>

<body>

	<h2>我收藏的 CD :</h2>
	<div id="myDiv"></div>
	<button type="button" onclick="loadXMLDoc()">获取我的 CD</button>

</body>
</html>