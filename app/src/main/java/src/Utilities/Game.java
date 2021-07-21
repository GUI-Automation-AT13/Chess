package src.Utilities;

import src.Views.ChessboardView;

import javax.swing.*;
import java.util.Scanner;

public class Game {
    private int gameId;
    private Player playerWhite;
    private Player playerBlack;
    private Chessboard chessboard;
    private boolean turn = true; // true = white, false = black
    private final boolean PLAYER_WHITE = true;
    private final boolean PLAYER_BLACK = false;
    private boolean gameFinished = false;
    private ChessboardView chessboardView;
    private Scanner sc;
    /**
     * Game represents a match between 2 players and controls the cycle of turns.
     * @param id of game.
     */
    public Game(final int id) {
        this.gameId = id;
        chessboard = new Chessboard();
        chessboard.initializeChessboard();
        playerWhite = new Player("Player1", PLAYER_WHITE);
        playerBlack = new Player("Player2", PLAYER_BLACK);
        chessboardView = new ChessboardView(this);
    }
    /**
     * Initializes the game logic.
     */
    public void gameInit() {
        chessboard.printBoard();
        while (!gameFinished) {
            playerTurn(playerWhite);
            if (chessboard.kingTakenBy() != null) {
                gameFinished = true;
                int action = JOptionPane.showConfirmDialog(null,
                        "New game",
                        "Cancel",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if(action == JOptionPane.YES_OPTION){
                    restartGame();
                }
                break;
            }
            chessboardView.setPositionSelected(null);
            playerTurn(playerBlack);
            chessboardView.setPositionSelected(null);
        }
    }

    /**
     * Set player turn and player move.
     * @param player player turn.
     */
    public void playerTurn(final Player player) {
        boolean hasMoved = false;
        Position toGetpossibles = null;
        Position sourceMove = null;
        Position targetMove = null;
        while(!hasMoved) {
            toGetpossibles = chessboardView.getPositionSelected();
            System.out.print("");
            if(toGetpossibles != null && chessboard.thereIsPiece(toGetpossibles) && chessboard.getPiece(toGetpossibles).getColorWhite() == player.isWhite()) {
                chessboardView.showValidMoves(chessboard.getValidMoves(toGetpossibles, player));
                chessboardView.setPositionSelected(null);
                sourceMove = toGetpossibles;
            } else {
                if (toGetpossibles != null && (chessboard.getPiece(toGetpossibles) == null || chessboard.getPiece(toGetpossibles).getColorWhite() != player.isWhite())) {
                    targetMove = toGetpossibles;
                    boolean moved = chessboard.movePiece(sourceMove, targetMove, player);
                    if (moved == true) {
                        chessboardView.updateChessboardView();
                        chessboardView.setPositionSelected(null);
                        hasMoved = true;
                    }
                }
            }
        }
    }

    /**
     * Restart the game.
     */
    public void restartGame() {
        chessboard.resetChessBoard();
        chessboard.initializeChessboard();
        chessboardView.updateChessboardView();
        chessboard.setWinnerNull();
        gameFinished = false;
        gameInit();

    }
}
