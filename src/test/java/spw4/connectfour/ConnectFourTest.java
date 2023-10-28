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
        for (int i=0; i < Board_HEIGHT; i++) {
            for (int j=0; j < BOARD_WIDTH; j++) {
                assertEquals(Color.WHITE, game.getBoard().getValueAt(i, j));
            }
        }
    }

    @Test void testToStringEmptyBoard() {
        Color[][] testArray = new Color[6][7];

        for (int i=0; i < Board_HEIGHT; i++) {
            for (int j=0; j < BOARD_WIDTH; j++) {
                testArray[i][j] = Color.WHITE;
            }
        }

        for (int i=0; i < Board_HEIGHT; i++) {
            for (int j=0; j < BOARD_WIDTH; j++) {
                assertEquals(testArray[i][j], game.getBoard().getValueAt(i, j));
            }
        }
    }
}