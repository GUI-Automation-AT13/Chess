package src.Utilities;

import src.Pieces.*;

public class GetPieceFactory {
    /**
     * Public constructor.
     */
    public GetPieceFactory() {

    }

    /**
     * Creates a Piece given the parameters name, isWhite, posX and posY.
     * @param name of piece.
     * @param isWhite color or piece.
     * @param position of piece.
     * @return piece
     */
    public Piece getPiece(final TypePiece name, final boolean isWhite, final Position position) {
        Piece piece = null;
        switch (name) {
            case ROOK: piece = new Rook(isWhite, position);
            break;
            case BISHOP: piece = new Bishop(isWhite, position);
                break;
            case HORSE: piece = new Horse(isWhite, position);
                break;
            case QUEEN: piece = new Queen(isWhite, position);
                break;
            case KING: piece = new King(isWhite, position);
                break;
            case PAWN: piece = new Pawn(isWhite, position);
                break;
            default:
                break;
        }
        return piece;
    }
}
