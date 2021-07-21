package src.Utilities;

import java.util.regex.Pattern;

public class PositionValidator {

    private Position source;
    private Position target;
    private Position positionToGetPossibles;
    private String input;
    private final int SIZE_POSITION_INPUT = 2;
    private final int SIZE_MOVE_INPUT = 5;
    private final int TARGET_CHAR_POS = 3;

    /**
     * @param input  the positions for a given input if they are valid
     */
    public PositionValidator(final String input) {
        this.input = input;

        validateInput();
    }

    /**
     * Process a string to know if they contain one or two Positions and store them if valid.
     */
    public void validateInput() {
        isActionGetPossibleMoves();
        isActionMovePiece();
    }

    /**
     * Stores the position if it one to get possible moves from.
     */
    public void isActionGetPossibleMoves() {
        if (input.length() == SIZE_POSITION_INPUT) {
            if (isPositionValid()) {
                this.positionToGetPossibles = new Position(input);
            }
        }
    }

    /**
     * Stores the source and target position if the inputs contains two valid positions.
     */
    public void isActionMovePiece() {
        if (input.length() == SIZE_MOVE_INPUT) {
            String source = input.substring(0, 2);
            String target = input.substring(TARGET_CHAR_POS);
            if (isMoveValid()) {
                this.source = new Position(source);
                this.target = new Position(target);
            }
        }
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

    /**
     * @return getPositionToGetPossibles.
     */
    public Position getPositionToGetPossibles() {
        return this.positionToGetPossibles;
    }

    /**
     * @return getSource.
     */
    public Position getSource() {
        return source;
    }

    /**
     * @return getTarget.
     */
    public Position getTarget() {
        return target;
    }
}
