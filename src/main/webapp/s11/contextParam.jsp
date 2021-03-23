<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Context parameter</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <c:if test="${reversedAdmin ne null}">
        <h1>Say hello to ${reversedAdmin}</h1>
    </c:if>
    <h1>Ask ${initParam.admin} for more details</h1>

    <p>
        Back <a href="/jees/index.html">home</a>
    </p>
</body>
</html>