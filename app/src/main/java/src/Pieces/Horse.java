package src.Pieces;

import src.PiecesMoves.KnightMove;
import src.Utilities.Position;

public class Horse extends Piece{
    private char figure = 'H';
    private final String WHITE_KNIGHT_DIR = "src/main/java/resources/WhiteKnight.png";
    private final String BLACK_KNIGHT_DIR = "src/main/java/resources/BlackKnight.png";
    /**
     *Class to start a Horse.
     */
    public Horse(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new KnightMove());
        if (white == true) {
            setImage(WHITE_KNIGHT_DIR);
        } else {
            setImage(BLACK_KNIGHT_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}
