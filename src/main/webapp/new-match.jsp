<%@ page contentType="text/html;charset=UTF-8" %>
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
            <input type="text" name="player1" id="player1">
            <label for="player2">Player two</label>
            <input type="text" name="player2" id="player2">
            <button type="submit">Start</button>
        </form>
    </div>
</main>
</body>
</html>