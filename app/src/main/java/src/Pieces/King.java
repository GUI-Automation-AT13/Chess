package src.Pieces;

import src.PiecesMoves.Castling;
import src.PiecesMoves.KingMove;
import src.Utilities.Position;

public class King extends Piece {
    private char figure = 'K';
    private final String WHITE_KING_DIR = "src/main/java/resources/WhiteKing.png";
    private final String BLACK_KING_DIR = "src/main/java/resources/BlackKing.png";
    private boolean alive=true;
    /**
     *Class to start a King.
     */
    public King(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new KingMove());
        addMoveType(new Castling());
        if (white == true) {
            setImage(WHITE_KING_DIR);
        } else {
            setImage(BLACK_KING_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}
