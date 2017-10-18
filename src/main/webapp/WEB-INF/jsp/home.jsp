<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>Hello, ${name}!</h1>
		<ul>
			<c:forEach items="${fruits}" var="fruit">
				<li>${fruit}</li>
			</c:forEach>
		</ul>
	</body>
</html>