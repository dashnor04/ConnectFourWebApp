package spw4.connectfour;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnectFourServlet", value = "/Connect-Four")
public class ConnectFourServlet extends HttpServlet {
    private String message;
    private ConnectFour game;

    public void init() {
        game = new ConnectFour();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String inputColor = req.getParameter("color");
        game.setupColor(inputColor);
        game.initialize();
        System.out.println(game);

        while (!game.isOver()) {
            System.out.print("command [1-7, (r)estart, (q)uit, (h)elp] > ");
            String inputColumn = req.getParameter("column");

            switch (inputColumn) {
                case "1", "2", "3", "4", "5", "6", "7":
                    if (game.getBoard().drop(Integer.parseInt(inputColumn), game.players[game.currentPlayer].getColor())) {
                        game.currentPlayer = (game.currentPlayer == 0) ? 1 : 0;
                    }
                    break;
                case "r":
                    game.initialize();
                    break;
                case "q":
                    System.out.println("Ok, bye.");
                    return;
                case "h":
                    game.printHelp();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.println(game.getBoard());
        }
    }

    public void destroy() {
    }
}