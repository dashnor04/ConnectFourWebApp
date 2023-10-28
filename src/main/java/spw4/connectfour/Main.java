package spw4.connectfour;

import java.util.*;
public class Main {

    private static int currentPlayer = 0;

    static Player[] players;

    static void switchTurn() {
        switch (currentPlayer) {
            case 0:
                currentPlayer = 1;
                break;
            case 1:
                currentPlayer = 0;
                break;

        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputColor = "";

        System.out.println("Player 1 choose your color! (available: RED, YELLOW)");
        inputColor = scanner.nextLine();
        players = new Player[2];
        Player p1 = new Player();
        Player p2 = new Player();
        players[0] = p1;
        players[1] = p2;
        ConnectFour game = new ConnectFour(p1, p2);
        switch (inputColor) {
            case "RED":
                players[currentPlayer].setColor("RED");
                players[currentPlayer+1].setColor("YELLOW");
            case "YELLOW":
                players[currentPlayer].setColor("YELLOW");
                players[currentPlayer+1].setColor("RED");;
        }

        ConnectFour ConnectFour = new ConnectFour();
        game.initialize();
        System.out.println(game);

        String inputToken = "";
        while (!game.isOver()) {
            System.out.print("command [1-7, (r)estart, (q)uit, (h)elp] > ");
            inputToken = scanner.nextLine();

            switch (inputToken) {
                case "1", "2", "3", "4", "5", "6", "7":
                    game.board.drop(Integer.parseInt(inputToken), players[currentPlayer].getColor());
                    switchTurn();
                    break;
                case "r":
                    game.initialize();
                    break;
                case "q":
                    System.out.println("Ok, bye.");
                    return;
                case "h":
                    printHelp();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.println(game);
        }

        System.out.println(game.isWon() ? "You win!!! :)" : "You lose. :(");
    }


    private static void printHelp() {
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("-------------------");
        System.out.println("1-7 --> choose column");
        System.out.println("r --> restart game");
        System.out.println("q --> quit game");
        System.out.println("h --> show help");
    }
}