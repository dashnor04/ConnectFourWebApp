<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="spw4.connectfour.ConnectFour, spw4.connectfour.Color" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connect Four Game</title>
    <link rel="stylesheet" type="text/css" href="styles.css">

</head>

<body>
<h1>Connect Four Game</h1>

<%
    boolean colorSelected = request.getAttribute("color") != null; // Assume the color is not selected
    // If a color parameter is passed, consider it as selected
%>

<% if (request.getAttribute("gameOver") != null && (boolean) request.getAttribute("gameOver")) { %>
<h2>Game Over! <%= request.getAttribute("winner")%> Won</h2>
<form action="${pageContext.request.contextPath}/RestartGame" method="GET">
    <button type="submit">Restart Game</button>
</form>
<% } %>


<% if(!colorSelected) { %>
<form id="colorPickerForm" action="${pageContext.request.contextPath}/SetPlayerColor" method="POST">
    <h3>Choose Your Color:</h3>
    <input type="radio" name="color" value="RED" id="red" required>
    <label for="red">Red</label><br>
    <input type="radio" name="color" value="YELLOW" id="yellow">
    <label for="yellow">Yellow</label><br><br>
    <button type="submit" >Start Game</button>
</form>
<% } %>


<!-- Game Board Form -->
<form id="moveForm" action="${pageContext.request.contextPath}/ConnectFour" method="POST">
    <button type="submit" value="1" name="column" id="column1"> + </button>
    <button type="submit" value="2" name="column" id="column2"> + </button>
    <button type="submit" value="3" name="column" id="column3"> + </button>
    <button type="submit" value="4" name="column" id="column4"> + </button>
    <button type="submit" value="5" name="column" id="column5"> + </button>
    <button type="submit" value="6" name="column" id="column6"> + </button>
    <button type="submit" value="7" name="column" id="column7"> + </button>
</form>


<div id="gameBoard" >
    <!-- This is where the board will be displayed -->
    <pre>
        <%= request.getAttribute("boardState") %>
    </pre>
</div>

</body>
</html>
