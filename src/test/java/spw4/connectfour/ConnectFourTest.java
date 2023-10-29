package spw4.connectfour;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConnectFourTest {

    private final static int Board_HEIGHT = 6, BOARD_WIDTH = 7;

    ConnectFour game;
    //initializes every Tet with an empty board(white)
    @BeforeEach
    public void beforeEach() {
        game = new ConnectFour();
        game.initialize();
    }

    @Test
    public void testConstr() {
        assertEquals(0, game.currentPlayer);
        assertNotNull(game.players);
        assertNotNull(game);

    }
    @Test
    public void checkInitialize() {
        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                assertEquals(Color.WHITE, game.getBoard().getValueAt(row, col));
            }
        }
    }

    @Test
    void testToStringEmptyBoard() {
        Color[][] testArray = new Color[6][7];

        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                testArray[row][col] = Color.WHITE;
            }
        }

        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                assertEquals(testArray[row][col], game.getBoard().getValueAt(row, col));
            }
        }
    }

    @Test
    void testToStringFullBoard() {
        Color[][] testArray = new Color[6][7];

        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                testArray[row][col] = Color.RED;
            }
        }

        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                game.getBoard().setValueAt(row, col, Color.RED);
            }
        }

        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                assertEquals(testArray[row][col].toString(), game.getBoard().getValueAt(row, col).toString());
            }
        }
    }

    @Test
    void testIsOver() {
        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                game.getBoard().setValueAt(row, col, Color.RED);
            }
        }

        assertTrue(game.isOver());
    }

    @Test
    void testCheckHorizontally() {
        game.getBoard().setValueAt(0,1, Color.RED);
        game.getBoard().setValueAt(0,2, Color.RED);
        game.getBoard().setValueAt(0,3, Color.RED);
        game.getBoard().setValueAt(0,4, Color.RED);
        assertTrue(game.checkHorizontally());
    }

    @Test
    void testCheckVertically() {
        game.getBoard().setValueAt(0,0, Color.RED);
        game.getBoard().setValueAt(1,0, Color.RED);
        game.getBoard().setValueAt(2,0, Color.RED);
        game.getBoard().setValueAt(3,0, Color.RED);
        assertTrue(game.checkVertically());
    }
    @Test
    void testCheckDiagonallyAsc() {
        game.getBoard().setValueAt(0,0, Color.RED);
        game.getBoard().setValueAt(1,1, Color.RED);
        game.getBoard().setValueAt(2,2, Color.RED);
        game.getBoard().setValueAt(3,3, Color.RED);
        assertTrue(game.checkDiagonallyAsc());
    }
    @Test
    void testCheckDiagonallyDesc() {
        game.getBoard().setValueAt(0,3, Color.RED);
        game.getBoard().setValueAt(0,2, Color.RED);
        game.getBoard().setValueAt(0,1, Color.RED);
        game.getBoard().setValueAt(0,0, Color.RED);
        assertTrue(game.checkHorizontally());
    }

    //checks if empty Board is not won
    @Test
    void testisWonFalse() {
        assertFalse(game.isWon());
    }

    @Test
    void testIsWonHorizontally() {
        game.getBoard().setValueAt(0,1, Color.RED);
        game.getBoard().setValueAt(0,2, Color.RED);
        game.getBoard().setValueAt(0,3, Color.RED);
        game.getBoard().setValueAt(0,4, Color.RED);
        assertTrue(game.checkHorizontally());
    }

    @Test
    void testIsWonVertically() {
        game.getBoard().setValueAt(0,0, Color.RED);
        game.getBoard().setValueAt(1,0, Color.RED);
        game.getBoard().setValueAt(2,0, Color.RED);
        game.getBoard().setValueAt(3,0, Color.RED);
        assertTrue(game.checkVertically());
    }

    @Test
    void testIsWonDiagonallyAsc() {
        game.getBoard().setValueAt(0,0, Color.RED);
        game.getBoard().setValueAt(1,1, Color.RED);
        game.getBoard().setValueAt(2,2, Color.RED);
        game.getBoard().setValueAt(3,3, Color.RED);
        assertTrue(game.checkDiagonallyAsc());
    }

    @Test
    void testIsWonDiagonallyDesc() {
        game.getBoard().setValueAt(0,3, Color.RED);
        game.getBoard().setValueAt(0,2, Color.RED);
        game.getBoard().setValueAt(0,1, Color.RED);
        game.getBoard().setValueAt(0,0, Color.RED);
        assertTrue(game.checkHorizontally());
    }
}

