package src.Utilities;

public class PositionTraductor {
    private static final int ASCII_CODE_FOR_A = 97;
    private static final int ASCII_CODE_FOR_0 = 48;

    /**
     * PositionTraductor switches from one notation to the other.
     * <p>
     * ALGEBRAIC                         MATRIX
     * 8| BR BH BB BQ BK BB BH BR      0| BR BH BB BQ BK BB BH BR
     * 7| BP BP BP BP BP BP BP BP      1| BP BP BP BP BP BP BP BP
     * 6|                              2|
     * 5|                              3|
     * 4|                          ==> 4|
     * 3|                              5|
     * 2| WP WP WP WP WP WP WP WP      6| WP WP WP WP WP WP WP WP
     * 1| WR WH WB WQ WK WB WH WR      7| WR WH WB WQ WK WB WH WR
     * ------------------------         -----------------------
     * a  b  c  d  e  f  g  h          0  1  2  3  4  5  6  7
     */

    /**
     * Constructor of Class.
     */
    public PositionTraductor() {
    }
    /**
     * Given an Algebraic notation (Eg: a5, b6) where the 1st char represents the column position and
     * the 2nd char represents the row position. Returns the corresponding indexes int a matrix for those values.
     * @param algebraicNotation
     * @return positions
     */
    public int[] getIndexNotation(final String algebraicNotation) {
        int[] positions = new int[2];
        //Chars received represents the column and row, will be cast to int and  will be subtracted its ascii value
        char characterCol = algebraicNotation.charAt(0);
        char characterRow = algebraicNotation.charAt(1);
        positions[0] = (int) characterCol - ASCII_CODE_FOR_A;
        positions[1] = Math.abs(((int) characterRow - ASCII_CODE_FOR_0) - Chessboard.DIMENSION);
        return positions;
    }

    /**
     * Returns the X value from an algebraic format position.
     * @param algebraicNotation
     * @return position x.
     */
    public static int getXIndexNotation(final String algebraicNotation) {
        char characterCol = algebraicNotation.charAt(0);
        return (int) characterCol - ASCII_CODE_FOR_A;
    }
    /**
     * Returns the Y value from an algebraic format position.
     * @param algebraicNotation
     * @return position y.
     */
    public static int getYIndexNotation(final String algebraicNotation) {
        char characterRow = algebraicNotation.charAt(1);
        return Math.abs(((int) characterRow - ASCII_CODE_FOR_0) - Chessboard.DIMENSION);
    }

    /**
     * Given 2 values that represent the row and col positions in a matrix. Return the corresponding
     * algebraic notation for that position.
     * @param colIndex
     * @param rowIndex
     * @return algebraic position.
     */
    public static String getAlgebraicNotation(final int colIndex, final int rowIndex) {
        //Adding column value in algebraic notation
        String algebraicNotation = String.valueOf((char) (colIndex + ASCII_CODE_FOR_A));
        //2nd value is row position
        int rowAlgebraic = Chessboard.DIMENSION - rowIndex;
        algebraicNotation += String.valueOf(rowAlgebraic);
        return algebraicNotation;
    }
}
