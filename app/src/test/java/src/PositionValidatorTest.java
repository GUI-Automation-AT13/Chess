package src;

import org.junit.Test;
import src.Utilities.PositionValidator;

import static org.junit.Assert.assertEquals;

public class PositionValidatorTest {
    @Test
    public void isPositionValidGiven_asdf12_return_false() {
        PositionValidator positionValidator = new PositionValidator("asdf12");
        boolean expected = false;
        boolean actual = positionValidator.isPositionValid();
        assertEquals(expected, actual);
    }
    @Test
    public void isPositionValidGiven_a2_return_true() {
        PositionValidator positionValidator = new PositionValidator("a2");
        boolean expected = true;
        boolean actual = positionValidator.isPositionValid();
        assertEquals(expected, actual);
    }
    @Test
    public void isPositionValidGiven_v9_return_false() {
        PositionValidator positionValidator = new PositionValidator("v9");
        boolean expected = false;
        boolean actual = positionValidator.isPositionValid();
        assertEquals(expected, actual);
    }
    @Test
    public void isMoveValidGiven_f2_f4_return_true() {
        PositionValidator positionValidator = new PositionValidator("f2 f4");
        boolean expected = true;
        boolean actual = positionValidator.isMoveValid();
        assertEquals(expected, actual);
    }
    @Test
    public void isMoveValidGiven_a0_v6_return_false() {
        PositionValidator positionValidator = new PositionValidator("a0 v6");
        boolean expected = false;
        boolean actual = positionValidator.isPositionValid();
        assertEquals(expected, actual);
    }
}
