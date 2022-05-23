<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- direttiva taglib è paragonabile a quando usiamo in import, ci serve per il c:if -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I want to greet you!</title>
</head>
<body>
	<h1>I want to greet you!</h1>
	<form action="/jees/ese/greeter">
		<input name="user" placeholder= "Your name" value="${user}">
		<button>
		Ok
		</button>
	</form>
	<c:if test="${user != null}">
	<p>Hello, ${user}</p>
	</c:if>
	
	<hr>
	
	<c:choose>
		<c:when test="${user != null}">   <!-- valuta tutti i when fino a che non ho successo -->
			<p>${user}, how are you?</p>
		</c:when>
		<c:otherwise>
			<p>Who are you?</p>   <!-- se non metto il nome esce questo -->
		</c:otherwise>
	</c:choose>
	
</body>
</html>