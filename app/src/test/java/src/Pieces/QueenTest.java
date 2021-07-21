package src.Pieces;

import org.junit.Test;
import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import java.util.List;

import static org.junit.Assert.*;

public class QueenTest {
    Chessboard chessboard;

    private void chessboardScenario() {
        chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, false, new Position(3, 3)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.HORSE, false, new Position(6, 6)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(3, 5)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(6, 2)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, false, new Position(1, 4)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position("f4")));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.HORSE, false, new Position("e8")));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, true, new Position("e4")));
        /**
         *    ---------------------------------------
         * 8 |    |    |    |    | BH |    |    |    |
         *   |---------------------------------------
         * 7 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 6 |    |    |    |    |    |    | WR |    |
         *   |---------------------------------------
         * 5 |    |    |    | BB |    |    |    |    |
         *   |---------------------------------------
         * 4 |    | BK |    |    | WQ | BR |    |    |
         *   |---------------------------------------
         * 3 |    |    |    | WP |    |    |    |    |
         *   |---------------------------------------
         * 2 |    |    |    |    |    |    | BH |    |
         *   |---------------------------------------
         * 1 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         *     a    b    c    d    e    f    g    h
         */
    }

    @Test
    public void getValidMovesQueen_E4_FifteenValidMoves() {
        chessboardScenario();
        Piece queen = Chessboard.board[4][4];
        List<Position> validMoves = queen.getValidMoves();
        String expected = "f3 g2 d5 f5 f4 d4 c4 b4 e3 e2 e1 e5 e6 e7 e8 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesQueenBlack_H8_SixteenValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, false, new Position(7, 0)));
        Piece queen = Chessboard.board[0][7];
        List<Position> validMoves = queen.getValidMoves();
        String expected = "g7 f6 e5 d4 c3 b2 a1 g8 f8 h7 h6 h5 h4 h3 h2 h1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesQueenBlack_A1_TwentyOneValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, false, new Position(0, 7)));
        Piece queen = Chessboard.board[7][0];
        List<Position> validMoves = queen.getValidMoves();
        String expected = "b2 c3 d4 e5 f6 g7 h8 b1 c1 d1 e1 f1 g1 h1 a2 a3 a4 a5 a6 a7 a8 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesQueenBlack_H1_FourteenValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, false, new Position(7, 7)));
        Piece queen = Chessboard.board[7][7];
        List<Position> validMoves = queen.getValidMoves();
        String expected = "g1 f1 e1 d1 c1 b1 a1 h2 h3 h4 h5 h6 h7 h8 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesQueenWhite_A8_FourteenValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, true, new Position(0, 0)));
        Piece queen = Chessboard.board[0][0];
        List<Position> validMoves = queen.getValidMoves();
        String expected = "b7 c6 d5 b8 c8 d8 e8 a7 a6 a5 a4 a3 a2 a1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void queenIsBlack_InputFalse_B() {
        int inicialPocionX = 4;
        int inicialPocionY = 4;
        Queen queen = new Queen(false, new Position(inicialPocionX, inicialPocionY));
        char actual = queen.getColor();
        char expected = 'B';
        assertEquals(expected, actual);
    }

    @Test
    public void queenIsWhite_InputTrue_W() {
        int inicialPocionX = 5;
        int inicialPocionY = 6;
        Queen queen = new Queen(true, new Position(inicialPocionX, inicialPocionY));
        char actual = queen.getColor();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    public void getFigureQueen_ChoseQueen_Q() {
        int inicialPocionX = 4;
        int inicialPocionY = 3;
        Queen queen = new Queen(true, new Position(inicialPocionX, inicialPocionY));
        char actual = queen.getFigure();
        char expected = 'Q';
        assertEquals(expected, actual);
    }
}