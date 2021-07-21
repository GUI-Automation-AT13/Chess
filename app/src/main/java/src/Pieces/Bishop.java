package src.Pieces;

import src.PiecesMoves.DiagonalsMove;
import src.Utilities.Position;

public class Bishop extends Piece {
    private final char figure = 'B';
    private final String WHITE_BISHOP_DIR = "src/main/java/resources/WhiteBishop.png";
    private final String BLACK_BISHOP_DIR = "src/main/java/resources/BlackBishop.png";
    /**
     *Class to start a bishop.
     */
    public Bishop(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new DiagonalsMove());
        if (white == true) {
            setImage(WHITE_BISHOP_DIR);
        } else {
            setImage(BLACK_BISHOP_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}

