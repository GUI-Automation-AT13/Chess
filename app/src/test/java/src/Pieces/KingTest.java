package src.Pieces;

import org.junit.Test;
import src.PiecesMoves.KingMove;
import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import java.util.List;

import static org.junit.Assert.*;

public class KingTest {

    private void chessboardScenario() {
        Chessboard chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.BISHOP, true, new Position(4, 4)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.HORSE, false, new Position(4, 5)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, false, new Position(2, 5)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(2, 3)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, false, new Position(3, 4)));

        /**
         * 8 |
         * 7 |
         * 6 |
         * 5 |       WR
         * 4 |          BK WB
         * 3 |       BP    BH
         * 2 |
         * 1 |
         *    -----------------------
         *     a  b  c  d  e  f  g  h
         */

    }

    @Test
    public void getValidMovesKing_D4_FiveValidMoves() {
        chessboardScenario();
        Piece king = Chessboard.board[4][3];
        KingMove kingMove = new KingMove();
        List<Position> validMoves = kingMove.getPossibleMoves(king);
        String expected = "e5 c5 d5 c4 e4 d3 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKing_H8_ThreeValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, true, new Position(7, 0)));
        Piece king = Chessboard.board[0][7];

        KingMove kingMove = new KingMove();
        List<Position> validMoves = kingMove.getPossibleMoves(king);
        String expected = "g7 g8 h7 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKing_A8_ThreeValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, true, new Position(0, 0)));
        Piece king = Chessboard.board[0][0];

        KingMove kingMove = new KingMove();
        List<Position> validMoves = kingMove.getPossibleMoves(king);
        String expected = "b7 b8 a7 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKing_H1_ThreeValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, true, new Position(7, 7)));
        Piece king = Chessboard.board[7][7];

        KingMove kingMove = new KingMove();
        List<Position> validMoves = kingMove.getPossibleMoves(king);
        String expected = "g2 h2 g1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesKing_A1_ThreeValidMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, true, new Position(0, 7)));
        Piece king = Chessboard.board[7][0];

        KingMove kingMove = new KingMove();
        List<Position> validMoves = kingMove.getPossibleMoves(king);
        String expected = "b2 a2 b1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void kingIsBlack_InputFalse_B() {
        int inicialPocionX = 4;
        int inicialPocionY = 4;
        King king = new King(false, new Position(inicialPocionX, inicialPocionY));
        char actual = king.getColor();
        char expected = 'B';
        assertEquals(expected, actual);
    }

    @Test
    public void kingIsWhite_InputTrue_W() {
        int inicialPocionX = 4;
        int inicialPocionY = 4;
        King king = new King(true, new Position(inicialPocionX, inicialPocionY));
        char actual = king.getColor();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    public void getFigureKing_ChoseKing_K() {
        int inicialPocionX = 4;
        int inicialPocionY = 4;
        King king = new King(true, new Position(inicialPocionX, inicialPocionY));
        char actual = king.getFigure();
        char expected = 'K';
        assertEquals(expected, actual);
    }
}