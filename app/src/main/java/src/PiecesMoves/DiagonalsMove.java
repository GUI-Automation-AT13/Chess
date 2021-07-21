package src.PiecesMoves;

import src.Utilities.Chessboard;
import src.Pieces.Piece;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class DiagonalsMove implements MovePiece {
    private ArrayList<Position> movePoints;

    @Override
    public List<Position> getPossibleMoves(final Piece piece) {
        movePoints = new ArrayList<Position>();
        int posX = piece.getPosX();
        int posY = piece.getPosY();
        int numberMax = Math.max(posX, posY);
        int numberMin = Math.min(posX, posY);
        //southeast (SE)
        for (int i = 1; numberMax + i < Chessboard.DIMENSION; i++) {
            if (!isAccessiblePosition(posX + i, posY + i, piece.getColorWhite())) {
                break;
            }
        }
        //northwest (NW).
        for (int i = 1; numberMin - i >= 0; i++) {
            if (!isAccessiblePosition(posX - i, posY - i, piece.getColorWhite())) {
                break;
            }
        }
        //southwest (SW)
        for (int i = 1; posX + i < Chessboard.DIMENSION && posY - i >= 0; i++) {
            if (!isAccessiblePosition(posX + i, posY - i, piece.getColorWhite())) {
                break;
            }
        }
        //northeast (NE)
        for (int i = 1; posY + i < Chessboard.DIMENSION && posX - i >= 0; i++) {
            if (!isAccessiblePosition(posX - i, posY + i, piece.getColorWhite())) {
                break;
            }
        }
        return movePoints;
    }

    /**
     * Verify if the space of destination is free from piece of the same color.
     *
     * @param posX       is a position analise of Chessboard.
     * @param posY       is a position analise of Chessboard.
     * @param colorPiece is a color piece.
     * @return boolean which say is accessible Position.
     */
    public boolean isAccessiblePosition(final int posY, final int posX, final boolean colorPiece) {

        if (isSpaceEmpty(Chessboard.getPiece(new Position(posY, posX)))) {
            movePoints.add(new Position(posY, posX));
            return true;
        }
        if (isSpaceWithEnemy(Chessboard.getPiece(new Position(posY, posX)), colorPiece)) {
            movePoints.add(new Position(posY, posX));
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
     * Verify is the Position is inside the Limits of the Chessboard
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
