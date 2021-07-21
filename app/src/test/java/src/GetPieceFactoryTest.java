package src;

import org.junit.Test;
import src.Pieces.Piece;
import src.Utilities.GetPieceFactory;
import src.Utilities.Position;
import src.Utilities.TypePiece;

import static org.junit.Assert.assertEquals;

public class GetPieceFactoryTest {
    @Test
    public void getPawnFigurefromGetfactory() {
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        TypePiece name = TypePiece.PAWN;
        Piece pawn = getPieceFactory.getPiece(name, true, new Position(0, 0));
        char expected = 'P';
        char actual = pawn.getFigure();
        assertEquals(expected, actual);
    }

    @Test
    public void getQueenFigurefromGetfactory() {
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        TypePiece name = TypePiece.QUEEN;
        Piece queen = getPieceFactory.getPiece(name, true, new Position(6, 5));
        char expected = 'Q';
        char actual = queen.getFigure();
        assertEquals(expected, actual);
    }

    @Test
    public void getPositionXFromPiecefromGetfactory() {
        GetPieceFactory getPieceFactory = new GetPieceFactory();
        TypePiece name = TypePiece.PAWN;
        Piece pawn = getPieceFactory.getPiece(name, true, new Position(7, 7));
        int expected = 7;
        int actual = pawn.getPosX();
        assertEquals(expected, actual);
    }
}
