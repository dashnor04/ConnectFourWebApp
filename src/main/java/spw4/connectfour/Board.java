package spw4.connectfour;

public class Board {

    private static final int BOARD_HEIGHT = 6;
    private static final int BOARD_WIDTH = 7;
    private final Color[][] grid;

    public Board() {
        this.grid = new Color[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                grid[i][j] = Color.BLANK; // Initialize with a default color
            }
        }
    }

    //start at the bottom of the selected column
    public boolean drop(int col, Color token) {
        if (col < 0 || col >= BOARD_WIDTH) {
            System.out.println("Invalid column! Choose a column within the board range.");
            return false;
        }

        for (int row = BOARD_HEIGHT - 1; row >= 0; row--) {
            if (grid[row][col] == Color.BLANK) {
                grid[row][col] = token;
                return true;
            }
        }
        System.out.println("Column is full! Please choose another column.");
        return false;
    }

    @Override
    public String toString() {
        StringBuilder gridString = new StringBuilder();

        for (int i=0; i<BOARD_HEIGHT; i++) {
            for (int j=0; j<BOARD_WIDTH; j++) {
                switch (grid[i][j]) {
                    case BLANK:
                        gridString.append("|   ");
                        break;
                    case RED:
                        gridString.append("| R ");
                        break;
                    case YELLOW:
                        gridString.append("| Y ");
                        break;
                }
            }
            gridString.append("|\n");
            gridString.append("+---+---+---+---+---+---+---+\n");
        }
        return gridString.toString();
    }

    Color getValueAt(int col, int row) {
        return grid[col][row];
    }

    void setValueAt(int col, int row, Color color) {
        grid[col][row] =  color;
    }
}
