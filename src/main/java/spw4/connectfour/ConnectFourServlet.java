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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String columnParam = req.getParameter("column");
        currentColor = (Color) req.getSession().getAttribute("playerColor");
        System.out.println(currentColor.toString());

        if (columnParam != null && !columnParam.isEmpty()) {
            try {
                int column = Integer.parseInt(columnParam);
                game.getBoard().drop(column-1, currentColor);

                // Forward the request back to the JSP to render the updated board
                req.setAttribute("color", currentColor);
                req.setAttribute("boardState", game.getBoard().toString());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
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