package src.PiecesMoves;

import src.Utilities.Chessboard;
import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class KnightMove implements MovePiece {

    /**
     * Return a List of Positions with all possible moves of Knight.
     *
     * @param piece the Knight piece.
     * @return movePoints List of Points of moves.
     */
    @Override
    public List<Position> getPossibleMoves(final Piece piece) {
        List<Position> movePositions = new ArrayList<>();
        final int[] xKnightMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        final int[] yKnightMoves = {-1, -2, -2, -1, 1, 2, 2, 1};

        int xActPos = piece.getPosX();
        int yActPos = piece.getPosY();

        for (int i = 0; i < xKnightMoves.length; i++) {
            int xPosition = xActPos + xKnightMoves[i];
            int yPosition = yActPos + yKnightMoves[i];
            if (isInLimits(xPosition) && isInLimits(yPosition)) {
                if (isSpaceEmpty(Chessboard.getPiece(new Position(xPosition, yPosition))) ||
                        isSpaceWithEnemy(Chessboard.getPiece(new Position(xPosition, yPosition)), piece.getColorWhite())) {
                    movePositions.add(new Position(xPosition, yPosition));
                }
            }
        }
        return movePositions;
    }

    /**
     * Verify if the space of destination is free from piece of the same color or is empty.
     *
     * @param piece is the piece in the possible position.
     * @return true is space is empty or has a piece of different color, false if has piece of same color.
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
     * @param piece piece of enemy.
     * @param isWhite is color a piece.
     * @return
     */
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
}