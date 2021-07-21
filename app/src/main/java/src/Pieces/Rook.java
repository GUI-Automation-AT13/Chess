package src.Pieces;

import src.PiecesMoves.LinedMove;
import src.Utilities.Position;

public class Rook extends Piece{
    private char figure = 'R';
    private final String WHITE_ROOK_DIR = "src/main/java/resources/WhiteRook.png";
    private final String BLACK_ROOK_DIR = "src/main/java/resources/BlackRook.png";
    /**
     *Class to start a bishop.
     */
    public Rook(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new LinedMove());
        if (white == true) {
            setImage(WHITE_ROOK_DIR);
        } else {
            setImage(BLACK_ROOK_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}
