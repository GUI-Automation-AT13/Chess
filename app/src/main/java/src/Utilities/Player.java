package src.Utilities;

public class Player {
    private String name;
    private boolean isWhite;
    private String color;
    private String COLOR_WHITE = "White";
    private String COLOR_BLACK = "Black";

    /**
     * Constructor of Player class.
     * @param namePlayer of Player.
     * @param isWhitePlayer Color of Player.
     */
    public Player(final String namePlayer, final boolean isWhitePlayer) {
        this.name = namePlayer;
        this.isWhite = isWhitePlayer;
        if (isWhite) {
            this.color = COLOR_WHITE;
        } else {
            this.color = COLOR_BLACK;
        }
    }

    /**
     * Return if color of Player is White.
     * @return true if white, false if not.
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Get color of Player.
     * @return color Player.
     */
    public String getColor() {
        return color;
    }
}
