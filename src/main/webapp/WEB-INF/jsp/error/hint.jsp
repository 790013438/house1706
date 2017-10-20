<%@ page pageEncoding="utf-8"%>
<%
	String basePath = 
			request.getScheme() + "://" + 
			request.getServerName() + ":" + 
			request.getServerPort() + 
			request.getContextPath() + "/";
%>
<!doctype html>
<html>
	<head>
		<base href="<%= basePath%>">
		<meta charset="utf-8">
	</head>
	<body>
		<h1>Shit!!!</h1>
		<a href="home">返回首页</a>
	</body>
</html>