<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style type="text/css">
body {
	background-color: ${colour};
}
</style>
<body>
	<h1>Welcome, ${user}!</h1>
	<p>Il tuo colore preferito è ${colour}</p>
	<p>Your colours are: ${colours}</p>
	
	<ol>
	<c:forEach var="color" items="${colours}">
		<li>
			${color}
		</li>
	</c:forEach>
	</ol>

</body>
</html>