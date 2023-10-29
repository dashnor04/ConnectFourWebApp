package spw4.connectfour;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConnectFourTest {

    private final static int Board_HEIGHT = 6, BOARD_WIDTH = 7;

    ConnectFour game;
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

    @Test void testToStringEmptyBoard() {
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
    void testIsOver() {
        for (int row=0; row < Board_HEIGHT; row++) {
            for (int col=0; col < BOARD_WIDTH; col++) {
                game.getBoard().setValueAt(row, col, Color.RED);
            }
        }

        assertTrue(game.isOver());
    }
}