<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<p>Hello, ${user}</p>
</body>
</html>