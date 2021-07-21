package src.PiecesMoves;

import src.Utilities.Chessboard;
import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class Castling implements MovePiece {

    @Override
    public List<Position> getPossibleMoves(final Piece piece) {
        List<Position> movePositions = new ArrayList<>();
        int xPosQ = 0;
        int xPosK = Chessboard.DIMENSION - 1;
        final int limitQCastling = 3;
        final int limitKCastling = 2;
        if (!piece.isMoved()) {

            int checkEmpty = 0;
            if (!isHaveMoved(Chessboard.getPiece(new Position(xPosK, piece.getPosY())))) {
                for (int i = 1; i <= limitKCastling; i++) {
                    if (!isSpaceEmpty(Chessboard.getPiece(new Position(xPosK - i, piece.getPosY())))) {
                        break;
                    }
                    checkEmpty++;
                }
                if (checkEmpty == limitKCastling) {
                    movePositions.add(new Position(xPosK - 1, piece.getPosY()));
                }
            }

            if (!isHaveMoved(Chessboard.getPiece(new Position(xPosQ, piece.getPosY())))) {
                checkEmpty = 0;
                for (int i = 1; i <= limitQCastling; i++) {
                    if (!isSpaceEmpty(Chessboard.getPiece(new Position(xPosQ + i, piece.getPosY())))) {
                        break;
                    }
                    checkEmpty++;
                }
                if (checkEmpty == limitQCastling) {
                    movePositions.add(new Position(xPosQ + limitKCastling, piece.getPosY()));
                }
            }
        }
        return movePositions;
    }

    /**
     * Verify if the space of destination is free from piece of the same color or is empty.
     *
     * @param piece is the piece in the possible position.
     * @return true is space is empty or has a piece of different color, false if has piece of same color
     */
    @Override
    public boolean isSpaceEmpty(final Piece piece) {
        if (piece == null) {
            return true;
        }
        return false;
    }

    /**
     * Verify if Destiny position has an enemy.
     *
     * @param piece
     * @param isWhite
     * @return
     */
    @Override
    public boolean isSpaceWithEnemy(final Piece piece, final boolean isWhite) {
        if (piece.getColorWhite() != isWhite) {
            return true;
        }
            return false;
    }

    /**
     * Verify is the Position is inside the Limits of the Chessboard.
     *
     * @param position
     * @return true if its in the limits, false if not.
     */
    @Override
    public boolean isInLimits(final int position) {
        if (0 <= position && position < Chessboard.DIMENSION) {
            return true;
        }
        return false;
    }

    /**
     * Verify if the piece Rook has moved previously.
     *
     * @param piece Rook
     * @return true if has moved, false if not.
     */
    public boolean isHaveMoved(final Piece piece) {
        return piece.isMoved();
    }
}