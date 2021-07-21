package src;

import org.junit.Test;
import src.Utilities.Chessboard;
import src.Utilities.Player;
import src.Utilities.Position;

import static org.junit.Assert.*;

public class ChessboardTest {
    @Test
    public void invalidQueneMoveTest() {
        Chessboard chessboard = new Chessboard();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("d1");
        Position target = new Position("d2");
        boolean expected= false;
        boolean actual = chessboard.movePiece(source,target,playerWhite);
        assertEquals(expected, actual);
    }
    @Test
    public void validMovePawnTest() {
        Chessboard chessboard = new Chessboard();
        Player playerWhite = new Player("Player1", true);
        Position source = new Position("b1");
        Position target = new Position("a3");
        boolean expected= true;
        boolean actual = chessboard.movePiece(source,target,playerWhite);
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
        boolean mov1 = chessboard.movePiece(source,target,playerWhite);
        boolean mov2 = chessboard.movePiece(m2source,m2target,playerWhite);
        boolean mov3 = chessboard.movePiece(m3source,m3target,playerWhite);
        boolean mov4 = chessboard.movePiece(m4source,m4target,playerWhite);
        boolean expected = true;
        Player winner = chessboard.kingTakenBy();
        boolean actual = winner.isWhite();
        assertEquals(expected, actual);
    }
    @Test
    public void kingTakenBy_returnPlayerWhite() {

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
    }
    @Test
    public void thereIsPiece_given_0_2_return_false() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessboard();
        Position position = new Position(0, 2);
        boolean expected = true;
        boolean actual = chessboard.thereIsPiece(position);
    }
}

