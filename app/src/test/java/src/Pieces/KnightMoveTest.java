package src.Pieces;

import org.junit.Test;
import java.util.List;

import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import static org.junit.Assert.assertEquals;

public class KnightMoveTest {

    private void chessboardScenario() {
        Chessboard chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        chessboard.board[2][4] = getPieceFactory.getPiece(TypePiece.HORSE, true, new Position(4,2));
        chessboard.board[5][6] = getPieceFactory.getPiece(TypePiece.PAWN, false, new Position(6,5));
        chessboard.board[6][2] = getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(2,6));
        chessboard.board[5][1] = getPieceFactory.getPiece(TypePiece.BISHOP, false, new Position(1,5));
    }
    /**
     *      ---------------------------------------
     * 8 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 7 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 6 |    |    |    |    | WH |    |    |    |
     *   |---------------------------------------
     * 5 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 4 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 3 |    | BB |    |    |    |    | BP |    |
     *   |---------------------------------------
     * 2 |    |    | WR |    |    |    |    |    |
     *   |---------------------------------------
     * 1 | WH |    |    |    |    |    |    | WH |
     *   |---------------------------------------
     *     a    b    c    d    e    f    g    h
     */
    @Test
    public void getValidMovesKnightAlone_E6_EightMoves() {
        chessboardScenario();
        Piece knight = Chessboard.board[2][4];
        List<Position> validMoves = knight.getValidMoves();
        String expected = "g7 f8 d8 c7 c5 d4 f4 g5 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKnightOneEnemy_H1_TwoMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.HORSE, true, new Position(7,7)));
        Piece knight = Chessboard.board[7][7];
        List<Position> validMoves = knight.getValidMoves();
        String expected = "g3 f2 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKnightOneEnemyOneAlly_A1_OneMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.HORSE, true, new Position(0,7)));
        Piece knight = Chessboard.board[7][0];
        List<Position> validMoves = knight.getValidMoves();
        String expected = "b3 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void horseIsBlack_InputTrue_B() {
        int initPosX = 4;
        int initPosY = 4;
        Horse knight = new Horse(false, new Position(initPosX, initPosY));
        char actual = knight.getColor();
        char expected = 'B';
        assertEquals(expected, actual);
    }
    @Test
    public void horseIsWhite_InputTrue_W() {
        int initPosX = 4;
        int initPosY = 4;
        Horse knight = new Horse(true, new Position(initPosX, initPosY));
        char actual = knight.getColor();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    public void getFigureHorse_ChoseKing_K() {
        int initPosX = 4;
        int initPosY = 4;
        Horse knight = new Horse(true, new Position(initPosX, initPosY));
        char actual = knight.getFigure();
        char expected = 'H';
        assertEquals(expected, actual);
    }
}
