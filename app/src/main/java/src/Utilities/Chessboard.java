package src.Utilities;

import src.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Chessboard {
    public final static int DIMENSION = 8;
    public static Piece[][] board = new Piece[DIMENSION][DIMENSION];
    private Team whiteTeam;
    private Team blackTeam;
    private Player winner;
    private final int posXCastlingKingSide = 6;
    private final int posXCastlingQueenSide = 2;

    /**
     * Get a piece in certain position
     * @param position piece.
     * @return the piece in the position.
     */
    public static Piece getPiece(final Position position) {
        Piece piece = board[position.getPosY()][position.getPosX()];
        return piece;
    }

    /**
     * Chessboard initializes the pieces from its Team instances.
     */
    public Chessboard() {
        initializeChessboard();
    }

    /**
     * Initialized the Teams and White turn.
     */
    public void initializeChessboard() {
        boolean isWhite = true;
        whiteTeam = new Team(isWhite);
        blackTeam = new Team(!isWhite);
    }

    /**
     * Prints the board in console.
     */
    public void printBoard() {
        System.out.println("   ---------------------------------------");
        for (int row = 0; row < DIMENSION; row++) {
            System.out.print(DIMENSION - row + " |");
            for (int col = 0; col < DIMENSION; col++) {
                if (board[row][col] != null) {
                    Piece piece = board[row][col];
                    String figure = " " + String.valueOf(piece.getColor()) + String.valueOf(piece.getFigure()) + " |";
                    System.out.print(figure);
                } else {
                    System.out.print("    " + "|");
                }
            }
            System.out.println("");
            System.out.println("  |---------------------------------------");
        }
        System.out.println("    a    b    c    d    e    f    g    h");
    }

    /**
     * Checks if a piece can be moved in the board while checking if the move is
     * castling or the king has been taken.
     * @param source position.
     * @param target position.
     * @param player active.
     * @return true if piece can move, false if not.
     */
    public boolean movePiece(final Position source, final Position target, final Player player) {
        List<Position> validMoves = getValidMoves(source, player);
        try {
            if (validMoves.contains(target)) {
                if (board[source.getPosY()][source.getPosX()].getFigure() == 'K' && !board[source.getPosY()][source.getPosX()].isMoved()) {
                    return checkCastlingMove(source, target, validMoves);
                }
                if (Chessboard.board[target.getPosY()][target.getPosX()] != null) {
                    if (Chessboard.board[target.getPosY()][target.getPosX()].getFigure() == 'K') {
                        winner = player;
                    }
                }
                moveFromSourceToTarget(source, target);
                return true;
            }
        } catch (Exception e) {
            System.out.println("You can move only you piece, Play fair");
        }
        return false;
    }

    /**
     * Update the piece on the chessboard given a source and target position.
     * @param source position.
     * @param target position.
     */
    public void moveFromSourceToTarget(final Position source, final Position target) {
        Piece pieceToMove = board[source.getPosY()][source.getPosX()];
        pieceToMove.updatePosition(new Position(target.getPosX(), target.getPosY()));
        Chessboard.board[target.getPosY()][target.getPosX()] = pieceToMove;
        Chessboard.board[source.getPosY()][source.getPosX()] = null;
    }

    /**
     * Returns the player who made the move to take the king.
     */
    public Player kingTakenBy() {
        return winner;
    }

    /**
     * Returns all the valid moves a piece from the given source position can make.
     * @param source position.
     * @param player active.
     * @return all valid moves.
     */
    public List<Position> getValidMoves(final Position source, final Player player) {
        List<Position> validMoves = new ArrayList<Position>();
        try {
            Piece piece = board[source.getPosY()][source.getPosX()];
            if (player.isWhite() == piece.getColorWhite()) {
                validMoves = piece.getValidMoves();
                return validMoves;
            } else {
                validMoves = null;
                return validMoves;
            }
        }catch (Exception e){
            return validMoves;
        }
    }

    /**
     * Checks if a valid castling move has been made and makes the move.
     * @param source position.
     * @param target position.
     * @param validMoves list of valid moves.
     * @return true if can do Castling, false if cannot.
     */
    public boolean checkCastlingMove(final Position source, Position target, final List<Position> validMoves) {
        int posXCastling = DIMENSION;
        int posXRookSource = DIMENSION;
        int posXRookTarget = DIMENSION;
        for (Position pos : validMoves) {
            if (pos.getPosX() == posXCastlingKingSide) {
                posXCastling = posXCastlingKingSide;
                posXRookSource = DIMENSION - 1;
                posXRookTarget = posXCastling - 1;
            } else {
                if (pos.getPosX() == posXCastlingQueenSide) {
                    posXCastling = posXCastlingQueenSide;
                    posXRookSource = 0;
                    posXRookTarget = posXCastling + 1;
                }
            }
            if (target.equals(pos) && posXCastling != DIMENSION) {
                Position rookTarget = new Position(posXRookTarget, pos.getPosY());
                Position rookSource = new Position(posXRookSource, pos.getPosY());
                moveFromSourceToTarget(source, target);
                moveFromSourceToTarget(rookSource, rookTarget);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a piece in the chessboard in the given position.
     * @param position of possible piece.
     * @return true if there is a piece, false if not.
     */
    public boolean thereIsPiece(final Position position) {
        if (board[position.getPosY()][position.getPosX()] == null) {
            return false;
        }
        return true;
    }

    /**
     * setPiece with a position and piece.
     * @param piece to set.
     */
    public static void setPiece(final Piece piece) {
        Chessboard.board[piece.getPosY()][piece.getPosX()] = piece;
    }

    /**
     * Reset the Chessboard.
     */
    public void resetChessBoard() {
        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                board[row][col] = null;
            }
        }
    }
    public void setWinnerNull() {
        this.winner = null;
    }
}
