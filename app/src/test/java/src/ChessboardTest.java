package src;

import org.junit.Test;
import src.Pieces.Piece;
import src.Utilities.Chessboard;
import src.Utilities.Player;
import src.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static src.Utilities.Chessboard.DIMENSION;

public class ChessboardTest {

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

