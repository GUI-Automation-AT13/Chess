package src;

import org.junit.Test;
import src.Utilities.Player;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void creatingPlayerCreatesPlayerWithIsWhiteTrue() {
        Player player = new Player("newPLayer", true);
        assertEquals(true, player.isWhite());
    }

    @Test
    public void creatingPlayerCreatesPlayerWithIsWhiteFalse() {
        Player player = new Player("newPLayer", false);
        assertEquals(false, player.isWhite());
    }

    @Test
    public void getColorCreatingAWhitePlayerReturnsWhite() {
        Player player1 = new Player("player1", true);
        boolean expected = true;
        boolean actual = player1.isWhite();
        assertEquals(expected, actual);
    }

    @Test
    public void getColorReturnsWhite() {
        Player player = new Player("p1", true);
        String expected = "White";
        assertEquals(expected, player.getColor());
    }

    @Test
    public void getColorReturnsBlack() {
        Player player = new Player("p1", false);
        String expected = "Black";
        assertEquals(expected, player.getColor());
    }
}
