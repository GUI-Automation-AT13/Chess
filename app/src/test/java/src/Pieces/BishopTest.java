package src.Pieces;

import org.junit.Test;
import src.PiecesMoves.Castling;
import src.PiecesMoves.DiagonalsMove;
import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import java.util.List;

import static org.junit.Assert.*;

public class BishopTest {

    private void chessboardScenario() {
        Chessboard chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(3, 3)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, true, new Position(6, 1)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, false, new Position(2, 3)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, true, new Position(5, 6)));
        /**
         *   ---------------------------------------
         * 8 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 7 |    |    |    |    |    |    | WK |    |
         *   |---------------------------------------
         * 6 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 5 |    |    | BP | BR |    |    |    |    |
         *   |---------------------------------------
         * 4 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 3 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 2 |    |    |    |    |    | WQ |    |    |
         *   |---------------------------------------
         * 1 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         *     a    b    c    d    e    f    g    h
         */
    }

    @Test
    public void getValidMovesBishop_H8_ZeroValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(7, 0)));
        Piece bishop = Chessboard.board[0][7];
        List<Position> validMoves = bishop.getValidMoves();
        String expected = "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesBishop_H1_FiveValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(7, 7)));
        Piece bishop = Chessboard.board[7][7];
        List<Position> validMoves = bishop.getValidMoves();
        String expected = "g2 f3 e4 d5 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }


    @Test
    public void getValidMovesBishop_A1_FiveValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(0, 7)));
        Piece bishop = Chessboard.board[7][0];
        List<Position> validMoves = bishop.getValidMoves();
        String expected = "b2 c3 d4 e5 f6 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesBishop_A8_ThreeValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(0, 0)));
        Piece bishop = Chessboard.board[0][0];
        List<Position> validMoves = bishop.getValidMoves();
        String expected = "b7 c6 d5 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesBishop_D4_SevenValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(3, 4)));
        Piece bishop = Chessboard.board[4][3];
        List<Position> validMoves = bishop.getValidMoves();
        String expected = "e3 c5 e5 f6 c3 b2 a1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void bishopIsBlack_InputFalse_B() {
        int inicialPocionX = 6;
        int inicialPocionY = 0;
        Bishop bishop = new Bishop(false, new Position(inicialPocionX, inicialPocionY));
        char actual = bishop.getColor();
        char expected = 'B';
        assertEquals(expected, actual);
    }

    @Test
    public void bishopIsWhite_InputTrue_W() {
        int inicialPocionX = 4;
        int inicialPocionY = 5;
        Bishop bishop = new Bishop(true, new Position(inicialPocionX, inicialPocionY));
        char actual = bishop.getColor();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    public void getFigureBishop_ChoseBishop_B() {
        int inicialPocionX = 7;
        int inicialPocionY = 0;
        Bishop bishop = new Bishop(true, new Position(inicialPocionX, inicialPocionY));
        char actual = bishop.getFigure();
        char expected = 'B';
        assertEquals(expected, actual);
    }
    @Test
    public void isInLimits_8_returnFalse() {
        DiagonalsMove diagonalsMove = new DiagonalsMove();
        boolean expected = false;
        boolean actual = diagonalsMove.isInLimits(8);
        assertEquals(actual, expected);
    }
    @Test
    public void isInLimits_7_returnTrue() {
        DiagonalsMove diagonalsMove = new DiagonalsMove();
        boolean expected = true;
        boolean actual = diagonalsMove.isInLimits(7);
        assertEquals(actual, expected);
    }
    @Test
    public void isInLimits_0_returnTrue() {
        DiagonalsMove diagonalsMove = new DiagonalsMove();
        boolean expected = true;
        boolean actual = diagonalsMove.isInLimits(0);
        assertEquals(actual, expected);
    }
}