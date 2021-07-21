package src.Views;


import src.Pieces.Piece;
import src.Utilities.Chessboard;
import src.Utilities.Game;
import src.Utilities.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChessboardView extends JFrame {
    private static final int SIZE_IMAGE = 80;
    private static final int SIZE_WINDOW_WIDTH = Chessboard.DIMENSION * SIZE_IMAGE;
    private static final int SIZE_WINDOW_HEIGHT = Chessboard.DIMENSION * SIZE_IMAGE;
    private static JLabel[][] boardView = new JLabel[Chessboard.DIMENSION][Chessboard.DIMENSION];
    private Game game;
    private Color colorFrame = new Color(96, 96, 96);
    private Color colorPositionLabels = new Color(224, 224, 224);
    private final int ASCII_CODE_LOWER_CASE_A = 97;
    private JPanel panelCentral;
    private Position positionSelected;

    /**
     * Interface to display changes in the chessboard
     */
    public ChessboardView(Game game) {
        this.game = game;
        setSize(830, 750);
        setTitle("AT13-CHESS");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel panelTop;
        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(820,40));
        panelTop.setBackground(colorFrame);

        JPanel panelBottom;
        panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(820,70));
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setBackground(colorFrame);
        JPanel colLabels = new JPanel();
        JPanel firstPlayer = new JPanel();
        colLabels.setPreferredSize(new Dimension(820, 30));
        firstPlayer.setPreferredSize(new Dimension(820, 40));
        colLabels.setLayout(new FlowLayout(FlowLayout.LEFT));
        colLabels.setBackground(colorFrame);
        firstPlayer.setBackground(colorFrame);
        panelBottom.add(colLabels);
        panelBottom.add(firstPlayer);
        JLabel labelCorner = new JLabel();
        labelCorner.setPreferredSize(new Dimension(20,30));
        labelCorner.setForeground(colorPositionLabels);
        colLabels.add(labelCorner);

        JPanel panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(30,640));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(colorFrame);

        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(160,640));
        panelRight.setBackground(colorFrame);

        this.panelCentral = new JPanel();
        this.panelCentral.setLayout(new GridLayout(Chessboard.DIMENSION, Chessboard.DIMENSION));
        this.panelCentral.setPreferredSize(new Dimension(640, 640));

        for (int i = Chessboard.DIMENSION; i > 0; i--) {
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(30,80));
            label.setText(String.valueOf(" " + i));
            label.setForeground(colorPositionLabels);
            label.setFont(new Font("Verdana", Font.BOLD, 12));
            panelLeft.add(label);

            JLabel labelCol = new JLabel();
            labelCol.setPreferredSize(new Dimension(75,30));
            labelCol.setText("       " + String.valueOf(Character.toString(ASCII_CODE_LOWER_CASE_A + (8 - i))));
            labelCol.setForeground(colorPositionLabels);
            labelCol.setFont(new Font("Verdana", Font.BOLD, 12));
            colLabels.add(labelCol);
        }

        addCellsToBoard();
        add(panelCentral,BorderLayout.CENTER);
        add(panelTop,BorderLayout.NORTH);
        add(panelBottom,BorderLayout.SOUTH);
        add(panelLeft,BorderLayout.WEST);
        add(panelRight,BorderLayout.EAST);
        initializeChessboard();
    }

    /**
     * Add Boardcells to the interface according to the board cell colors
     */
    public void addCellsToBoard() {
        boolean lightColorCell = true;
        for (int row = 0; row < Chessboard.DIMENSION; row++) {
            for (int col = 0; col < Chessboard.DIMENSION; col++) {
                BoardCell cell = new BoardCell(this, lightColorCell, col, row);
                lightColorCell = !lightColorCell;
                if (col == Chessboard.DIMENSION - 1) {
                    lightColorCell = !lightColorCell;
                }
                boardView[row][col] = cell;
                this.panelCentral.add(cell);
            }
        }
    }
    public void initializeChessboard() {
        updateChessboardView();
    }
    public void updateChessboardView() {
        for (int row = 0; row < Chessboard.DIMENSION; row++) {
            for (int col = 0; col < Chessboard.DIMENSION; col++) {
                boardView[row][col].setIcon(null);
                if (Chessboard.board[row][col] != null) {
                    boardView[row][col].setIcon(Chessboard.board[row][col].getImage());
                }
            }
        }
    }

    /**
     * Display the valid moves of a selected cell with a piece on it.
     */
    public void showValidMoves(List<Position> validMoves) {
        updateChessboardView();
        for (Position pos : validMoves) {
            Piece piece = Chessboard.getPiece(pos);
            if (piece == null) {
                boardView[pos.getPosY()][pos.getPosX()].setIcon(new ImageIcon("src/main/java/resources/Dot.png"));
            }
        }
    }

    /**
     * Sets the selected position caught from a cellboard mouseListener.
     */
    public void setPositionSelected(Position position) {
        this.positionSelected = position;
    }

    /**
     * Returns the selected position.
     */
    public Position getPositionSelected() {
        return positionSelected;
    }
}
