package src.PiecesMoves;

import src.Utilities.Chessboard;
import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements MovePiece {

    /**
     * Return a List of Positions with all possible moves of Pawn.
     *
     * @param piece the Pawn piece
     * @return movePoints List of Points of moves
     */
    public List<Position> getPossibleMoves(final Piece piece) {
        List<Position> movePositions = new ArrayList<>();
        int yOneMove = piece.getPosY() + 1;
        int yDoubleMove = piece.getPosY() + 2;
        int xDiagonalMLeft = piece.getPosX() - 1;
        int xDiagonalMRight = piece.getPosX() + 1;

        if (piece.getColorWhite()) {
            yOneMove = piece.getPosY() - 1;
            yDoubleMove = piece.getPosY() - 2;
        }
        if (!piece.isMoved()) {
            if (isSpaceEmpty(Chessboard.getPiece(new Position(piece.getPosX(), yDoubleMove)))) {
                movePositions.add(new Position(piece.getPosX(), yDoubleMove));
            }
        }
        if (isInLimits(yOneMove)) {
            if (isSpaceEmpty(Chessboard.getPiece(new Position(piece.getPosX(), yOneMove)))) {
                movePositions.add(new Position(piece.getPosX(), yOneMove));
            }
            if (isInLimits(xDiagonalMLeft)) {
                if (isSpaceWithEnemy(Chessboard.getPiece(new Position(xDiagonalMLeft, yOneMove)), piece.getColorWhite())) {
                    movePositions.add(new Position(xDiagonalMLeft, yOneMove));
                }
            }
            if (isInLimits(xDiagonalMRight)) {
                if (isSpaceWithEnemy(Chessboard.getPiece(new Position(xDiagonalMRight, yOneMove)), piece.getColorWhite())) {
                    movePositions.add(new Position(xDiagonalMRight, yOneMove));
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
    public boolean isSpaceEmpty(final Piece piece) {
        if (piece == null) {
            return true;
        }
        return false;
    }

    /**
     * Verify if Destiny position has an enemy.
     *
     * @param piece   piece of enemy.
     * @param isWhite is color a piece.
     * @return boolean answer isSpaceWithEnemy
     */
    public boolean isSpaceWithEnemy(final Piece piece, final boolean isWhite) {
        if (piece != null && piece.getColorWhite() != isWhite) {
            return true;
        }
        return false;
    }

    /**
     * Verify is the Position is inside the Limits of the Chessboard.
     *
     * @param position
     * @return true if its in the limits, false if not
     */
    @Override
    public boolean isInLimits(final int position) {
        if (0 <= position && position < Chessboard.DIMENSION) {
            return true;
        }
        return false;
    }
}