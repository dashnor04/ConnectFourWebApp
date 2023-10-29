package spw4.connectfour;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SetPlayerColorServlet", value = "/SetPlayerColor")
public class SetPlayerColorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String color = req.getParameter("color");

        if (color != null && !color.isEmpty()) {
            // Store the selected color in session
            req.getSession().setAttribute("playerColor", Color.valueOf(color));
            resp.sendRedirect(req.getContextPath() + "/ConnectFour");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Color parameter is missing");
        }
    }
}