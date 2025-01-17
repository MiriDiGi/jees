<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <h1>The greeter page</h1>

    <c:choose>
        <c:when test="${previous eq null}">    <!-- eq è come scrivere == -->
            <p>No information available on previous user name</p>
        </c:when>
        <c:when test="${previous eq ''}">
            <p>Nobody to say goodbye</p>
        </c:when>
        <c:otherwise>
            <p>Goodbye ${previous}</p>
        </c:otherwise>
    </c:choose>
    <c:if test="${user ne null}">   <!-- se non è uguale a null, user lo prende dalla session, posso dirgli esplicitamente lo scope specifico dove andarlo a cercare sessionScope in questo caso -->
        <p>Hello, ${user}</p>
    </c:if>
    <form action="greeter">
        <label>Set new user name <input name="user" placeholder="..." autofocus></label>  <!-- dato che non ho specificato mi chiama un get -->
        <button>OK</button>
    </form>
    <a href="greeter"><button>Reset</button></a>    <!-- bottone messo dentro all'ancor, parte una get per la risorsa greater SENZA PARAMETRI, questo termina la sessione -->
    <p>
        Back <a href="/jees/index.html">home</a>
    </p>
</body>
</html>