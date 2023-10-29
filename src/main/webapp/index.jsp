<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="spw4.connectfour.ConnectFour, spw4.connectfour.Color" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connect Four Game</title>
</head>
<body>
<h1>Connect Four Game Board</h1>

<%
    boolean colorSelected = false; // Assume the color is not selected
    if(request.getParameter("color") != null){
        colorSelected = true; // If a color parameter is passed, consider it as selected
    }
%>

<% if(!colorSelected) { %>
<form id="colorPickerForm" action="${pageContext.request.contextPath}/SetPlayerColor" method="POST">
    <h2>Choose Your Color:</h2>
    <input type="radio" name="color" value="RED" id="red" required>
    <label for="red">Red</label><br>
    <input type="radio" name="color" value="YELLOW" id="yellow">
    <label for="yellow">Yellow</label><br><br>
    <button type="submit">Start Game</button>
</form>
<% } else { %>
<p>You've already chosen your color. The game will start shortly...</p>
<%-- You can add a loading message or direct the user to the game page here --%>
<% } %>

<!-- Game Board Form -->
<form id="moveForm" action="${pageContext.request.contextPath}/ConnectFour" method="POST">
    <label for="column">Enter column (1-7):</label>
    <input id="column" type="number" name="column" min="1" max="7">
    <button type="submit">Place Token!</button>
</form>

<div id="gameBoard">
    <!-- This is where the board will be displayed -->
    <pre>
        <%= request.getAttribute("boardState") %>
    </pre>
</div>

</body>
</html>
