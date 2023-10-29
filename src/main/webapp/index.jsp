<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connect Four Game</title>
</head>
<body>
<h1>Connect Four Game</h1>
<form action="${pageContext.request.contextPath}/Connect-Four" method="post">
    Choose your Color:
    <label>
        <input type="text" name="color">
    </label> <br/>
    Enter column (1-7): <label>
    <input type="number" name="column" min="0" max="6">
    </label> <br />
    <input type="submit" value="Drop Piece"> <br/>
    <p> ${game.getBoard()}</p>
</form>
</body>
</html>
