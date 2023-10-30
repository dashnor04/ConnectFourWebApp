package spw4.connectfour;

import java.io.Serializable;
import java.util.Scanner;

public class ConnectFour implements Serializable {

    private final static int BOARD_HEIGHT = 6, BOARD_WIDTH = 7;
    //with the players array and currentPlayer variable we know whose turn it is
    private static Player[] players;
    private Board board;
    private int currentPlayer;

    public ConnectFour() {
        this.board = new Board();
        Player player1 = new Player();
        Player player2 = new Player();
        players =  new Player[2];
        players[0] = player1;
        players[1] = player2;

    }

    public void initialize() {
        currentPlayer = 0;
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Player 1 choose your color! (available: RED, YELLOW)");
        input = scanner.nextLine();
        setupColor(input);

        board = new Board();
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board.setValueAt(row, col, Color.BLANK);
            }
        }
    }

    public boolean isOver() {
        if (isBoardFull()) {
            System.out.println("Noone Won, game is a tie!");
            return true;
        }
       if (isWon()) {
           //when a player wins the game changes back to the loser's turn and then evaluates the win, so the
           //curren player has to be set back to the winner
           currentPlayer = (currentPlayer == 0) ? 1 : 0;
           if (currentPlayer == 1) {
               System.out.println(players[currentPlayer].getColor().toString() + "won!");
           } else {
               System.out.println(players[currentPlayer].getColor().toString() +" won!");
           }
           return true;
       }
       return false;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board.getValueAt(row, col) == Color.BLANK)
                    return false;
            }
        }
        return true;
    }


    public boolean checkHorizontally() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.BLANK &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row, col+3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVertically() {
        for (int row = 0; row <= BOARD_HEIGHT - 4; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board.getValueAt(row, col) != Color.BLANK &&
                        board.getValueAt(row, col) == board.getValueAt(row+1, col) &&
                        board.getValueAt(row, col) == board.getValueAt(row+2, col) &&
                        board.getValueAt(row, col) == board.getValueAt(row+3, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonallyDesc() {
        for (int row = 3; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.BLANK &
                        board.getValueAt(row, col) == board.getValueAt(row-1, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row-2, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row-3, col+3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonallyAsc() {
        for (int row = 0; row <= BOARD_HEIGHT - 4; row++) {
            for (int col = 0; col <= BOARD_WIDTH - 4; col++) {
                if (board.getValueAt(row, col) != Color.BLANK &&
                        board.getValueAt(row, col) == board.getValueAt(row+1, col+1) &&
                        board.getValueAt(row, col) == board.getValueAt(row+2, col+2) &&
                        board.getValueAt(row, col) == board.getValueAt(row+3, col+3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWon() {
        return checkHorizontally() ||
                checkVertically() ||
                checkDiagonallyAsc() ||
                checkDiagonallyDesc();
    }

    public Board getBoard() {
        return this.board;
    }

    static void printHelp() {
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("-------------------");
        System.out.println("1 - 7 --> choose column");
        System.out.println("r --> restart game");
        System.out.println("q --> quit game");
        System.out.println("h --> show help");
        System.out.println("\n");
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
            default:
                System.out.println("Color not available");
                initialize();
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int val) {
        currentPlayer = val;
    }
}