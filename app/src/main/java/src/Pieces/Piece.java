package src.Pieces;

import src.PiecesMoves.MovePiece;
import src.Utilities.Position;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private char color;
    private boolean isWhite;
    private char figure;
    public ImageIcon image;
    private int posX;
    private int posY;
    private boolean isCaptured;
    private boolean isMoved;
    private List<MovePiece> moveTypes = new ArrayList<>();

    public Piece(final boolean white, final Position position) {
        this.isWhite = white;
        this.isCaptured = false;
        this.posX = position.getPosX();
        this.posY = position.getPosY();
        this.isMoved = false;
        this.color = white ? 'W' : 'B';
    }

    /**
     * @return Xposition Class to get the x position of a piece.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return Yposition Class to get the y position of a piece.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return figure Class to get the figure.
     */
    public char getFigure() {
        return this.figure;
    }

    /**
     * @return if the piece has moved.
     */
    public boolean isMoved() {
        return this.isMoved;
    }

    /**
     * @param move  if the piece has moved.
     */
    public void setIsMoved(final boolean move) {
        this.isMoved = move;
    }

    /**
     * @return if the piece is white or black.
     */
    public boolean getColorWhite() {
        return this.isWhite;
    }

    /**
     * @param movePiece  to add a move to a piece.
     */
    public void addMoveType(final MovePiece movePiece) {
        this.moveTypes.add(movePiece);
    }

    /**
     * @return the color of a piece.
     */
    public char getColor() {
        return color;
    }

    /**
     * @param position  to update position.
     */
    public void updatePosition(final Position position) {
        this.posX = position.getPosX();
        this.posY = position.getPosY();
        this.isMoved = true;
    }

    /**
     * @return a list of valid moves.
     */
    public List<Position> getValidMoves() {
        List<Position> validMoves = new ArrayList<Position>();
        for (MovePiece movePiece : moveTypes) {
            validMoves.addAll(movePiece.getPossibleMoves(this));
        }
        return validMoves;
    }
    public void setImage(String dir) {
        this.image = new ImageIcon(dir);
    }
    public ImageIcon getImage() {
        return image;
    }
}