package spw4.connectfour;

public class ConnectFour {

    //avoid magic numbers
    private final static int HEIGHT = 6, WIDTH = 7;
    private final static char BLANK = '.';
    private final Player player1;
    private final Player player2;

    Board board;


    public ConnectFour() {
        board = new Board();
        player1 = new Player("player1", Color.RED);
        player2 = new Player("player2", Color.YELLOW);
    }
    public ConnectFour(Player p1, Player p2) {
        board = new Board();
        player1 = p1;
        player2 = p2;
    }

    public void initialize() {
        board = new Board();
        for (int i=0; i < HEIGHT; i++) {
            for (int j=0; j < WIDTH; j++) {
                board.grid[i][j] = Color.WHITE;
            }
        }
    }

    public boolean isOver() {
        return false;
    }

    public boolean isWon() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();


        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                switch (board.grid[i][j]) {
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

}