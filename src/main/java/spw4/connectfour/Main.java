package spw4.connectfour;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        Scanner scanner = new Scanner(System.in);
        String input;
        game.initialize();
        System.out.println(game);

        while (!game.isOver()) {
            System.out.print("command [1-7, (r)estart, (q)uit, (h)elp] > ");
            input = scanner.nextLine();

            switch (input) {
                case "1", "2", "3", "4", "5", "6", "7":
                    if (game.getBoard().drop(Integer.parseInt(input)-1, game.getPlayers()[game.getCurrentPlayer()].getColor())) {
                        int currentPlayer = (game.getCurrentPlayer() == 0) ? 1 : 0;
                        game.setCurrentPlayer(currentPlayer);
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
            System.out.println(game.getBoard().toString());
        }
    }
}