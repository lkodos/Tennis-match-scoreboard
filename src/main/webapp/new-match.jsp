<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New match</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main>
    <div class="center-container">
        <form action="${pageContext.request.contextPath}/new-match" method="post">

            <label for="player1">Player one</label>
            <input type="text" name="player1" value="${player1}" id="player1">
            <c:if test="${not empty errors}">
                <div class="error">${errors.player1}</div>
            </c:if>

            <label for="player2">Player two</label>
            <input type="text" name="player2" value="${player2}"  id="player2">
            <c:if test="${not empty errors}">
                <div class="error">${errors.player2}</div>
            </c:if>
            <c:if test="${not empty errors}">
                <div class="error">${errors.equalsNames}</div>
            </c:if>

            <button type="submit">Start</button>
        </form>
    </div>
</main>
</body>
</html>