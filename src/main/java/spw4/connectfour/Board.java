package spw4.connectfour;

import java.util.Arrays;

public class Board {

    private static final int BOARD_HEIGHT = 6;
    private static final int BOARD_WIDTH = 7;
    private final Color[][] grid;

    public Board() {
        this.grid = new Color[6][7];
        for (Color[] row : grid) {
            Arrays.fill(row, Color.WHITE);
        }
    }

    //start at the bottom of the selected column
    public boolean drop(int col, Color token) {
        if (col < 0 || col >= BOARD_WIDTH) {
            System.out.println("Invalid column! Choose a column within the board range.");
            return false;
        }

        for (int row = BOARD_HEIGHT - 1; row >= 0; row--) {
            if (grid[row][col] == Color.WHITE) {
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

        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                switch (grid[i][j]) {
                    case WHITE:
                        gridString.append(" ");
                        break;
                    case RED:
                        gridString.append("R");
                        break;
                    case YELLOW:
                        gridString.append("Y");
                        break;
                }
            }
            gridString.append("\n");
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
