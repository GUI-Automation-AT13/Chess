package src.Pieces;

import src.PiecesMoves.PawnMove;
import src.Utilities.Position;

public class Pawn extends Piece{
    private char figure = 'P';
    private final String WHITE_PAWN_DIR = "src/main/java/resources/WhitePawn.png";
    private final String BLACK_PAWN_DIR = "src/main/java/resources/BlackPawn.png";
    /**
     *Class to start a Pawn.
     */
    public Pawn(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new PawnMove());
        if (white == true) {
            setImage(WHITE_PAWN_DIR);
        } else {
            setImage(BLACK_PAWN_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}
