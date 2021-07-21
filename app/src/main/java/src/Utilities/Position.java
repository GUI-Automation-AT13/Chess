package src.Utilities;

import java.util.Objects;

public class Position {
    private int posX;
    private int posY;
    private String charAlg;

    /**
     * Constructor of the Class Position with X and Y.
     * @param xPos position in X.
     * @param yPos position in Y.
     */
    public Position(final int xPos, final int yPos) {
        this.posX = xPos;
        this.posY = yPos;
        this.charAlg = PositionTraductor.getAlgebraicNotation(posX, posY);
    }

    /**
     * Constructor of the Class Position with Algebraic char.
     * @param charAlgebraic position in X.
     */
    public Position(final String charAlgebraic) {
        this.charAlg = charAlgebraic;
        this.posX = PositionTraductor.getXIndexNotation(charAlgebraic);
        this.posY = PositionTraductor.getYIndexNotation(charAlgebraic);
    }

    /**
     * Return Position X.
     * @return posX
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * Return Position Y.
     * @return posY
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * Return algebraic char.
     * @return charAlg
     */
    public String getCharAlg() {
        return this.charAlg;
    }

    /**
     * Compare if objects positions are equals.
     * @param o object to compare with.
     * @return true if equals, false if not.
     */
    @Override
    public boolean equals(final Object o) {
        Position position = (Position) o;
        return posX == position.posX && posY == position.posY && Objects.equals(charAlg, position.charAlg);
    }


}
