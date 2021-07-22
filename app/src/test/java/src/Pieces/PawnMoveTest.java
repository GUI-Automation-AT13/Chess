package src.Pieces;

import org.junit.Test;
import src.PiecesMoves.PawnMove;
import src.Utilities.Chessboard;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PawnMoveTest {

    private void chessboardScenario() {
        Chessboard chessboard = new Chessboard();
        int dimensionBoard = 8;
        chessboard.board = new Piece[dimensionBoard][dimensionBoard];
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        chessboard.board[2][4] = getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(4,2));
        chessboard.board[5][6] = getPieceFactory.getPiece(TypePiece.HORSE, false, new Position(6,5));
        chessboard.board[5][4] = getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(4,5));
        chessboard.board[4][1] = getPieceFactory.getPiece(TypePiece.BISHOP, false, new Position(1,4));
        chessboard.board[6][2] = getPieceFactory.getPiece(TypePiece.ROOK, false, new Position(2,6));
    }
    /**
     *      ---------------------------------------
     * 8 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 7 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 6 |    |    |    |    | WP |    |    |    |
     *   |---------------------------------------
     * 5 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 4 |    |    |    |    |    |    |    |    |
     *   |---------------------------------------
     * 3 |    |    |    |    | BB |    | BP |    |
     *   |---------------------------------------
     * 2 |    |    | BR |    |    | WP |    |    |
     *   |---------------------------------------
     * 1 |    | WP |    |    |    |    |    |    |
     *   |---------------------------------------
     *     a    b    c    d    e    f    g    h
     */
    @Test
    public void getValidMovesInitialPawnAlone_E6_TwoMoves() {
        chessboardScenario();
        Piece pawn = Chessboard.board[2][4];
        List<Position> validMoves = pawn.getValidMoves();
        String expected = "e8 e7 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesInitialPawnOneEnemy_B1_TwoMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(1,7)));
        Piece pawn = Chessboard.board[7][1];
        List<Position> validMoves = pawn.getValidMoves();
        String expected = "b3 b2 c2 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void getValidMovesMovedPawnTwoEnemies_F2_TreeMoves() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(5,6)));
        Piece pawn = Chessboard.board[6][5];
        pawn.setIsMoved(true);
        List<Position> validMoves = pawn.getValidMoves();
        String expected = "f3 e3 g3 " + "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test
    public void pawnIsBlack_InputTrue_B() {
        int initPosX = 4;
        int initPosY = 4;
        Pawn pawn = new Pawn(false, new Position(initPosX, initPosY));
        char actual = pawn.getColor();
        char expected = 'B';
        assertEquals(expected, actual);
    }
    @Test
    public void pawnIsWhite_InputTrue_W() {
        int initPosX = 4;
        int initPosY = 4;
        Pawn pawn = new Pawn(true, new Position(initPosX, initPosY));
        char actual = pawn.getColor();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    public void getFigurePawn_ChoseKing_K() {
        int initPosX = 4;
        int initPosY = 4;
        Pawn pawn = new Pawn(true, new Position(initPosX, initPosY));
        char actual = pawn.getFigure();
        char expected = 'P';
        assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pawnCantMoveOutsideOfTheBoard() {
        int initPosX = 15;
        int initPosY = 15;
        Piece pawn = Chessboard.board[initPosY][initPosX];
        pawn.setIsMoved(true);
        List<Position> validMoves = pawn.getValidMoves();
    }

    @Test
    public void spaceIsNotEmpty() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(5,6)));
        Piece pawn = Chessboard.board[6][5];
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position("e3")));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position("g3")));
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position("f3")));
        pawn.setIsMoved(true);
        List<Position> validMoves = pawn.getValidMoves();
        String expected = "";
        String actual = "";
        for (Position pos : validMoves) {
            actual += (pos.getCharAlg()) + " ";
        }
        assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pawnIsNotInLimits() {
        chessboardScenario();
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        Chessboard.setPiece(getPieceFactory.getPiece(TypePiece.PAWN, true, new Position(11,12)));
        Piece pawn = Chessboard.board[12][11];
        pawn.setIsMoved(true);
    }
}