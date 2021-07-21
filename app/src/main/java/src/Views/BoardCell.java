package src.Views;


import src.Utilities.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardCell extends JLabel {
    private final int CELL_DIMENSION = 80;
    private final Color lightColor = new Color(255, 232, 208);
    private final Color darkColor = new Color(196, 150, 105);
    private Position position;

    /**
     * Cellboard represents a cell in the chessboard and captures the selections made on the board
     */
    public BoardCell(ChessboardView boardView, boolean isLightColor, int x, int y) {
        if (isLightColor) {
            setBackground(lightColor);
        } else {
            setBackground(darkColor);
        }
        position = new Position(x, y);
        setPreferredSize(new Dimension(CELL_DIMENSION, CELL_DIMENSION));
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                boardView.setPositionSelected(position);
                System.out.println("Clicked");
            }
        });
    }
}
