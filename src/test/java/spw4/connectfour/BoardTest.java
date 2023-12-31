package spw4.connectfour;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    private static final int BOARD_HEIGHT = 6;
    private static final int BOARD_WIDTH = 7;
    private Board board;

    @BeforeEach
    public void beforeEach() {
        board = new Board();
    }

    @Test
    public void checkBoardNotNull() {
        assertNotNull(board);
    }

    @Test
    public void checkEmptyBoardOnInit() {
        Color[][] white_array = new Color[6][7];
        for (int i=0; i<BOARD_HEIGHT; i++) {
            for (int j=0; j<BOARD_WIDTH; j++) {
                white_array[i][j] = Color.BLANK;
            }
        }

        for (int i=0; i<BOARD_HEIGHT; i++) {
            for (int j=0; j<BOARD_WIDTH; j++) {
                assertEquals(white_array[i][j], board.getValueAt(i, j));
            }
        }
    }
    @Test
    public void checkDropOneTokenInvalidColumnRight() {
        assertFalse(board.drop(10, Color.RED));
    }

    @Test
    public void checkDropOneTokenInvalidColumnLeft() {
        assertFalse(board.drop(-10, Color.RED));
    }

    @Test void checkDropTokenWhemColFull() {
        for (int i=0; i<BOARD_HEIGHT; i++) {
            board.drop(0, Color.RED);
        }
        assertFalse(board.drop(0, Color.RED));
    }

    @Test
    public void testToString() {
        StringBuilder testBoardString = new StringBuilder();

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                switch (board.getValueAt(i, j)) {
                    case BLANK:
                        testBoardString.append(" ");
                        break;
                    case RED:
                        testBoardString.append("R");
                        break;
                    case YELLOW:
                        testBoardString.append("Y");
                        break;
                }
            }
            testBoardString.append("\n");
        }

        assertEquals(testBoardString.toString(), board.toString());
    }
}