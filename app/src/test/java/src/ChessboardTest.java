package src;

import org.junit.Test;
import src.Pieces.Piece;
import src.Utilities.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static src.Utilities.Chessboard.DIMENSION;

public class ChessboardTest {
    private Chessboard chessboard;
    private GetPieceFactory getPieceFactory;

    private void chessboardScenario() {
        chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(0, 0)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(7, 0)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, false, new Position(4, 0)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(0, 7)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(7, 7)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(4, 7)));
        /**
         *   ---------------------------------------
         * 8 | BR |    |    |    | BK |    |    | BR |
         *   |---------------------------------------
         * 7 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 6 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 5 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 4 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 3 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 2 |    |    |    |    |    |    |    |    |
         *   |---------------------------------------
         * 1 | WR |    |    |    | WK |    |    | WR |
         *   |---------------------------------------
         *     a    b    c    d    e    f    g    h
         */
    }
    @Test
    public void playingWhite_whitePlayerCanMoveBlackPiece_false2() {
        chessboardScenario();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.QUEEN, false, new Position(4, 0)));
        Player playerWhite = new Player("Player1", false);
        Position source = new Position("e8");
        Position target = new Position("c3");
        boolean actual=chessboard.movePiece(source, target, playerWhite);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playingWhite_whitePlayerCanMoveBlackPiece_false() {
        chessboardScenario();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("e8");
        Position target = new Position("c8");
        boolean actual=chessboard.movePiece(source, target, playerWhite);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playingBlack_isValidateCastling_true() {
        chessboardScenario();
        Player playerWhite = new Player("Player1", false);
        Position source = new Position("e8");
        Position target = new Position("c8");
        boolean actual=chessboard.movePiece(source, target, playerWhite);
        boolean expected = true;
        assertEquals(expected, actual);
    }


    @Test
    public void selectsEmptySpace_return_emptyValidMoves() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessboard();
        Player playerBlack = new Player("PlayerBlack", false);
        Position position = new Position(4, 4);
        List<Position> actual = chessboard.getValidMoves(position,playerBlack );
        List<Position> expected = new ArrayList<Position>();
        assertEquals(expected, actual);
    }

    @Test
    public void setsNewTableClean_withOutPiece_null() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessboard();
        Piece[][] expected = new Piece[DIMENSION][DIMENSION];
        Piece[][] actual = chessboard.resetChessBoard();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidQueneMoveTest() {
        Chessboard chessboard = new Chessboard();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("d1");
        Position target = new Position("d2");
        boolean expected = false;
        boolean actual = chessboard.movePiece(source, target, playerWhite);
        assertEquals(expected, actual);
    }

    @Test
    public void validMovePawnTest() {
        Chessboard chessboard = new Chessboard();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("b1");
        Position target = new Position("a3");
        boolean expected = true;
        boolean actual = chessboard.movePiece(source, target, playerWhite);
        assertEquals(expected, actual);
    }

    @Test
    public void movePiece_whitePiece_takesKing() {
        Chessboard chessboard = new Chessboard();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("e2");
        Position target = new Position("e3");
        Position m2source = new Position("d1");
        Position m2target = new Position("f3");
        Position m3source = new Position("f3");
        Position m3target = new Position("f7");
        Position m4source = new Position("f7");
        Position m4target = new Position("e8");
        chessboard.movePiece(source, target, playerWhite);
        chessboard.movePiece(m2source, m2target, playerWhite);
        chessboard.movePiece(m3source, m3target, playerWhite);
        chessboard.movePiece(m4source, m4target, playerWhite);
        boolean expected = true;
        Player winner = chessboard.kingTakenBy();
        boolean actual = winner.isWhite();
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMoves_givenBlackPlayerAndWhitePiecePosition_return_null() {
        Chessboard chessboard = new Chessboard();
        Player playerBlack = new Player("PlayerBlack", false);
        Position position = new Position(0, 7);
        boolean expected = true;
        boolean actual;
        if (chessboard.getValidMoves(position, playerBlack) == null) {
            actual = true;
        } else {
            actual = false;
        }
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsPiece_given_0_1_return_true() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessboard();
        Position position = new Position(0, 1);
        boolean expected = true;
        boolean actual = chessboard.thereIsPiece(position);
        assertEquals(expected, actual);
    }

    @Test
    public void thereIsPiece_given_0_2_return_false() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessboard();
        Position position = new Position(0, 2);
        boolean expected = false;
        boolean actual = chessboard.thereIsPiece(position);
        assertEquals(expected, actual);
    }
}

