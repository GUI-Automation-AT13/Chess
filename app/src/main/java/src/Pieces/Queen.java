package src.Pieces;

import src.PiecesMoves.DiagonalsMove;
import src.PiecesMoves.LinedMove;
import src.Utilities.Position;

public class Queen extends Piece{
    private char figure = 'Q';
    private final String WHITE_QUEEN_DIR = "src/main/java/resources/WhiteQueen.png";
    private final String BLACK_QUEEN_DIR = "src/main/java/resources/BlackQueen.png";
    /**
     *Class to start a Queen.
     */
    public Queen(final boolean white, final Position position) {
        super(white, position);
        addMoveType(new DiagonalsMove());
        addMoveType(new LinedMove());
        if (white == true) {
            setImage(WHITE_QUEEN_DIR);
        } else {
            setImage(BLACK_QUEEN_DIR);
        }
    }
    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }
}
