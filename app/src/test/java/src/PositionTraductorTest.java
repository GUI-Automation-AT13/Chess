package src;

import org.junit.Test;
import src.Utilities.PositionTraductor;

import static org.junit.Assert.assertEquals;

public class PositionTraductorTest {
    @Test
    public void getIndexNotationGivena8Return00() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "00";
        int[] indexNotation = positionTraductor.getIndexNotation("a8");
        String actual = String.valueOf(indexNotation[0]) + String.valueOf(indexNotation[1]);
        assertEquals(expected, actual);
    }
    @Test
    public void getIndexNotationGivenb8Return10() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "10";
        int[] indexNotation = positionTraductor.getIndexNotation("b8");
        String actual = String.valueOf(indexNotation[0]) + String.valueOf(indexNotation[1]);
        assertEquals(expected, actual);
    }
    @Test
    public void getIndexNotationGivena1Return07() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "07";
        int[] indexNotation = positionTraductor.getIndexNotation("a1");
        String actual = String.valueOf(indexNotation[0]) + String.valueOf(indexNotation[1]);
        assertEquals(expected, actual);
    }
    @Test
    public void getIndexNotationGivenc5Return24() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "24";
        int[] indexNotation = positionTraductor.getIndexNotation("c4");
        String actual = String.valueOf(indexNotation[0]) + String.valueOf(indexNotation[1]);
        assertEquals(expected, actual);
    }
    @Test
    public void getIndexNotationGivenh8Return77() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "77";
        int[] indexNotation = positionTraductor.getIndexNotation("h1");
        String actual = String.valueOf(indexNotation[0]) + String.valueOf(indexNotation[1]);
        assertEquals(expected, actual);
    }
    @Test
    public void getAlgebraicNotationGiven00Returna1() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "a1";
        String indexNotation = positionTraductor.getAlgebraicNotation(0, 7);
        String actual = indexNotation;
        assertEquals(expected, actual);
    }
    @Test
    public void getAlgebraicNotationGiven44Returnc3() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "c5";
        String indexNotation = positionTraductor.getAlgebraicNotation(2, 3);
        String actual = indexNotation;
        assertEquals(expected, actual);
    }
    @Test
    public void getAlgebraicNotationGiven46Returnd7() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "d7";
        String indexNotation = positionTraductor.getAlgebraicNotation(3, 1);
        String actual = indexNotation;
        assertEquals(expected, actual);
    }
    @Test
    public void getAlgebraicNotationGiven77Returnh7() {
        PositionTraductor positionTraductor = new PositionTraductor();
        String expected = "h8";
        String indexNotation = positionTraductor.getAlgebraicNotation(7, 0);
        String actual = indexNotation;
        assertEquals(expected, actual);
    }
}
