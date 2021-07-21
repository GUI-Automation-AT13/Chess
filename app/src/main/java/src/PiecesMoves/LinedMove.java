package src.PiecesMoves;

import src.Utilities.Chessboard;
import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LinedMove implements MovePiece {
    private List<Position> movePositions;

    @Override
    public List<Position> getPossibleMoves(final Piece piece) {
        movePositions = new ArrayList<>();
        int xPos = piece.getPosX();
        int yPos = piece.getPosY();
        for (int i = xPos + 1; i < Chessboard.DIMENSION; i++) {
            if (!isAccessiblePosition(i, yPos, piece.getColorWhite())) {
                break;
            }
        }
        for (int i = xPos - 1; i >= 0; i--) {
            if (!isAccessiblePosition(i, yPos, piece.getColorWhite())) {
                break;
            }
        }
        for (int i = yPos + 1; i < Chessboard.DIMENSION; i++) {
            if (!isAccessiblePosition(xPos, i, piece.getColorWhite())) {
                break;
            }
        }
        for (int i = yPos - 1; i >= 0; i--) {
            if (!isAccessiblePosition(xPos, i, piece.getColorWhite())) {
                break;
            }
        }
        return movePositions;
    }

    /**
     * Verify if the space of destination is free from piece of the same color.
     *
     * @param posX is a position analise of Chessboard.
     * @param posY is a position analise of Chessboard.
     * @return boolean which say is accessible Position.
     */
    public boolean isAccessiblePosition(final int posY, final int posX, final boolean colorPiece) {
        if (isSpaceEmpty(Chessboard.getPiece(new Position(posY, posX)))) {
            movePositions.add(new Position(posY, posX));
            return true;
        }
        if (isSpaceWithEnemy(Chessboard.getPiece(new Position(posY, posX)), colorPiece)) {
            movePositions.add(new Position(posY, posX));
            return false;
        }
        return false;
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
     * @param piece   piece of enemy.
     * @param isWhite is color a piece.
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
     * @param position of piece.
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
