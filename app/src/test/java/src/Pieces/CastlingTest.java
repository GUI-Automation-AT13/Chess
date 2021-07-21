package src.Pieces;

import org.junit.Test;
import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.PiecesMoves.Castling;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CastlingTest {
    private void chessboardScenario() {
        Chessboard chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(0, 0)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(7, 0)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(0, 7)));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.ROOK, true, new Position(7, 7)));
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
    public void getPossibleMoves_CastlingBlackKing_return_g8_c8() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, false, new Position(4, 0)));
        Piece king = Chessboard.board[0][4];
        Castling castling = new Castling();
        List<Position> validMoves = castling.getPossibleMoves(king);
        String expected = "g8 c8 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }
    @Test
    public void getValidMovesCastlingWhiteKing_return_g1_c1() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.KING, false, new Position(4, 7)));
        Piece king = Chessboard.board[7][4];
        Castling castling = new Castling();
        List<Position> validMoves = castling.getPossibleMoves(king);
        String expected = "g1 c1 ";
        String actual = "";
        for (Position pos : validMoves) {
            actual += String.valueOf(pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }
    @Test
    public void isInLimits_8_returnFalse() {
        Castling castling = new Castling();
        boolean expected = false;
        boolean actual = castling.isInLimits(8);;
        assertEquals(expected, actual);
    }
    @Test
    public void isInLimits_0_returnTrue() {
        Castling castling = new Castling();
        boolean expected = true;
        boolean actual = castling.isInLimits(0);;
        assertEquals(expected, actual);
    }
    @Test
    public void isSpaceWithEnemy_WhitePieceAndIsWhite_returnFalse() {
        Castling castling = new Castling();
        Piece rook = new Rook(true, new Position(0, 0));
        boolean expected = false;
        boolean actual = castling.isSpaceWithEnemy(rook, true);
        assertEquals(expected, actual);
    }
    @Test
    public void isSpaceWithEnemy_BlackPieceAndIsBlack_returnTrue() {
        Castling castling = new Castling();
        Piece rook = new Rook(false, new Position(0, 0));
        boolean expected = true;
        boolean actual = castling.isSpaceWithEnemy(rook, true);
        assertEquals(expected, actual);
    }
}
