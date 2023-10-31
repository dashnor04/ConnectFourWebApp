<%@ page contentType="text/html;charset=UTF-8" %>
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
<% } %>

<% if(!colorSelected) { %>
<form id="colorPickerForm" action="${pageContext.request.contextPath}/ConnectFour" method="POST">
    <h3>Choose Your Color:</h3>
    <input type="radio" name="color" value="RED" id="red" required>
    <label for="red">Red</label><br>
    <input type="radio" name="color" value="YELLOW" id="yellow">
    <label for="yellow">Yellow</label><br><br>
    <button type="submit" >Start Game</button>
</form>
<% } %>


<% if(colorSelected) { %>
<form action="${pageContext.request.contextPath}/RestartGame" method="GET">
    <button type="submit" style="padding-bottom: 10px">Restart Game</button>
</form>
<% } %>

<!-- board representation -->
<%  if (request.getAttribute("boardState") != null) { %>


<% if (request.getAttribute("gameOver") == null || !(boolean) request.getAttribute("gameOver")) {%>
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
<% } %>

<div id="gameBoard" class="game-board">
    <%
        String boardState = request.getAttribute("boardState").toString();
        String[] rows = boardState.split("\\n"); // Split the string representation into rows
        for (String row : rows) {
    %>
    <div class="row">
        <%
            for (int i = 0; i < row.length(); i++) {
                // Iterate through each character in the row (representing each cell)
                if (row.charAt(i) == 'R' || row.charAt(i) == 'Y' || row.charAt(i) == ' ') {
                    char cell = row.charAt(i);
                    switch (cell) {
                        case 'R': %>
        <div class="cell">
            <!-- empty tag doesnt work in some browsers -->
            <div id="red-token"></div>
        </div>
        <% break;
            case 'Y': %>
        <div class="cell">
            <div id="yellow-token"></div>
        </div>
        <% break;
            default: %>
        <div class="cell">
            <div id="white-token"></div>
        </div>
        <% break;
        }
        }
        }
        %>
    </div>
    <% } %>
</div>
<% } %>

</body>
</html>
