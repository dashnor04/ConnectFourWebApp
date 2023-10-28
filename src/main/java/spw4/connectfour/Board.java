package spw4.connectfour;

import java.util.Arrays;

public class Board {

    private int BOARD_HEIGHT = 6;
    private int BOARD_WIDTH = 7;
    Color[][] grid;

    public Board() {
        this.grid = new Color[6][7];
        for (Color[] row : grid) {
            Arrays.fill(row, Color.WHITE);
        }
    }

    //start at the bottom of the selected column
    public boolean drop(int column, Color color) {
        int i=BOARD_HEIGHT-1;
        while (this.grid[i][column-1] != Color.WHITE)
            i--;
        if (i >= 0) {
            grid[i][column-1] = color;
            return true;
        } else {
            System.out.println("Column is full");
            return false;
        }
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
}
