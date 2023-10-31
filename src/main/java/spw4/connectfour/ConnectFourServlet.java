package spw4.connectfour;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnectFourServlet", value = {"/ConnectFour", "/RestartGame"})
public class ConnectFourServlet extends HttpServlet {
    private ConnectFour game;
    private Color currentColor = Color.RED;

    @Override
    public void init() throws ServletException {
        try {
            game = new ConnectFour();
            game.initialize();
        } catch (IndexOutOfBoundsException e) {
            throw new ServletException("Initialization failed", e);
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("RestartGame")) {
            game = new ConnectFour(); // Restart the game by creating a new instance
            currentColor = Color.RED; // Reset the current color to the default

            // Forward the request to color selection for re-selection
            request.getSession().removeAttribute("playerColor"); // Clear the previous color selection
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return; // Exit method after forwarding for re-selection
        }

        // Check if the color is already selected
        boolean colorSelected = request.getSession().getAttribute("playerColor") != null;

        if (colorSelected) {
            // Color is selected, proceed with the game
            currentColor = (Color) request.getSession().getAttribute("playerColor");
            request.setAttribute("color", currentColor);
            request.setAttribute("boardState", game.getBoard());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // Color is not selected, prompt for selection
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String columnParam = req.getParameter("column");
        String colorParam = req.getParameter("color");

        if (colorParam != null && !colorParam.isEmpty()) {
            // Store the selected color in session
            req.getSession().setAttribute("playerColor", Color.valueOf(colorParam));
            resp.sendRedirect(req.getContextPath() + "/ConnectFour");
        } else if (columnParam != null && !columnParam.isEmpty()) {
            try {
                int column = Integer.parseInt(columnParam);
                game.getBoard().drop(column - 1, currentColor);

                if (game.isOver()) {
                    req.setAttribute("winner", currentColor);
                    req.setAttribute("gameOver", true);
                }

                // Forward the request back to the JSP to render the updated board
                req.setAttribute("color", currentColor);
                req.setAttribute("boardState", game.getBoard().toString());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);

                currentColor = (currentColor == Color.RED) ? Color.YELLOW : Color.RED;
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid column value");
            }
        } else {
            game.initialize();
            game.setCurrentPlayer(1);
            req.setAttribute("boardState", game.getBoard());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    public void destroy() {
    }
}
