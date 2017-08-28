<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>W3Cschool教程(w3cschool.cn)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function WebSocketTest() {
		if ("WebSocket" in window) {
			alert("您的浏览器支持 WebSocket!");
			// 打开一个 web socket
			var ws = new WebSocket(
					"ws://localhost:8080/websocket/createWebSocket");
			ws.onopen = function() {
				ws.send("发送数据");
				alert("数据发送中...");
			};
			ws.onmessage = function(evt) {
				console.log(evt.data);
			};
			ws.onclose = function() {
				alert("连接已关闭...");
			};
		} else {
			alert("您的浏览器不支持 WebSocket!");
		}
	}
</script>
</head>
<body>
	<div id="sse">
		<a href="javascript:WebSocketTest()">运行 WebSocket</a>
	</div>
	<div id="message"></div>
</body>
</html>