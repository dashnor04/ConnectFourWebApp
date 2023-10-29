package spw4.connectfour;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnectFourServlet", value = "/ConnectFour")
public class ConnectFourServlet extends HttpServlet {
    private ConnectFour game;

    private Color currentColor = Color.RED;

    @Override
    public void init() throws ServletException {
        game = new ConnectFour();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Forward the request to the JSP for initial rendering
        request.setAttribute("boardState", game.getBoard().toString());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        currentColor = (Color) request.getSession().getAttribute("playerColor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String columnParam = req.getParameter("column");
        System.out.println(currentColor.toString());
        System.out.println(game.isOver());

        if (columnParam != null && !columnParam.isEmpty()) {
            try {
                int column = Integer.parseInt(columnParam);
                game.getBoard().drop(column-1, currentColor);

                if (game.isOver()) {
                    req.setAttribute("gameOver", true);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }

                // Forward the request back to the JSP to render the updated board
                req.setAttribute("color", currentColor);
                req.setAttribute("boardState", game.getBoard().toString());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);

                currentColor = (currentColor == Color.RED) ? Color.YELLOW  : Color.RED;
            } catch (NumberFormatException | ServletException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid column value");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Column parameter is missing");
        }
    }

    public void destroy() {
    }
}