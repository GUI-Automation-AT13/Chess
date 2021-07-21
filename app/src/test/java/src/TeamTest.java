package src;

import static org.junit.Assert.*;
import org.junit.Test;
import src.Pieces.Piece;
import src.Utilities.Chessboard;

public class TeamTest {
    @Test
    public void piecesAreCreatedForWhiteTeam() {
        Chessboard chessboard = new Chessboard();
        Piece piece = Chessboard.board[0][0];
        String expected = "BR";
        String actual = "" + piece.getColor() + piece.getFigure();
        assertEquals(expected, actual);
    }
    @Test
    public void piecesAreCreatedForBlackTeam() {
        Chessboard chessboard = new Chessboard();
        Piece piece = Chessboard.board[7][7];
        String expected = "WR";
        String actual = "" + piece.getColor() + piece.getFigure();
        assertEquals(expected, actual);
    }
}