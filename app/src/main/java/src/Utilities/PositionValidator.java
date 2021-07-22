package src.Utilities;

import java.util.regex.Pattern;

public class PositionValidator {
    private String input;

    /**
     * @param input  the positions for a given input if they are valid
     */
    public PositionValidator(final String input) {
        this.input = input;

    }

    /**
     * @return  if the input matches a position format.
     */
    public boolean isPositionValid() {
        return Pattern.matches("[a-h][1-8]", input);
    }

    /**
     * @return  if the input matches two positions with valid format.
     */
    public boolean isMoveValid() {
        return Pattern.matches("[a-h][1-8][ ][a-h][1-8]", input);
    }
}
