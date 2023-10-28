package spw4.connectfour;

import java.util.Scanner;

public class ConnectFour {

    private final static int BOARD_HEIGHT = 6, BOARD_WIDTH = 7;

    static Player[] players;

    private Board board;

    int currentPlayer = 0;

    public ConnectFour() {
        board = new Board();
        Player player1 = new Player();
        Player player2 = new Player();
        players =  new Player[2];
        players[0] = player1;
        players[1] = player2;

    }

    public void initialize() {
        board = new Board();
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board.setValueAt(i, j, Color.WHITE);
            }
        }
    }

    public boolean isOver() {
        if (isBoardFull()) {
            System.out.println("Noone Won, game is a tie!");
            return true;
        }
       if (isWon()) {
           if (currentPlayer == 1) {
               System.out.println("Player1 won!");
           } else {
               System.out.println("Player2 won!");
           }
           return true;
       }
       return false;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board.getValueAt(row, col) == Color.WHITE)
                    return false;
            }
        }
        return true;
    }



    public boolean isWon() {
        // Check horizontally
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.WHITE &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+3)) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int row = 0; row <= BOARD_HEIGHT - 4; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board.getValueAt(row, col) != Color.WHITE &&
                        board.getValueAt(row, col) == board.getValueAt(row+1, col) &&
                        board.getValueAt(row, col) == board.getValueAt(row+2, col) &&
                        board.getValueAt(row, col) == board.getValueAt(row+3, col)) {
                    return true;
                }
            }
        }

        // Check diagonally (ascending)
        for (int row = 3; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.WHITE &
                        board.getValueAt(row, col) == board.getValueAt(row-1, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row-2, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row-3, col+3)) {
                    return true;
                }
            }
        }

        // Check diagonally (descending)
        for (int row = 0; row <= BOARD_HEIGHT - 4; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.WHITE &&
                        board.getValueAt(row, col) == board.getValueAt(row+1, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row+2, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row+3, col+3)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();


        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                switch (board.getValueAt(i, j)) {
                    case YELLOW:
                        boardString.append("Y ");
                        break;
                    case RED:
                        boardString.append("R ");
                        break;
                    case WHITE:
                        boardString.append(" ");
                        break;
                }
            }

            boardString.append("\n");
        }

        return  boardString.toString();
    }

    Board getBoard() {
        return this.board;
    }

    static void printHelp() {
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("-------------------");
        System.out.println("1-7 --> choose column");
        System.out.println("r --> restart game");
        System.out.println("q --> quit game");
        System.out.println("h --> show help");
    }

    void setupColor(String inputColor) {
        switch (inputColor) {
            case "RED":
                players[currentPlayer].setColor("RED");
                players[currentPlayer +1].setColor("YELLOW");
                break;
            case "YELLOW":
                players[currentPlayer].setColor("YELLOW");
                players[currentPlayer +1].setColor("RED");
                break;
        }
    }

    void run_game() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Player 1 choose your color! (available: RED, YELLOW)");
        input = scanner.nextLine();
        ConnectFour game = new ConnectFour();
        game.setupColor(input);
        //first player is first index in player array
        game.initialize();
        System.out.println(game);

        while (!isOver()) {
            System.out.print("command [1-7, (r)estart, (q)uit, (h)elp] > ");
            input = scanner.nextLine();

            switch (input) {
                case "1", "2", "3", "4", "5", "6", "7":
                    if (getBoard().drop(Integer.parseInt(input), players[currentPlayer].getColor())) {
                        currentPlayer = (currentPlayer == 0) ? 1 : 0;
                    }
                    break;
                case "r":
                    initialize();
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
            System.out.println(board);
        }
    }

}