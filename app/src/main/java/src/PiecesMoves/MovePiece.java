package src.PiecesMoves;

import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.List;

public interface MovePiece {
    List<Position> getPossibleMoves(Piece piece);

    /**
     * Verify is the Position is inside the Limits of the Chessboard.
     *
     * @param position of piece.
     * @return true if its in the limits, false if not.
     */
    boolean isInLimits(int position);

    /**
     * Verify if Destiny position has an enemy.
     *
     * @param piece   piece of enemy.
     * @param isWhite is color a piece.
     * @return boolean answer isSpaceWithEnemy
     */
    boolean isSpaceWithEnemy(Piece piece, boolean isWhite);

    /**
     * Verify if the space of destination is free from piece of the same color or is empty.
     *
     * @param piece is the piece in the possible position.
     * @return true is space is empty or has a piece of different color, false if has piece of same color
     */
    boolean isSpaceEmpty(Piece piece);
}
