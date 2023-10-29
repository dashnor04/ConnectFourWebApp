package spw4.connectfour;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayerTest {
    public Player player;

    @BeforeEach
    public void beforeEach() {
        player = new Player();
    }

    @Test
    void testInit() {
        assertEquals(Color.WHITE, player.getColor());
    }

    @Test
    void testColorRed() {
        player.setColor("RED");
        assertEquals(Color.RED, player.getColor());
    }

    @Test
    void testColorYellow() {
        player.setColor("YELLOW");
        assertEquals(Color.YELLOW, player.getColor());
    }

}